/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import Students.DbConnect;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Start_a_Way
 */
public class Tests extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;

    /**
     * Creates new form Tests
     */
    public Tests() {
        super("Tests");
        initComponents();
        conn = new DbConnect().DbConnect();
    }

    private boolean checkInputs() {
        if (adm.getText().isEmpty() || sname.getText().isEmpty()
                || gender.getText().isEmpty() || frm.getText().isEmpty()
                || strm.getText().isEmpty() || term.getSelectedIndex() == -1
                || exdate.getDate() == null) {
            return false;
        } else {
            try {
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public void endinsert() {
        String sql = "INSERT INTO `endterm`(`admNo`, `Name`, `Gender`, `Form`, "
                + "`Stream`, `Term`, `Mat`, `Eng`, `Kis`, `Bio`, `Chem`, `Phy`, "
                + "`His`, `Geo`, `Cre`, `GroupIV`, `GroupV`, `examDate`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adm.getText());
            pstmt.setString(2, sname.getText());
            pstmt.setString(3, gender.getText());
            pstmt.setString(4, frm.getText());
            pstmt.setString(5, strm.getText());
            pstmt.setString(6, (String) term.getSelectedItem());
            pstmt.setString(7, mat.getText());
            pstmt.setString(8, eng.getText());
            pstmt.setString(9, swa.getText());
            pstmt.setString(10, bio.getText());
            pstmt.setString(11, che.getText());
            pstmt.setString(12, phy.getText());
            pstmt.setString(13, his.getText());
            pstmt.setString(14, geo.getText());
            pstmt.setString(15, cre.getText());
            pstmt.setString(16, opt1.getText());
            pstmt.setString(17, opt2.getText());
            pstmt.setString(18, (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(exdate.getDate())));

            int e = pstmt.executeUpdate();
            if (e > 0) {
                JOptionPane.showMessageDialog(null, "End Term Score Saved Successfully",
                        "Score Saved", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, " End Term Score not Saved Successfully",
                        "Save Failure", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void midinsert() {
        String sql = "INSERT INTO `midterm`(`admNo`, `Name`, `Gender`, `Form`, "
                + "`Stream`, `Term`, `Mat`, `Eng`, `Kis`, `Bio`, `Chem`, `Phy`, "
                + "`His`, `Geo`, `Cre`, `GroupIV`, `GroupV`, `examDate`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adm.getText());
            pstmt.setString(2, sname.getText());
            pstmt.setString(3, gender.getText());
            pstmt.setString(4, frm.getText());
            pstmt.setString(5, strm.getText());
            pstmt.setString(6, (String) term.getSelectedItem());
            pstmt.setString(7, mat.getText());
            pstmt.setString(8, eng.getText());
            pstmt.setString(9, swa.getText());
            pstmt.setString(10, bio.getText());
            pstmt.setString(11, che.getText());
            pstmt.setString(12, phy.getText());
            pstmt.setString(13, his.getText());
            pstmt.setString(14, geo.getText());
            pstmt.setString(15, cre.getText());
            pstmt.setString(16, opt1.getText());
            pstmt.setString(17, opt2.getText());
            pstmt.setString(18, (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(exdate.getDate())));

            int e = pstmt.executeUpdate();
            if (e > 0) {
                JOptionPane.showMessageDialog(null, "Mid Term Score Saved Successfully",
                        "Score Saved", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, " Mid Term Score not Saved Successfully",
                        "Save Failure", JOptionPane.ERROR_MESSAGE);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        srchStudent = new javax.swing.JButton();
        strm = new javax.swing.JTextField();
        adm = new javax.swing.JTextField();
        gender = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        frm = new javax.swing.JTextField();
        sname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        term = new javax.swing.JComboBox<>();
        saveRecord = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        che = new javax.swing.JTextField();
        bio = new javax.swing.JTextField();
        opt2 = new javax.swing.JTextField();
        mat = new javax.swing.JTextField();
        his = new javax.swing.JTextField();
        phy = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        eng = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        swa = new javax.swing.JTextField();
        opt1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        geo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        exdate = new com.toedter.calendar.JDateChooser();
        examHome = new javax.swing.JButton();
        updateRecord = new javax.swing.JButton();
        srchRecord = new javax.swing.JButton();
        deleteRecord = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        extype = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true), "Student Exams ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 24))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 0), 1, true), "Search Student", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 12))); // NOI18N

        srchStudent.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        srchStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Search-icon24.png"))); // NOI18N
        srchStudent.setText("Search Student");
        srchStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchStudentActionPerformed(evt);
            }
        });

        strm.setEditable(false);
        strm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        strm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strmActionPerformed(evt);
            }
        });

        adm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        adm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                admKeyReleased(evt);
            }
        });

        gender.setEditable(false);
        gender.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel4.setText("Stream");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Gender");

        frm.setEditable(false);
        frm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        sname.setEditable(false);
        sname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Name");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Adm No");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("Form");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adm)
                    .addComponent(gender)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(strm)
                    .addComponent(frm, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(srchStudent))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(adm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(frm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(strm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(gender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(srchStudent)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        term.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        term.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        term.setSelectedIndex(-1);

        saveRecord.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        saveRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Save-icon24.png"))); // NOI18N
        saveRecord.setText("Save");
        saveRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRecordActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 0), 1, true), "Enter Student Score", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 3, 12))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setText("Option I ");

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setText("History");

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("English");

        cre.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Mathematics");

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setText("Option II");

        che.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        bio.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        opt2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        mat.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        his.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        phy.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setText("Chemistry");

        eng.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setText("CRE/IRE/HRE");

        swa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        opt1.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setText("Biology");

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel17.setText("Geography");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel18.setText("Date");

        geo.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("Kiswahili");

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setText("Physics");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eng, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(swa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bio, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(che, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phy, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel10)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(geo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cre, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(his, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(opt1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(opt2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(exdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(eng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(swa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                    .addGap(19, 19, 19)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(bio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(19, 19, 19)
                                    .addComponent(che, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel12))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(phy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(his, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(geo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel15)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(opt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(exdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))))
                .addContainerGap())
        );

        examHome.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        examHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Left-icon24.png"))); // NOI18N
        examHome.setText("Back");
        examHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                examHomeActionPerformed(evt);
            }
        });

        updateRecord.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        updateRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit-validated-icon24.png"))); // NOI18N
        updateRecord.setText("Update");
        updateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateRecordActionPerformed(evt);
            }
        });

        srchRecord.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        srchRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Search-icon24.png"))); // NOI18N
        srchRecord.setText("Search Record");
        srchRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srchRecordActionPerformed(evt);
            }
        });

        deleteRecord.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        deleteRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Recycle-Bin-empty-icon24.png"))); // NOI18N
        deleteRecord.setText("Delete");
        deleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecordActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Term");

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel19.setText("Exam Type");

        extype.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        extype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner", "End Term", "Mid Term" }));
        extype.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(46, 60, Short.MAX_VALUE)
                .addComponent(srchRecord)
                .addGap(18, 18, 18)
                .addComponent(updateRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveRecord)
                .addGap(18, 18, 18)
                .addComponent(examHome)
                .addGap(34, 34, 34))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(100, 100, 100)
                                .addComponent(term, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(extype, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(extype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(term, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveRecord)
                    .addComponent(updateRecord)
                    .addComponent(examHome)
                    .addComponent(srchRecord)
                    .addComponent(deleteRecord))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(709, 682));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void strmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strmActionPerformed

    private void srchStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchStudentActionPerformed
        String sql = "SELECT * FROM `student`\n"
                + "INNER JOIN `examregister`  WHERE student.admNo = examregister.admNo =?";
        if (!adm.getText().isEmpty()) {
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, adm.getText());
                rs = pstmt.executeQuery();

                if (rs.next()) {
                    sname.setText(rs.getString("otherName"));
                    gender.setText(rs.getString("Gender"));
                    frm.setText(rs.getString("Form"));
                    strm.setText(rs.getString("Stream"));

                    JOptionPane.showMessageDialog(null, "Student is registered "
                            + "for exams", "Found", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Student is not registered "
                            + "for exams. Invalid Admission Number",
                            "Not Found/ Invalid", JOptionPane.ERROR_MESSAGE);
                    adm.requestFocus();
                    adm.setBackground(Color.orange);
                }

            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Blank Admisssion Number, "
                    + "Invalid Entry", "Blanks", JOptionPane.ERROR_MESSAGE);
            adm.setBackground(Color.red);
            adm.requestFocus();
        }
    }//GEN-LAST:event_srchStudentActionPerformed

    private void admKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_admKeyReleased
        adm.setBackground(Color.white);
    }//GEN-LAST:event_admKeyReleased

    private void saveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRecordActionPerformed

        if (checkInputs()) {
            if (extype.getSelectedItem().toString().equalsIgnoreCase("Mid Term")
                    && extype.getSelectedIndex() != -1) {
                midinsert();
            } else if (extype.getSelectedItem().toString().equalsIgnoreCase("End Term")
                    && extype.getSelectedIndex() != -1) {
                endinsert();
            } else if (extype.getSelectedItem().toString().equalsIgnoreCase("Beginner")
                    && extype.getSelectedIndex() != -1) {
                JOptionPane.showMessageDialog(null, "Beginner exams are not available for now",
                        "Not Available", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Fill in the student details! They are all required",
                    "Blanks Student", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_saveRecordActionPerformed

    private void examHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_examHomeActionPerformed
        setVisible(false);
        Exams_Home h = new Exams_Home();
        h.setVisible(true);
        h.pack();
        this.dispose();
    }//GEN-LAST:event_examHomeActionPerformed

    private void srchRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srchRecordActionPerformed
        String sql = "SELECT * FROM `midterm` WHERE `admNo`=? && `Term`=?";
        if (!adm.getText().isEmpty() && term.getSelectedIndex() != -1) {
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, adm.getText());
                pstmt.setString(2, term.getSelectedItem().toString());

                rs = pstmt.executeQuery();

                if (rs.next()) {
                    sname.setText(rs.getString("Name"));
                    gender.setText(rs.getString("Gender"));
                    frm.setText(rs.getString("Form"));
                    strm.setText(rs.getString("Stream"));
                    mat.setText(rs.getString("Mat"));
                    eng.setText(rs.getString("Eng"));
                    swa.setText(rs.getString("Kis"));
                    bio.setText(rs.getString("Bio"));
                    che.setText(rs.getString("Chem"));
                    phy.setText(rs.getString("Phy"));
                    his.setText(rs.getString("His"));
                    geo.setText(rs.getString("Geo"));
                    cre.setText(rs.getString("Cre"));
                    opt1.setText(rs.getString("GroupIV"));
                    opt2.setText(rs.getString("GroupV"));
                    exdate.setDate(rs.getDate("examDate"));

                    JOptionPane.showMessageDialog(null, "Student record found",
                            "Found", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    JOptionPane.showMessageDialog(null, "Record Not Found."
                            + " Enter valid admission number", "Not found",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Blank Admission number, "
                    + "Invalid entry", "Blanks Admission", JOptionPane.ERROR_MESSAGE);
            adm.setBackground(Color.red);
        }
    }//GEN-LAST:event_srchRecordActionPerformed

    private void updateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateRecordActionPerformed

    private void deleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteRecordActionPerformed

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
            java.util.logging.Logger.getLogger(Tests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Tests().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adm;
    private javax.swing.JTextField bio;
    private javax.swing.JTextField che;
    private javax.swing.JTextField cre;
    private javax.swing.JButton deleteRecord;
    private javax.swing.JTextField eng;
    private javax.swing.JButton examHome;
    private com.toedter.calendar.JDateChooser exdate;
    private javax.swing.JComboBox<String> extype;
    private javax.swing.JTextField frm;
    private javax.swing.JTextField gender;
    private javax.swing.JTextField geo;
    private javax.swing.JTextField his;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField mat;
    private javax.swing.JTextField opt1;
    private javax.swing.JTextField opt2;
    private javax.swing.JTextField phy;
    private javax.swing.JButton saveRecord;
    private javax.swing.JTextField sname;
    private javax.swing.JButton srchRecord;
    private javax.swing.JButton srchStudent;
    private javax.swing.JTextField strm;
    private javax.swing.JTextField swa;
    private javax.swing.JComboBox<String> term;
    private javax.swing.JButton updateRecord;
    // End of variables declaration//GEN-END:variables
}
