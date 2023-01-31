/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import Students.DbConnect;
import java.awt.*;
import java.awt.print.PrinterException;
import java.sql.*;
import java.text.MessageFormat;
import javax.swing.*;
import javax.swing.text.Document;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Start_a_Way
 */
public class Search_Book extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    /**
     * Creates new form Search_Book
     */
    public Search_Book() {
        super("Search_Book");
        initComponents();
        conn = new DbConnect().DbConnect();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        bkTitle = new javax.swing.JTextField();
        srchBook = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bksTable = new javax.swing.JTable();
        printPdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Title");

        bkTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkTitleActionPerformed(evt);
            }
        });
        bkTitle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bkTitleKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bkTitleKeyReleased(evt);
            }
        });

        srchBook.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        srchBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Search-icon32.png"))); // NOI18N
        srchBook.setText("Search Book");
        srchBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchBookActionPerformed(evt);
            }
        });

        bksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Library Number", "Title", "ISBN", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(bksTable);

        printPdf.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        printPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/pdf-icon32.png"))); // NOI18N
        printPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printPdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 24, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(52, 52, 52)
                        .addComponent(bkTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(srchBook)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(printPdf)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(bkTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(srchBook))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(printPdf)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(672, 463));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bkTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bkTitleActionPerformed

    private void srchBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchBookActionPerformed
        if (bkTitle.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Book Title is Empty, Enter Title and Search",
                    "Title Blank", JOptionPane.ERROR_MESSAGE);
            bkTitle.setBackground(Color.red);
        } else {
            String sql = "SELECT book.`libraryNumber`, book.`ISBN`, book.`Title`,"
                    + "  book.`Author`, book.`Subject`,"
                    + "book.`Year`, book.`Publisher`, `regDate`"
                    + "  FROM `book` LEFT JOIN  `borrow_book`"
                    + " ON book.libraryNumber != borrow_book.libraryNumber"
                    + " WHERE book.libraryNumber != borrow_book.libraryNumber"
                    + " AND book.`Title`=? OR borrow_book.`Title`=null";
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, bkTitle.getText());

                rs = pstmt.executeQuery();
                bksTable.setModel(DbUtils.resultSetToTableModel(rs));

                JOptionPane.showMessageDialog(null, "Search Book Availabe Complete",
                        "Book Available", JOptionPane.INFORMATION_MESSAGE);

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
                JOptionPane.showMessageDialog(null, "Search Book Complete. Book Not Found",
                        "Book Not Found", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_srchBookActionPerformed

    private void bkTitleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bkTitleKeyReleased
        bkTitle.setBackground(Color.white);
    }//GEN-LAST:event_bkTitleKeyReleased

    private void bkTitleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bkTitleKeyPressed

    }//GEN-LAST:event_bkTitleKeyPressed

    private void printPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printPdfActionPerformed
//        String path = "";
//        JFileChooser jc = new JFileChooser();
//        jc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        int x = jc.showSaveDialog(this);
//        if (x == JFileChooser.APPROVE_OPTION) {
//            path = jc.getSelectedFile().getPath();
//        } 
//        Document doc = new Document(); 
//        
//       
//        
//        
//        try {
//            PdfWriter.getInstance((com.itextpdf.text.Document) doc, new FileOutputStream(path + "Available Books.pdf"));
//            
//           
//        } catch (FileNotFoundException | DocumentException ex) {
//            Logger.getLogger(Search_Book.class.getName()).log(Level.SEVERE, null, ex);
//        }

        MessageFormat header = new MessageFormat("Avaiable Copies");
        MessageFormat footer = new MessageFormat("Page{0, number, integer}");
        try {
            bksTable.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException e) {
            System.err.format("Can not print %%n", e.getMessage());
        }
    }//GEN-LAST:event_printPdfActionPerformed

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
            java.util.logging.Logger.getLogger(Search_Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Search_Book().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bkTitle;
    private javax.swing.JTable bksTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton printPdf;
    private javax.swing.JButton srchBook;
    // End of variables declaration//GEN-END:variables
}