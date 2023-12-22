/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaswinggui;

import General.ConnectionProvider;
import java.awt.Image;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
 * @author Dell
 */
public class StudentRequirements extends javax.swing.JFrame {
      
      private byte[] imageData;
      private String imagePath;
      
                
    
    /**
     * Creates new form StudentRequirements
     */
    public StudentRequirements() {
        initComponents();
        showStudentRequirements();
        this.jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    int selectedRow = jTable1.getSelectedRow();
                    if(selectedRow != -1){
                         imageData  = (byte[]) jTable1.getValueAt(selectedRow,9);
                        
                        ImageIcon imageIcon = new ImageIcon(imageData);
                        Image scaledImage = imageIcon.getImage().getScaledInstance(136, 172, Image.SCALE_SMOOTH);
                        ImageIcon scaledIcon = new ImageIcon(scaledImage);
                        JPHOTO.setIcon(scaledIcon);
                    }
                }
            }
            
        });
    }
    
    
     public void showStudentRequirements(){
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
        jTable1.setModel(tableModel);
          
         
         
             // Set the row height
            int rowHeight = 30; // Set your desired row height
            this.jTable1.setRowHeight(rowHeight);
           

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
          Logger.getLogger(StudentBackground.class.getName()).log(Level.SEVERE, null, e);
          e.printStackTrace();
        }
         TableColumnModel columnModel = this.jTable1.getColumnModel();
         TableColumn columnToZero = columnModel.getColumn(9);
         columnToZero.setMinWidth(0);
         columnToZero.setMaxWidth(0);
         columnToZero.setPreferredWidth(0);
         columnToZero.setWidth(0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        search = new javax.swing.JButton();
        searchTF = new javax.swing.JTextField();
        student_name_field = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        student_id_field = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        good_moral_combo_box = new javax.swing.JLabel();
        report_card_combo_box = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        birth_certificate_combo_box = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        medical_certificate_combo_box = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        JPHOTO = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        course_combo_box = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        age_field = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        grade_level_field = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        status_combo_box = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        phone_number_field = new javax.swing.JLabel();
        section_field = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        gender_combo_box = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        picture_combo_box = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "student_id", "good_moral", "report_card", "nso", "x-ray", "form 137", "deploma"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 400, 30, 50));

        search.setForeground(new java.awt.Color(0, 51, 51));
        search.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\search (1).png")); // NOI18N
        search.setText("Search");
        search.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        search.setBorderPainted(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 510, 100, 30));

        searchTF.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });
        jPanel1.add(searchTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 510, 170, 30));

        student_name_field.setBackground(new java.awt.Color(255, 255, 255));
        student_name_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        student_name_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(student_name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 520, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("MIDDLE NAME :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 110, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("STUDENT ID :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));

        student_id_field.setBackground(new java.awt.Color(255, 255, 255));
        student_id_field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        student_id_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(student_id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 230, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("GOOD MORAL :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 320, -1, 30));

        good_moral_combo_box.setBackground(new java.awt.Color(255, 255, 255));
        good_moral_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(good_moral_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 220, 30));

        report_card_combo_box.setBackground(new java.awt.Color(255, 255, 255));
        report_card_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(report_card_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 350, 290, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("BIRTH CERTIFICATE :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, -1, 20));

        birth_certificate_combo_box.setBackground(new java.awt.Color(255, 255, 255));
        birth_certificate_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(birth_certificate_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 230, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("MEDICAL CERTIFICATE :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, 20));

        medical_certificate_combo_box.setBackground(new java.awt.Color(255, 255, 255));
        medical_certificate_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(medical_certificate_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 290, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("REPORT CARD :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 120, 30));

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\home (3).jpg")); // NOI18N
        jButton2.setText("Back to Login");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, 30));

        JPHOTO.setBackground(new java.awt.Color(0, 0, 0));
        JPHOTO.setForeground(new java.awt.Color(255, 255, 255));
        JPHOTO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        JPHOTO.setPreferredSize(new java.awt.Dimension(136, 160));
        jPanel1.add(JPHOTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 140, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("COURSE :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, 20));

        course_combo_box.setBackground(new java.awt.Color(255, 255, 255));
        course_combo_box.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        course_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(course_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 230, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("AGE :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, 20));

        age_field.setBackground(new java.awt.Color(255, 255, 255));
        age_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        age_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 290, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("GRADE_LEVEL :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 110, 20));

        grade_level_field.setBackground(new java.awt.Color(255, 255, 255));
        grade_level_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        grade_level_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(grade_level_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 230, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("STATUS :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 70, 20));

        status_combo_box.setBackground(new java.awt.Color(255, 255, 255));
        status_combo_box.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        status_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(status_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 290, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("PHONE NUMBER :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, 20));

        phone_number_field.setBackground(new java.awt.Color(255, 255, 255));
        phone_number_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phone_number_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(phone_number_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 220, 30));

        section_field.setBackground(new java.awt.Color(255, 255, 255));
        section_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        section_field.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(section_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 220, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("SECTION :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, -1, 20));

        gender_combo_box.setBackground(new java.awt.Color(255, 255, 255));
        gender_combo_box.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        gender_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(gender_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 230, 30));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setText("GENDER :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 20));

        picture_combo_box.setBackground(new java.awt.Color(255, 255, 255));
        picture_combo_box.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(153, 153, 153), null, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));
        jPanel1.add(picture_combo_box, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 420, 220, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setText("PICTURE :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("LAST NAME :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 100, 20));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("FIRST NAME :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 100, 20));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\reset (1).png")); // NOI18N
        jButton1.setText("Reset Button");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 510, 140, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 27)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dell\\Downloads\\tcc logo (6).png")); // NOI18N
        jLabel1.setText(" STUDENT DOCUMENT DEFICIENCY TRACKING SYSTEM :");
        jLabel1.setMaximumSize(new java.awt.Dimension(99, 0));
        jLabel1.setMinimumSize(new java.awt.Dimension(99, 0));
        jLabel1.setPreferredSize(new java.awt.Dimension(99, 0));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 750, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
          // TODO add your handling code here:
            DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
    int SelectedRows = jTable1.getSelectedRow();
    student_id_field.setText(RecordTable.getValueAt(SelectedRows, 0).toString());
    student_name_field.setText(RecordTable.getValueAt(SelectedRows, 1).toString());
    course_combo_box.setText(RecordTable.getValueAt(SelectedRows, 2).toString());
    age_field.setText(RecordTable.getValueAt(SelectedRows, 3).toString());
    grade_level_field.setText(RecordTable.getValueAt(SelectedRows, 4).toString());
    status_combo_box.setText(RecordTable.getValueAt(SelectedRows, 5).toString());
    section_field.setText(RecordTable.getValueAt(SelectedRows, 6).toString());
    gender_combo_box.setText(RecordTable.getValueAt(SelectedRows, 7).toString());
    phone_number_field.setText(RecordTable.getValueAt(SelectedRows, 8).toString());
    good_moral_combo_box.setText(RecordTable.getValueAt(SelectedRows, 10).toString());
    report_card_combo_box.setText(RecordTable.getValueAt(SelectedRows, 11).toString());
    birth_certificate_combo_box.setText(RecordTable.getValueAt(SelectedRows, 12).toString());
    medical_certificate_combo_box.setText(RecordTable.getValueAt(SelectedRows, 13).toString());
    picture_combo_box.setText(RecordTable.getValueAt(SelectedRows, 14).toString());


    }//GEN-LAST:event_jTable1MouseClicked

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
        jTable1.setModel(tableModel);
          
         
         
             // Set the row height
            int rowHeight = 30; // Set your desired row height
            this.jTable1.setRowHeight(rowHeight);
        

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
    Logger.getLogger(StudentBackground.class.getName()).log(Level.SEVERE, null, e);
    e.printStackTrace();
}
     TableColumnModel columnModel = this.jTable1.getColumnModel();
         TableColumn columnToZero = columnModel.getColumn(9);
         columnToZero.setMinWidth(0);
         columnToZero.setMaxWidth(0);
         columnToZero.setPreferredWidth(0);
         columnToZero.setWidth(0);
    }//GEN-LAST:event_searchActionPerformed

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTFActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        login log = new login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.student_id_field.setText("");
            this.student_name_field.setText("");
            this.course_combo_box.setText("");
            this.age_field.setText("");
            this.grade_level_field.setText("");
            this.status_combo_box.setText("");          
            this.section_field.setText("");
            this.gender_combo_box.setText("");
            this.phone_number_field.setText("");
            this.JPHOTO.setIcon(null);
            this.good_moral_combo_box.setText("");
            this.report_card_combo_box.setText("");
            this.birth_certificate_combo_box.setText("");
            this.medical_certificate_combo_box.setText("");
            this.picture_combo_box.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentRequirements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentRequirements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentRequirements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentRequirements.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentRequirements().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JPHOTO;
    private javax.swing.JLabel age_field;
    private javax.swing.JLabel birth_certificate_combo_box;
    private javax.swing.JLabel course_combo_box;
    private javax.swing.JLabel gender_combo_box;
    private javax.swing.JLabel good_moral_combo_box;
    private javax.swing.JLabel grade_level_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel medical_certificate_combo_box;
    private javax.swing.JLabel phone_number_field;
    private javax.swing.JLabel picture_combo_box;
    private javax.swing.JLabel report_card_combo_box;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchTF;
    private javax.swing.JLabel section_field;
    private javax.swing.JLabel status_combo_box;
    private javax.swing.JLabel student_id_field;
    private javax.swing.JLabel student_name_field;
    // End of variables declaration//GEN-END:variables
}
