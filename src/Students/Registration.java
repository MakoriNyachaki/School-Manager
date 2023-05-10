/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author Start_a_Way
 */
public class Registration extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String ImagePath = null;

    /**
     * Creates new form Registration
     */
    public Registration() {
        super("Registration");
        initComponents();
        conn = new DbConnect().DbConnect();

    }

    public ImageIcon imgResize(String ImagePath) {

        ImageIcon img = new ImageIcon(ImagePath);
        Image imga = img.getImage();
        Image newImg = imga.getScaledInstance(photo.getWidth(), photo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private boolean studentInputs() {
        if (admno.getText().isEmpty() || kcpeindex.getText().isEmpty() || pid.getText().isEmpty()
                || surname.getText().isEmpty() || oname.getText().isEmpty()
                || sgender.getSelectedIndex() == -1 || dob.getDate() == null
                || frm.getSelectedIndex() == -1 || strm.getSelectedIndex() == -1
                || cpemrks.getText().isEmpty() || kscetar.getText().isEmpty()
                || career.getText().isEmpty() || doa.getDate() == null) {
            return false;
        } else {
            try {
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public void insertStudent() {
        String sql = "INSERT INTO `student`(`admNo`, `indexNo`, `idNo`, "
                + "`sName`, `otherName`, `Gender`, `DOB`, `Photo`, `Form`, "
                + "`Stream`, `Kcpe`, `targetKcse`, `Career`, `DOA`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, admno.getText());
            pstmt.setString(2, kcpeindex.getText());
            pstmt.setString(3, pid.getText());
            pstmt.setString(4, surname.getText());
            pstmt.setString(5, oname.getText());
            pstmt.setString(6, (String) sgender.getSelectedItem());
            pstmt.setString(7, (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(dob.getDate())));
            try {
                InputStream is = new FileInputStream(new File(ImagePath));
                pstmt.setBlob(8, is);
            } catch (FileNotFoundException | SQLException e) {
            }
            pstmt.setString(9, (String) frm.getSelectedItem());
            pstmt.setString(10, (String) strm.getSelectedItem());
            pstmt.setString(11, cpemrks.getText());
            pstmt.setString(12, kscetar.getText());
            pstmt.setString(13, career.getText());
            pstmt.setString(14, (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(doa.getDate())));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private boolean parentInputs() {
        if (pid.getText().isEmpty() || pname.getText().isEmpty()
                || pgender.getSelectedIndex() == -1 || phone.getText().isEmpty()
                || email.getText().isEmpty() || address.getText().isEmpty()
                || pcode.getText().isEmpty() || town.getText().isEmpty()
                || doa.getDate() == null) {
            return false;
        } else {
            try {
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public void insertParent() {
        String sql1 = "INSERT INTO `parent`(`idNo`, `parentName`, `parentGender`,"
                + " `parentPhone`, `parentEmail`, `parentAddress`, `postalCode`,"
                + " `Town`, `parentDate`) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1, pid.getText());
            pstmt.setString(2, pname.getText());
            pstmt.setString(3, (String) pgender.getSelectedItem());
            pstmt.setString(4, phone.getText());
            pstmt.setString(5, email.getText());
            pstmt.setString(6, address.getText());
            pstmt.setString(7, pcode.getText());
            pstmt.setString(8, town.getText());
            pstmt.setString(9, (new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(doa.getDate())));

            pstmt.executeUpdate();

        } catch (SQLException e) {
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

        jPanel5 = new javax.swing.JPanel();
        prev = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        next = new javax.swing.JButton();
        save = new javax.swing.JButton();
        srch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ssrch = new javax.swing.JButton();
        btnphoto = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        oname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        admno = new javax.swing.JTextField();
        surname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        sgender = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        kcpeindex = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dob = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        career = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cpemrks = new javax.swing.JTextField();
        strm = new javax.swing.JComboBox<>();
        frm = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        doa = new com.toedter.calendar.JDateChooser();
        kscetar = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        supd = new javax.swing.JButton();
        photo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        pcode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        pid = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        town = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        psrch = new javax.swing.JButton();
        phone = new javax.swing.JTextField();
        pupd = new javax.swing.JButton();
        pgender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153), new java.awt.Color(0, 153, 153)));

        prev.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        prev.setText("Previous");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Left-icon24.png"))); // NOI18N
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        next.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        next.setText("Next");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        save.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Save-icon24.png"))); // NOI18N
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        srch.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        srch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Search-icon24.png"))); // NOI18N
        srch.setText("Search");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("STUDENT REGISTRATION");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)), "Student Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 3, 12))); // NOI18N

        ssrch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        ssrch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Search-icon24.png"))); // NOI18N
        ssrch.setText("Search");
        ssrch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssrchActionPerformed(evt);
            }
        });

        btnphoto.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnphoto.setText("PASSPORT");
        btnphoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnphotoActionPerformed(evt);
            }
        });

        oname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel9.setText("Other Names");

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel2.setText("Surname");

        admno.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        surname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel8.setText("Gender");

        sgender.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        sgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        sgender.setSelectedIndex(-1);

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel13.setText("KCPE Index");

        kcpeindex.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel7.setText("Adm No.");

        dob.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel10.setText("DOB");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(30, 30, 30)
                        .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(admno, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kcpeindex, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(oname)
                                .addComponent(sgender, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(admno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(kcpeindex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(surname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(oname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(sgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        career.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel11.setText("Form");

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel12.setText("KCPE Marks");

        cpemrks.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        strm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        strm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Blue", "Green", "Red", "Violet", "White", "Yellow" }));
        strm.setSelectedIndex(-1);

        frm.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        frm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", " " }));
        frm.setSelectedIndex(-1);

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setText("Stream");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Career");

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel5.setText("DOA");

        doa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        kscetar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel22.setText("KSCE Target");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cpemrks, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(strm, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(frm, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(career, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kscetar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(doa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(frm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(strm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cpemrks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(kscetar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(career, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        supd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        supd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit-validated-icon24.png"))); // NOI18N
        supd.setText("Update");
        supd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supdActionPerformed(evt);
            }
        });

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setText("Student passport");
        photo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 2, true));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(supd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ssrch)
                        .addGap(41, 41, 41))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(btnphoto)))
                        .addGap(74, 74, 74)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnphoto)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ssrch)
                            .addComponent(supd))))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)), "Parent Registration", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri", 3, 12))); // NOI18N

        jLabel20.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel20.setText("Parent ID No.");

        pcode.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel6.setText("Postal Code");

        address.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel21.setText("Phone");

        pid.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel17.setText("Gender");

        jLabel18.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel18.setText("Address");

        email.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel15.setText("Email");

        town.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel16.setText("Town");

        pname.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel19.setText("Parent Name");

        psrch.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        psrch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/Knob-Search-icon24.png"))); // NOI18N
        psrch.setText("Search Parent");

        phone.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        pupd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        pupd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/edit-validated-icon24.png"))); // NOI18N
        pupd.setText("Update Parent");

        pgender.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        pgender.setSelectedIndex(-1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pgender, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pcode, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(town, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pupd)
                    .addComponent(psrch))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(pid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(pgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(psrch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(pcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pupd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(town, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(srch)
                                .addGap(18, 18, 18)
                                .addComponent(prev)
                                .addGap(35, 35, 35)
                                .addComponent(next)
                                .addGap(32, 32, 32)
                                .addComponent(save)
                                .addGap(26, 26, 26)
                                .addComponent(exit))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exit)
                    .addComponent(save)
                    .addComponent(srch)
                    .addComponent(prev)
                    .addComponent(next))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(942, 723));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ssrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssrchActionPerformed
        if (!admno.getText().isEmpty() || admno.getText() != null) {
            try {
                pstmt = conn.prepareStatement("SELECT * FROM `student` INNER JOIN"
                        + " `parent` WHERE  `admNo` = ? AND `student`.`idNo` = `parent`.`idNo` ");
                pstmt.setString(1, admno.getText());

                rs = pstmt.executeQuery();
                if (rs.next()) {
                    kcpeindex.setText(rs.getString("indexNo"));
                    surname.setText(rs.getString("sName"));
                    oname.setText(rs.getString("otherName"));
                    sgender.setSelectedItem(rs.getString("Gender"));
                    dob.setDate(rs.getDate("DOB"));

                    
                    byte[] img = rs.getBytes(8);

                    //Resize The ImageIcon
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(photo.getWidth(), photo.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                    photo.setIcon(newImage);

                    frm.setSelectedItem(rs.getString("Form"));
                    strm.setSelectedItem(rs.getString("Stream"));
                    cpemrks.setText(rs.getString("Kcpe"));
                    kscetar.setText(rs.getString("targetKcse"));
                    career.setText(rs.getString("Career"));
                    doa.setDate(rs.getDate("DOA"));

                    pid.setText(rs.getString("idNo"));
                    pname.setText(rs.getString("parentName"));
                    pgender.setSelectedItem(rs.getString("parentGender"));
                    phone.setText(rs.getString("parentPhone"));
                    email.setText(rs.getString("parentEmail"));
                    address.setText(rs.getString("parentAddress"));
                    pcode.setText(rs.getString("postalCode"));
                    town.setText(rs.getString("Town"));
                    doa.setDate(rs.getDate("parentDate"));

                    JOptionPane.showMessageDialog(null, "Search successful, Student found!");

                }
            } catch (SQLException ex) {
                Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Blank Admission Number",
                    "Blanks", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ssrchActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        if (parentInputs() && studentInputs()) {
            try {
                insertParent();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            try {
                insertStudent();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

            JOptionPane.showMessageDialog(null, "Parents and Student Details saved Successfully",
                    "Saved", JOptionPane.INFORMATION_MESSAGE);
        } else if (parentInputs()) {
            insertParent();
            JOptionPane.showMessageDialog(null, "Parents Details saved Successfully",
                    "Saved", JOptionPane.INFORMATION_MESSAGE);
        } else if (studentInputs()) {
            insertStudent();
            JOptionPane.showMessageDialog(null, "Student Details saved Successfully",
                    "Saved", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Blank fields, Not saved",
                    "Blanks", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_saveActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.hide();
        int a;
        a = JOptionPane.showConfirmDialog(null, "Do your want to close this window?",
                "Close", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            this.dispose();
        } else {
            this.show();
        }
    }//GEN-LAST:event_exitActionPerformed

    private void btnphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnphotoActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setDialogTitle("Image chooser");
        jf.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fi = new FileNameExtensionFilter("*.image", "jpeg", "png", "gif");
        jf.addChoosableFileFilter(fi);

        int r = jf.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jf.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            photo.setIcon(imgResize(path));
            ImagePath = path;

        } else if (r == JFileChooser.CANCEL_OPTION) {
            System.out.println("No Image selected");

        }
    }//GEN-LAST:event_btnphotoActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        try {
            Statement statement = conn.createStatement();
            rs = statement.executeQuery("SELECT `admNo`, `indexNo`, `idNo`, "
                    + "`sName`, `otherName`, `Gender`, `DOB`, `Form`, `Stream`, "
                    + "`Kcpe`, `targetKcse`, `Career`, `DOA` FROM `student` ");
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Students db");

            XSSFRow row = spreadsheet.createRow(0);
            XSSFCell cell;
            cell = row.createCell(1);
            cell.setCellValue("ADM NO");
            cell = row.createCell(2);
            cell.setCellValue("INDEX NO.");
            cell = row.createCell(3);
            cell.setCellValue("ID NO");
            cell = row.createCell(4);
            cell.setCellValue("SURNAME");
            cell = row.createCell(5);
            cell.setCellValue("OTHER NAMES");
            cell = row.createCell(6);
            cell.setCellValue("GENDER");
            cell = row.createCell(7);
            cell.setCellValue("DATE OF BIRTH");
            cell = row.createCell(8);
            cell.setCellValue("FORM");
            cell = row.createCell(9);
            cell.setCellValue("STREAM");
            cell = row.createCell(10);
            cell.setCellValue("KCPE MARKS");
            cell = row.createCell(11);
            cell.setCellValue("KCSE TARGET");
            cell = row.createCell(12);
            cell.setCellValue("CAREER");
            cell = row.createCell(13);
            cell.setCellValue("DATE OF ADMISSION");
            int i = 2;

            while (rs.next()) {
                row = spreadsheet.createRow(i);
                cell = row.createCell(1);
                cell.setCellValue(rs.getInt("admNo"));
                cell = row.createCell(2);
                cell.setCellValue(rs.getString("indexNo"));
                cell = row.createCell(3);
                cell.setCellValue(rs.getString("idNo"));
                cell = row.createCell(4);
                cell.setCellValue(rs.getString("sName"));
                cell = row.createCell(5);
                cell.setCellValue(rs.getString("otherName"));
                cell = row.createCell(6);
                cell.setCellValue(rs.getString("Gender"));
                cell = row.createCell(7);
                cell.setCellValue(rs.getString("DOB"));
                cell = row.createCell(8);
                cell.setCellValue(rs.getString("Form"));
                cell = row.createCell(9);
                cell.setCellValue(rs.getString("Stream"));
                cell = row.createCell(10);
                cell.setCellValue(rs.getString("Kcpe"));
                cell = row.createCell(11);
                cell.setCellValue(rs.getString("targetKcse"));
                cell = row.createCell(12);
                cell.setCellValue(rs.getString("Career"));
                cell = row.createCell(13);
                cell.setCellValue(rs.getString("DOA"));
                i++;
            }

            try (FileOutputStream out = new FileOutputStream(new File("Student List.xlsx"))) {
                workbook.write(out);
            }
            System.out.println("Student List Written Successfully");
        } catch (SQLException | IOException ex) {
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_prevActionPerformed

    private void supdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supdActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Registration().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField admno;
    private javax.swing.JButton btnphoto;
    private javax.swing.JTextField career;
    private javax.swing.JTextField cpemrks;
    private com.toedter.calendar.JDateChooser doa;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JButton exit;
    private javax.swing.JComboBox<String> frm;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField kcpeindex;
    private javax.swing.JTextField kscetar;
    private javax.swing.JButton next;
    private javax.swing.JTextField oname;
    private javax.swing.JTextField pcode;
    private javax.swing.JComboBox<String> pgender;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel photo;
    private javax.swing.JTextField pid;
    private javax.swing.JTextField pname;
    private javax.swing.JButton prev;
    private javax.swing.JButton psrch;
    private javax.swing.JButton pupd;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> sgender;
    private javax.swing.JButton srch;
    private javax.swing.JButton ssrch;
    private javax.swing.JComboBox<String> strm;
    private javax.swing.JButton supd;
    private javax.swing.JTextField surname;
    private javax.swing.JTextField town;
    // End of variables declaration//GEN-END:variables
}
