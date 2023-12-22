/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaswinggui;

import General.ConnectionProvider;
import General.Utils;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;



/**
 *
 * @author jetro
 */
public class StudentBackground extends javax.swing.JFrame {
      
      private byte[] imageData;
      private String imagePath;

    public StudentBackground() {
        
        initComponents();
        showStudentBackground();
        
        this.jTable2.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int selectedRow = jTable2.getSelectedRow();
                    if(selectedRow != -1){
                        imageData  = (byte[]) jTable2.getValueAt(selectedRow,9);
                        
                        ImageIcon imageIcon = new ImageIcon(imageData);
                        Image scaledImage = imageIcon.getImage().getScaledInstance(136, 160, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                        JPHOTO.setIcon(scaledIcon);
                    }
                }
            }
            
        });
    }
    //===================================FUNCTION===============================================//
    
   
    
    
    
    public void showStudentBackground(){
         try {
            // Create the SQL query with placeholders
            String getQuery = "SELECT * FROM student_background";


            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(getQuery);

            statement.executeQuery();
           ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {
        // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
           // Override isCellEditable method to make all cells non-editable
            tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Make all cells non-editable
                    return false;
                }
            };
        jTable2.setModel(tableModel);
          
         
         
             // Set the row height
            int rowHeight = 30; // Set your desired row height
            this.jTable2.setRowHeight(rowHeight);
           

        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            List<String> validColumnNames = Arrays.asList("student_id", "student_name", "course", "age", "year_level", "status", "section", "gender", "phone_number", "imageIcon", "good_moral", "report_card", "birth_certificate", "medical_certificate", "picture");
            if (validColumnNames.contains(columnName)) {
                columnName = columnName.toUpperCase();
                tableModel.addColumn(columnName);
            } else {
            System.out.println("No matching records found.");
            JOptionPane.showMessageDialog(this, "No record found!");
        }
     }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } 

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();

            System.out.println("Retrieved Successfully!");

        } catch (ClassNotFoundException | SQLException e) {
          Logger.getLogger(StudentRequirements.class.getName()).log(Level.SEVERE, null, e);
          e.printStackTrace();
        }
         TableColumnModel columnModel = this.jTable2.getColumnModel();
         TableColumn columnToZero = columnModel.getColumn(9);
         columnToZero.setMinWidth(0);
         columnToZero.setMaxWidth(0);
         columnToZero.setPreferredWidth(0);
         columnToZero.setWidth(0);
    }
    
    
    //===========================================================================================//


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        student_id_field = new javax.swing.JTextField();
        student_name_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        age_field = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        section_field = new javax.swing.JTextField();
        phone_number_field = new javax.swing.JTextField();
        grade_level_field = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        search = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        gender_combo_box = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        JPHOTO = new javax.swing.JLabel();
        status_combo_box = new javax.swing.JComboBox<>();
        course_combo_box = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        good_moral_combo_box = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        report_card_combo_box = new javax.swing.JComboBox<>();
        birth_certificate_combo_box = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        medical_certificate_combo_box = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        picture_combo_box = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "student_id", "student_name", "course", "age", "grade_level", "status", "section"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1237, 710));
        setPreferredSize(new java.awt.Dimension(1237, 710));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(920, 575));
        jPanel1.setPreferredSize(new java.awt.Dimension(920, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("STUDENT ID :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        student_id_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        student_id_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        student_id_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_id_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(student_id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 190, 30));

        student_name_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        student_name_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        student_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_name_fieldActionPerformed(evt);
            }
        });
        jPanel1.add(student_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 520, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("MIDDLE NAME :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("COURSE :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("AGE :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        age_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        age_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jPanel1.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 160, 30));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("GENDER :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        section_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        section_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jPanel1.add(section_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 200, 30));

        phone_number_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone_number_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jPanel1.add(phone_number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 370, 30));

        grade_level_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        grade_level_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        jPanel1.add(grade_level_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 150, 160, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("YEAR LEVEL :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("PHONE NUMBER :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "student_id", "student_name", "course", "age", "year_level", "status", "section", "gender", "phone_number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setSelectionBackground(new java.awt.Color(37, 40, 57));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 900, 180));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\add (1).jpg")); // NOI18N
        jButton2.setText("ADD STUDENTS");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jButton2.setMaximumSize(new java.awt.Dimension(79, 30));
        jButton2.setMinimumSize(new java.awt.Dimension(79, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(79, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 30));

        search.setBackground(new java.awt.Color(204, 204, 204));
        search.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        search.setForeground(new java.awt.Color(51, 51, 51));
        search.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\search (1).png")); // NOI18N
        search.setText("SEARCH");
        search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        search.setMaximumSize(new java.awt.Dimension(79, 30));
        search.setMinimumSize(new java.awt.Dimension(79, 30));
        search.setPreferredSize(new java.awt.Dimension(79, 30));
        search.setSelectedIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\search (1).png")); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 360, 80, -1));

        searchTF.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        searchTF.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(102, 102, 102), new java.awt.Color(255, 255, 255), new java.awt.Color(102, 102, 102), new java.awt.Color(102, 102, 102)));
        searchTF.setMinimumSize(new java.awt.Dimension(79, 30));
        jPanel1.add(searchTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 220, 30));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setForeground(new java.awt.Color(51, 51, 51));
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\reset (1).png")); // NOI18N
        jButton5.setText("RESET TEXT");
        jButton5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jButton5.setMaximumSize(new java.awt.Dimension(79, 30));
        jButton5.setMinimumSize(new java.awt.Dimension(79, 30));
        jButton5.setPreferredSize(new java.awt.Dimension(79, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 140, 30));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\update (1).png")); // NOI18N
        jButton3.setText("UPDATE STUDENTS");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jButton3.setMaximumSize(new java.awt.Dimension(79, 30));
        jButton3.setMinimumSize(new java.awt.Dimension(79, 30));
        jButton3.setPreferredSize(new java.awt.Dimension(79, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 160, -1));

        gender_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        gender_combo_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(gender_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 200, 30));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("SECTION :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("STATUS :");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 70, -1));

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setForeground(new java.awt.Color(51, 51, 51));
        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\image (1).png")); // NOI18N
        jButton9.setText("BROWSE");
        jButton9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(153, 153, 153), null, null));
        jButton9.setMaximumSize(new java.awt.Dimension(79, 30));
        jButton9.setMinimumSize(new java.awt.Dimension(79, 30));
        jButton9.setPreferredSize(new java.awt.Dimension(136, 30));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 140, -1));

        JPHOTO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 40, 57), 3));
        JPHOTO.setPreferredSize(new java.awt.Dimension(136, 160));
        jPanel1.add(JPHOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 140, 150));

        status_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enrolled", "Regular", "Irregular", " " }));
        status_combo_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(status_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 130, 30));

        course_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT", "BSCRIM", "BSED", "BSBA" }));
        course_combo_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(course_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 170, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("GOOD MORAL :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 120, -1));

        good_moral_combo_box.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        good_moral_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        good_moral_combo_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(good_moral_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 150, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("REPORT CARD :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 130, -1));

        report_card_combo_box.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        report_card_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        report_card_combo_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(report_card_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 130, 30));

        birth_certificate_combo_box.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        birth_certificate_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        birth_certificate_combo_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(birth_certificate_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 140, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("NSO :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 60, -1));

        medical_certificate_combo_box.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        medical_certificate_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        medical_certificate_combo_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(medical_certificate_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 140, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("X-RAY :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 80, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("PICTURE :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 100, -1));

        picture_combo_box.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        picture_combo_box.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YES", "NO" }));
        picture_combo_box.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel1.add(picture_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("LAST NAME :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("FIRST NAME :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 153, 153));
        jLabel22.setText("[Edit Students Setting]");
        jLabel22.setToolTipText("");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 950, 600));

        jPanel2.setBackground(new java.awt.Color(37, 40, 57));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\deleter (1).jpg")); // NOI18N
        jButton4.setText("  DELETE STUDENT");
        jButton4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton4.setBorderPainted(false);
        jButton4.setMaximumSize(new java.awt.Dimension(120, 27));
        jButton4.setMinimumSize(new java.awt.Dimension(120, 27));
        jButton4.setPreferredSize(new java.awt.Dimension(120, 27));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 150, 40));

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\printreport (2).png")); // NOI18N
        jButton10.setText("  PRINT REPORT");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 150, 40));

        jPanel4.setBackground(new java.awt.Color(37, 40, 57));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setAutoscrolls(true);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Admin Page");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, 60));

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\home (1).jpg")); // NOI18N
        jButton6.setText("  BACK TO HOME");
        jButton6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton6.setBorderPainted(false);
        jButton6.setMaximumSize(new java.awt.Dimension(120, 27));
        jButton6.setMinimumSize(new java.awt.Dimension(120, 27));
        jButton6.setPreferredSize(new java.awt.Dimension(120, 27));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 150, 40));

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\logout (1).jpg")); // NOI18N
        jButton8.setText("  LOG OUT ACC");
        jButton8.setActionCommand("LOG OUT");
        jButton8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton8.setMaximumSize(new java.awt.Dimension(120, 27));
        jButton8.setMinimumSize(new java.awt.Dimension(120, 27));
        jButton8.setPreferredSize(new java.awt.Dimension(120, 27));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 150, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Logged In");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Admin");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, -1, -1));

        jLabel21.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\iconjava (3).png")); // NOI18N
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel21.setPreferredSize(new java.awt.Dimension(32, 23));
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 80));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 240, 600));

        jPanel3.setBackground(new java.awt.Color(37, 40, 57));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 23)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\tcc logo (10).png")); // NOI18N
        jLabel2.setText(" TALISAY CITY COLLEGE INC. ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 360, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void student_id_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_id_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_id_fieldActionPerformed

    private void student_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_name_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_name_fieldActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                try {
                    InputStream inputStream = new FileInputStream(imagePath);

            
            // Create the SQL query with placeholders
            String insertQuery = "INSERT INTO student_background(student_id,student_name,course,age,year_level,status,section,gender,phone_number,imageIcon,good_moral,report_card,birth_certificate,medical_certificate,picture) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


            // Create a connection
            ConnectionProvider dbc = new ConnectionProvider();
            String jdbcDriver = dbc.getJdbcDriver();
            String dbConnectionURL = dbc.getDbConnectionURL();
            String dbUsername = dbc.getDbUsername();
            String dbPassword = dbc.getDbPassword();
            Class.forName(jdbcDriver);
            Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

            // Create the PreparedStatement
            PreparedStatement statement = connection.prepareStatement(insertQuery);

            statement.setString(1, student_id_field.getText());
            statement.setString(2, student_name_field.getText());
            statement.setString(3, String.valueOf(course_combo_box.getSelectedItem()));
            statement.setString(4, age_field.getText());
            statement.setString(5, grade_level_field.getText());
            statement.setString(6, String.valueOf(status_combo_box.getSelectedItem()));
            statement.setString(7, section_field.getText());
            statement.setString(8, String.valueOf(gender_combo_box.getSelectedItem()));
            statement.setString(9, phone_number_field.getText());
            statement.setBlob(10, inputStream);
            statement.setString(11, String.valueOf(good_moral_combo_box.getSelectedItem()));
            statement.setString(12, String.valueOf(report_card_combo_box.getSelectedItem()));
            statement.setString(13, String.valueOf(birth_certificate_combo_box.getSelectedItem()));
            statement.setString(14, String.valueOf(medical_certificate_combo_box.getSelectedItem()));
            statement.setString(15, String.valueOf(picture_combo_box.getSelectedItem()));
            
            int rowsAffected = statement.executeUpdate();
            if(rowsAffected > 0){
            this.student_id_field.setText("");
            this.student_name_field.setText("");
            this.course_combo_box.setSelectedItem("BSIT");
            this.age_field.setText("");
            this.grade_level_field.setText("");
            this.status_combo_box.setSelectedItem("ENROLLED");          
            this.section_field.setText("");
            this.gender_combo_box.setSelectedItem("Female");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.good_moral_combo_box.setSelectedItem("YES");
            this.report_card_combo_box.setSelectedItem("YES");
            this.birth_certificate_combo_box.setSelectedItem("YES");
            this.medical_certificate_combo_box.setSelectedItem("YES");
            this.picture_combo_box.setSelectedItem("YES");
            JOptionPane.showMessageDialog(this, "Record has been Successfully Added");
            showStudentBackground();
            
            System.out.println("Add Successfully!");
        }else{
                JOptionPane.showMessageDialog(this, "Record has been duplicated");
            }
        } catch (ClassNotFoundException | SQLException e) {
           Logger.getLogger(StudentRequirements.class.getName()).log(Level.SEVERE, null, e);
           e.printStackTrace();
        } catch (FileNotFoundException ex) {
              Logger.getLogger(StudentBackground.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
       InputStream inputStream;
        // Create the SQL query for update using PreparedStatement
String updateQuery = "UPDATE student_background SET student_name=?, course=?, age=?, year_level=?, status=?, section=?, gender=?, phone_number=?, imageIcon=?, good_moral =?, report_card =?, birth_certificate =?, medical_certificate =?, picture =? WHERE student_id=?";
try {
    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbc.getDbConnectionURL(), dbc.getDbUsername(), dbc.getDbPassword());
    // Create the PreparedStatement
    PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

    // Set the values for the PreparedStatement
    preparedStatement.setString(1, student_name_field.getText());
    preparedStatement.setString(2, course_combo_box.getSelectedItem().toString());
    preparedStatement.setString(3, age_field.getText());
    preparedStatement.setString(4, grade_level_field.getText());
    preparedStatement.setString(5, status_combo_box.getSelectedItem().toString());
    preparedStatement.setString(6, section_field.getText());
    preparedStatement.setString(7, gender_combo_box.getSelectedItem().toString());
    preparedStatement.setString(8, phone_number_field.getText());
    preparedStatement.setString(10, good_moral_combo_box.getSelectedItem().toString());
    preparedStatement.setString(11, report_card_combo_box.getSelectedItem().toString());
    preparedStatement.setString(12, birth_certificate_combo_box.getSelectedItem().toString());
    preparedStatement.setString(13, medical_certificate_combo_box.getSelectedItem().toString());
    preparedStatement.setString(14, picture_combo_box.getSelectedItem().toString());
    preparedStatement.setString(15, student_id_field.getText());
 if(imagePath != null){
            try {
                inputStream = new FileInputStream(imagePath);
                    preparedStatement.setBlob(9, inputStream);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentBackground.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else{
            ByteArrayInputStream byteInputStream = new ByteArrayInputStream(imageData);

                 preparedStatement.setBlob(9, byteInputStream);
                


        }
    // Execute the UPDATE query
    int rowsAffected = preparedStatement.executeUpdate();

    if (rowsAffected > 0) {
            this.student_id_field.setText("");
            this.student_name_field.setText("");
            this.course_combo_box.setSelectedItem("BSIT");
            this.age_field.setText("");
            this.grade_level_field.setText("");
            this.status_combo_box.setSelectedItem("ENROLLED");          
            this.section_field.setText("");
            this.gender_combo_box.setSelectedItem("Female");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.good_moral_combo_box.setSelectedItem("YES");
            this.report_card_combo_box.setSelectedItem("YES");
            this.birth_certificate_combo_box.setSelectedItem("YES");
            this.medical_certificate_combo_box.setSelectedItem("YES");
            this.picture_combo_box.setSelectedItem("YES");
        JOptionPane.showMessageDialog(this, "Record has been successfully updated");
    } else {
        JOptionPane.showMessageDialog(this, "No record found with the given student_id.");
    }

    
    showStudentBackground();

    System.out.println("Update Successfully!");

} catch (ClassNotFoundException | SQLException e) {
    Logger.getLogger(StudentRequirements.class.getName()).log(Level.SEVERE, null, e);
    e.printStackTrace();
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        // Delete function
int deleteItem;
DefaultTableModel RecordTable = (DefaultTableModel) jTable2.getModel();
int SelectedRows = jTable2.getSelectedRow();
try {
    student_id_field.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
    deleteItem = JOptionPane.showConfirmDialog(this, "Confirm if you want to delete item ", "warning", JOptionPane.YES_NO_OPTION);

    if (deleteItem == JOptionPane.YES_OPTION) {

        // Create the SQL query with placeholders
        String deleteQuery = "DELETE FROM student_background WHERE student_id = ?";

        // Create a connection
        ConnectionProvider dbc = new ConnectionProvider();
        String jdbcDriver = dbc.getJdbcDriver();
        String dbConnectionURL = dbc.getDbConnectionURL();
        String dbUsername = dbc.getDbUsername();
        String dbPassword = dbc.getDbPassword();
        Class.forName(jdbcDriver);
        Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);

        // Create the PreparedStatement
        PreparedStatement statement = connection.prepareStatement(deleteQuery);

        // Bind the parameter
        statement.setString(1, student_id_field.getText());

        // Execute the DELETE query
        int rowsAffected = statement.executeUpdate();

        if (rowsAffected > 0) {
            this.student_id_field.setText("");
            this.student_name_field.setText("");
            this.course_combo_box.setSelectedItem("BSIT");
            this.age_field.setText("");
            this.grade_level_field.setText("");
            this.status_combo_box.setSelectedItem("ENROLLED");          
            this.section_field.setText("");
            this.gender_combo_box.setSelectedItem("Female");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.good_moral_combo_box.setSelectedItem("YES");
            this.report_card_combo_box.setSelectedItem("YES");
            this.birth_certificate_combo_box.setSelectedItem("YES");
            this.medical_certificate_combo_box.setSelectedItem("YES");
            this.picture_combo_box.setSelectedItem("YES");
            
        JOptionPane.showMessageDialog(this,"Record has been successfully deleted");
        } else {
            JOptionPane.showMessageDialog(this,"No record found with the given id_number.");
        }
        showStudentBackground();
    }
} catch (ClassNotFoundException | SQLException e) {
    Logger.getLogger(StudentRequirements.class.getName()).log(Level.SEVERE, null, e);
    e.printStackTrace();
}

    }//GEN-LAST:event_jButton4ActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    try {
    // Create the SQL query with placeholders
    String searchQuery = "SELECT * FROM student_background WHERE student_id LIKE ? OR student_name LIKE ? OR course LIKE ? OR age LIKE ? OR year_level LIKE ? OR status LIKE ? OR section LIKE ? OR gender LIKE ? OR phone_number LIKE ? OR good_moral LIKE ? OR report_card LIKE ? OR birth_certificate LIKE ? OR medical_certificate LIKE ? OR picture LIKE ?";
    
    // Create a connection
    ConnectionProvider dbc = new ConnectionProvider();
    String jdbcDriver = dbc.getJdbcDriver();
    String dbConnectionURL = dbc.getDbConnectionURL();
    String dbUsername = dbc.getDbUsername();
    String dbPassword = dbc.getDbPassword();
    Class.forName(jdbcDriver);
    Connection connection = DriverManager.getConnection(dbConnectionURL, dbUsername, dbPassword);
    
    // Create the PreparedStatement
    PreparedStatement statement = connection.prepareStatement(searchQuery);
    
    // Set search parameters
    String searchKeyword = "%" + searchTF.getText() + "%";
   
    for (int i = 1; i <= 14; i++) {
        statement.setString(i, searchKeyword);
    }
    
    // Execute the query
    ResultSet resultSet = statement.executeQuery();
    
    // Process the result set as needed
    if (resultSet.next()) {

          // Create a table model to store data
        DefaultTableModel tableModel = new DefaultTableModel();
           // Override isCellEditable method to make all cells non-editable
            tableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Make all cells non-editable
                    return false;
                }
            };
        jTable2.setModel(tableModel);
          
         
         
             // Set the row height
            int rowHeight = 30; // Set your desired row height
            this.jTable2.setRowHeight(rowHeight);
        

        // Get column names and add them to the table model
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
           String columnName = metaData.getColumnName(i);
            List<String> validColumnNames = Arrays.asList("student_id", "student_name", "course", "age", "year_level", "status", "section", "gender", "phone_number", "imageIcon", "good_moral", "report_card", "birth_certificate", "medical_certificate", "picture");
            if (validColumnNames.contains(columnName)) {
                columnName = columnName.toUpperCase();
                tableModel.addColumn(columnName);
            } else {
            System.out.println("No matching records found.");
            JOptionPane.showMessageDialog(this, "No record found!");
            }
        }

        // Add rows to the table model
        do {
            Object[] rowData = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = resultSet.getObject(i);
            }
            tableModel.addRow(rowData);
        } while (resultSet.next());

    } 

    // Close resources
    resultSet.close();
    statement.close();
    connection.close();
} catch (ClassNotFoundException | SQLException e) {
    Logger.getLogger(StudentRequirements.class.getName()).log(Level.SEVERE, null, e);
    e.printStackTrace();
}
     TableColumnModel columnModel = this.jTable2.getColumnModel();
         TableColumn columnToZero = columnModel.getColumn(9);
         columnToZero.setMinWidth(0);
         columnToZero.setMaxWidth(0);
         columnToZero.setPreferredWidth(0);
         columnToZero.setWidth(0);
    }//GEN-LAST:event_searchActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
            DefaultTableModel RecordTable = (DefaultTableModel) jTable2.getModel();
    int SelectedRows = jTable2.getSelectedRow();
    student_id_field.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
    student_name_field.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
    course_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 2).toString());
    age_field.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
    grade_level_field.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
    status_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 5).toString());
    section_field.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
    gender_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 7).toString());
    phone_number_field.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
    good_moral_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 10).toString());
    report_card_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 11).toString());
    birth_certificate_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 12).toString());
    medical_certificate_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 13).toString());
    picture_combo_box.setSelectedItem(RecordTable.getValueAt(SelectedRows, 14).toString());

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
            this.student_id_field.setText("");
            this.student_name_field.setText("");
            this.course_combo_box.setSelectedItem("BSIT");
            this.age_field.setText("");
            this.grade_level_field.setText("");
            this.status_combo_box.setSelectedItem("ENROLLED");          
            this.section_field.setText("");
            this.gender_combo_box.setSelectedItem("Female");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.good_moral_combo_box.setSelectedItem("NO");
            this.report_card_combo_box.setSelectedItem("NO");
            this.birth_certificate_combo_box.setSelectedItem("NO");
            this.medical_certificate_combo_box.setSelectedItem("NO");
            this.picture_combo_box.setSelectedItem("NO");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        home.pack();
        home.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
   private JFrame frame;
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
     frame = new JFrame("Log out");
       if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to log out","MySQL connector",
               JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
       {
          
           this.dispose();
       }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       JFileChooser chooser = new JFileChooser();
       chooser.showOpenDialog(null);
       File f = chooser.getSelectedFile();
       String path = f.getAbsolutePath();
          try {
              BufferedImage bi = ImageIO.read(new File(path));
              Image img = bi.getScaledInstance(136, 160, Image.SCALE_SMOOTH);
              ImageIcon icon = new ImageIcon(img);
              JPHOTO.setIcon(icon);
              imagePath = path;
          } catch (IOException ex) {
              Logger.getLogger(StudentBackground.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         
        try {
              Utils.printTable(jTable2);
              
          } catch (PrinterException ex) {
              Logger.getLogger(StudentBackground.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_jButton10ActionPerformed

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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentBackground.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentBackground.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentBackground.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentBackground.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentBackground().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JPHOTO;
    private javax.swing.JTextField age_field;
    private javax.swing.JComboBox<String> birth_certificate_combo_box;
    private javax.swing.JComboBox<String> course_combo_box;
    private javax.swing.JComboBox<String> gender_combo_box;
    private javax.swing.JComboBox<String> good_moral_combo_box;
    private javax.swing.JTextField grade_level_field;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> medical_certificate_combo_box;
    private javax.swing.JTextField phone_number_field;
    private javax.swing.JComboBox<String> picture_combo_box;
    private javax.swing.JComboBox<String> report_card_combo_box;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField section_field;
    private javax.swing.JComboBox<String> status_combo_box;
    private javax.swing.JTextField student_id_field;
    private javax.swing.JTextField student_name_field;
    // End of variables declaration//GEN-END:variables
}
