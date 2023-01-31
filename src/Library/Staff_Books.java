/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import Students.DbConnect;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Start_a_Way
 */
public class Staff_Books extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /**
     * Creates new form Staff_Books
     */
    public Staff_Books() {
        super("Staff_Books");
        initComponents();
        conn = new DbConnect().DbConnect();
    }

    public boolean checkInputs() {
        if (lno.getText().isEmpty() || bkTitle.getText().isEmpty()
                || staffID.getText().isEmpty() || staffName.getText().isEmpty()
                || staffDate.getDate() == null) {
            return false;
        } else {
            try {
                return true;
            } catch (Exception e) {
            }
            return false;
        }
    }

    public void issueBook() {
        String sql = "INSERT INTO `staff_issued`(`libraryNumber`, `book_Title`,"
                + " `staffNo`, `staff_Name`, `issueDate`) VALUES (?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, lno.getText());
            pstmt.setString(2, bkTitle.getText());
            pstmt.setString(3, staffID.getText());
            pstmt.setString(4, staffName.getText());
            pstmt.setString(5, (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(staffDate.getDate())));

            int i = pstmt.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(null, "Book issued successfully to:\t " + staffName.getText() + "!",
                        "Issued", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void returnBook() {
        String sql = "INSERT INTO `staff_returned`(`libraryNumber`, `book_Title`, "
                + "`staffNo`, `staff_Name`, `returnDate`) VALUES (?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, lno.getText());
            pstmt.setString(2, bkTitle.getText());
            pstmt.setString(3, staffID.getText());
            pstmt.setString(4, staffName.getText());
            pstmt.setString(5, (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(staffDate.getDate())));

            int e = pstmt.executeUpdate();
            if (e > 0) {
                JOptionPane.showMessageDialog(null, "Book returned successfully by:\t" + staffName.getText() + "!",
                        "Returned successfully", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Staff_Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void srchBook() {
        try {
            String sql = "SELECT * FROM `book` WHERE `libraryNumber`=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, lno.getText());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                bkTitle.setText(rs.getString("Title"));
                JOptionPane.showMessageDialog(null, "Book found. Search successful!",
                        "Found", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Book not found, Check Library "
                        + "number and try again.", "Not Found", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Staff_Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void del() {
        String sql = "DELETE FROM `staff_issued` WHERE `libraryNumber`=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, lno.getText());

            pstmt.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void srchStaff() {
        try {
            String sql = "SELECT * FROM `staff` WHERE `staffNo`=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, staffID.getText());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                staffName.setText(rs.getString("Name"));
                JOptionPane.showMessageDialog(null, "Book found. Search successful!",
                        "Found", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Staff not found, Check staff "
                        + "number and try again.", "Not Found", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Staff_Books.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chckRecord() {
        String sql = "SELECT * FROM `staff_issued` WHERE `libraryNumber` = ? AND `staffNo` =?";
        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, lno.getText());
            pstmt.setString(2, staffID.getText());

            rs = pstmt.executeQuery();
            boolean recordAdded = false;
            while (rs.next()) {
                recordAdded = true;
            }
            if (recordAdded) {
                returnBook();
                del();
            } else {
                JOptionPane.showMessageDialog(null, "Book Does Not Exists", "Not Found",
                        JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Staff_Books.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        srch = new javax.swing.JButton();
        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        issue = new javax.swing.JButton();
        staffName = new javax.swing.JTextField();
        staffID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ret = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        staffDate = new com.toedter.calendar.JDateChooser();
        bkTitle = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel6.setText("STAFF BOOK MANAGEMENT");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)), "Staff Book Details", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 3, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Library Number");

        srch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        srch.setText("Search");
        srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchActionPerformed(evt);
            }
        });

        home.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        home.setText("Back");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Staff ID");

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Book Title");

        issue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        issue.setText("Issue");
        issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueActionPerformed(evt);
            }
        });

        staffName.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        ret.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ret.setText("Return");
        ret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Date");

        bkTitle.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bkTitle)
                    .addComponent(staffDate, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(lno))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(staffID)
                    .addComponent(staffName, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(srch)
                .addGap(18, 18, 18)
                .addComponent(issue)
                .addGap(26, 26, 26)
                .addComponent(ret)
                .addGap(18, 18, 18)
                .addComponent(home)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(lno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(bkTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(staffDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(srch)
                    .addComponent(issue)
                    .addComponent(ret)
                    .addComponent(home))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(183, 183, 183))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        setSize(new java.awt.Dimension(627, 295));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void srchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchActionPerformed
        if (lno.getText() != null || !lno.getText().isEmpty()
                && staffID.getText() != null || !staffID.getText().isEmpty()) {
            srchBook();
            srchStaff();
        } else if (lno.getText() != null || !lno.getText().isEmpty() && staffID.getText() == null) {
            try {
                String sql = "";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, lno.getText());
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    bkTitle.setText(rs.getString(""));
                    staffID.setText(rs.getString(""));
                    staffName.setText(rs.getString(""));
                    JOptionPane.showMessageDialog(null, "Book found. Search successful!",
                            "Found", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Book not Issued, Check details "
                            + "and try again.", "Not Found", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(Staff_Books.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Wrong details, check and try again!",
                    "Incorrect Ddetails", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_srchActionPerformed

    private void issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueActionPerformed
        if (checkInputs()) {
            issueBook();
        } else {
            JOptionPane.showMessageDialog(null, "Failed. Book not issued",
                    "Not Issued!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_issueActionPerformed

    private void retActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retActionPerformed

        String sql = "SELECT * FROM `staff_issued` WHERE `libraryNumber`=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, lno.getText());

            rs = pstmt.executeQuery();
            if (rs.next()) {
                bkTitle.setText(rs.getString("book_Title"));
                staffID.setText(rs.getString("staffNo"));
                staffName.setText(rs.getString("staff_Name"));

                JOptionPane.showMessageDialog(null, "Details found. Search successful",
                        "Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Details not found. Search unsuccessful",
                        "Failed", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Staff_Books.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (checkInputs()) {
            chckRecord();
        } else {
            JOptionPane.showMessageDialog(null, "Failed. Book not returned",
                    "Not Returned!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_retActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Staff_Books().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bkTitle;
    private javax.swing.JButton home;
    private javax.swing.JButton issue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lno;
    private javax.swing.JButton ret;
    private javax.swing.JButton srch;
    private com.toedter.calendar.JDateChooser staffDate;
    private javax.swing.JTextField staffID;
    private javax.swing.JTextField staffName;
    // End of variables declaration//GEN-END:variables
}
