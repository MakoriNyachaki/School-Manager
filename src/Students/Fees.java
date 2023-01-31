/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Start_a_Way
 */
public class Fees extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    /**
     * Creates new form Fees
     */
    public Fees() {
        super("");
        initComponents();
        conn = new DbConnect().DbConnect();
    }

    private boolean checkInputs() {
        if (fadm.getText().isEmpty() || fname.getText().isEmpty() || fclass.getText().isEmpty()
                || fstrm.getText().isEmpty()
                || paid.getText().isEmpty() || fdate.getDate() == null
                || modeofPayment.getSelectedIndex() == -1) {
            return false;
        } else {
            try {
                return true;
            } catch (Exception e) {
            }
        }
        return false;
    }

    public void insert() {
        String sql = "INSERT INTO `fees`(`admNo`, `Name`, `form`, `stream`, "
                + "`amountPaid`, `modeofPayment`, `transactionNumber`, `paidDate`)"
                + " VALUES (?,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fadm.getText());
            pstmt.setString(2, fname.getText());
            pstmt.setString(3, fclass.getText());
            pstmt.setString(4, fstrm.getText());
            pstmt.setString(5, paid.getText());
            pstmt.setString(6, (String) modeofPayment.getSelectedItem());
            pstmt.setString(7, transact.getText());
            pstmt.setString(8, (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(fdate.getDate())));

            int f = pstmt.executeUpdate();
            if (f > 0) {
                JOptionPane.showMessageDialog(null, "Fees paid Succesfully", "ees Paid", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Fees paid failure", "failure", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
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

        jPanel1 = new javax.swing.JPanel();
        paid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fupd = new javax.swing.JButton();
        fadm = new javax.swing.JTextField();
        fsrch = new javax.swing.JButton();
        fname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fexit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fstrm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bal = new javax.swing.JTextField();
        fclass = new javax.swing.JTextField();
        btnBal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fpay = new javax.swing.JButton();
        modeofPayment = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        transact = new javax.swing.JTextField();
        fdate = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153), 2), "FEE PAYMENT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 1, 18))); // NOI18N

        paid.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        paid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paidActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Date of Payment");

        fupd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fupd.setText("Update");
        fupd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fupdActionPerformed(evt);
            }
        });

        fadm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        fsrch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fsrch.setText("Search");
        fsrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fsrchActionPerformed(evt);
            }
        });

        fname.setEditable(false);
        fname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Adm No.");

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("Mode of Payment");

        fexit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fexit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Left-icon24.png"))); // NOI18N
        fexit.setText("Back");
        fexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fexitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Amount Paid");

        fstrm.setEditable(false);
        fstrm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Class");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Name");

        bal.setEditable(false);
        bal.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        bal.setForeground(new java.awt.Color(255, 0, 51));

        fclass.setEditable(false);
        fclass.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        btnBal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBal.setText("Balance");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Stream");

        fpay.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        fpay.setText("Pay");
        fpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fpayActionPerformed(evt);
            }
        });

        modeofPayment.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        modeofPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bank Deposit", "Cheque", "Cash", "Mpesa" }));
        modeofPayment.setSelectedIndex(-1);

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Transaction No.");

        transact.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        transact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fdate, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(transact)
                        .addComponent(modeofPayment, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paid, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fadm, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fname, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fclass, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fstrm, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnBal)
                                .addGap(152, 152, 152))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(fsrch)
                                .addGap(157, 157, 157))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fupd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fpay)
                        .addGap(18, 18, 18)
                        .addComponent(fexit)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(btnBal))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(fsrch))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fadm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(fclass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(fstrm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(paid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modeofPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fupd)
                                .addComponent(fpay)
                                .addComponent(fexit))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(transact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(fdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(623, 393));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void paidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paidActionPerformed

    private void fupdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fupdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fupdActionPerformed

    private void fexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fexitActionPerformed
        setVisible(false);
        Home h = new Home();
        h.setVisible(true);
        h.pack();
        this.dispose();
    }//GEN-LAST:event_fexitActionPerformed

    private void transactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactActionPerformed

    private void fpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fpayActionPerformed
        if (!checkInputs()) {
            JOptionPane.showMessageDialog(null, "Blanks, Fill in the blank"
                    + " fields and try again", "Blanks", JOptionPane.ERROR_MESSAGE);

        } else {
            insert();
        }
    }//GEN-LAST:event_fpayActionPerformed

    private void fsrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fsrchActionPerformed
        String sql = "SELECT `admNo`, `otherName`, `Form`, `Stream`FROM `student` WHERE `admNo`=? ";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, fadm.getText());

            rs = pstmt.executeQuery();
            if (rs.next()) {
                fname.setText(rs.getString("otherName"));
                fclass.setText(rs.getString("Form"));
                fstrm.setText(rs.getString("Stream"));
                JOptionPane.showMessageDialog(null, "Search successful, Student found");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_fsrchActionPerformed

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
            java.util.logging.Logger.getLogger(Fees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Fees().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bal;
    private javax.swing.JButton btnBal;
    private javax.swing.JTextField fadm;
    private javax.swing.JTextField fclass;
    private com.toedter.calendar.JDateChooser fdate;
    private javax.swing.JButton fexit;
    private javax.swing.JTextField fname;
    private javax.swing.JButton fpay;
    private javax.swing.JButton fsrch;
    private javax.swing.JTextField fstrm;
    private javax.swing.JButton fupd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> modeofPayment;
    private javax.swing.JTextField paid;
    private javax.swing.JTextField transact;
    // End of variables declaration//GEN-END:variables
}