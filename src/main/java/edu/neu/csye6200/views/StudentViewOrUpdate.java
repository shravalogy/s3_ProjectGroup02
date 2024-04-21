package edu.neu.csye6200.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.controllers.StudentController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentViewOrUpdate extends javax.swing.JPanel {

    public StudentViewOrUpdate() throws SQLException {
        initComponents();
        tableShow();
        studentID.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        // Initialization code...
        studentIDLabel = new javax.swing.JLabel();
        studentID = new javax.swing.JTextField();
        studentNameLabel = new javax.swing.JLabel();
        student_Name = new javax.swing.JTextField();
        dobLabel = new javax.swing.JLabel();
        dob = new javax.swing.JTextField();
        parentIDLabel = new javax.swing.JLabel();
        parentID = new javax.swing.JTextField();
        parentNameLabel = new javax.swing.JLabel();
        parent_Name = new javax.swing.JTextField();
        parentAddressLabel = new javax.swing.JLabel();
        parent_Address = new javax.swing.JTextField();
        parentPhoneNumLabel = new javax.swing.JLabel();
        parentPhoneNum = new javax.swing.JTextField();
        emailParentLabel = new javax.swing.JLabel();
        emailParent = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        heading = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 0, 0));
            // Initialization code...

            // Instantiate labels and set text
            studentIDLabel = new javax.swing.JLabel();
            studentIDLabel.setText("Student ID:");

            studentNameLabel = new javax.swing.JLabel();
            studentNameLabel.setText("Student Name:");

            dobLabel = new javax.swing.JLabel();
            dobLabel.setText("Date of Birth:");

            parentIDLabel = new javax.swing.JLabel();
            parentIDLabel.setText("Parent ID:");

            parentNameLabel = new javax.swing.JLabel();
            parentNameLabel.setText("Parent Name:");

            parentAddressLabel = new javax.swing.JLabel();
            parentAddressLabel.setText("Parent Address:");

            parentPhoneNumLabel = new javax.swing.JLabel();
            parentPhoneNumLabel.setText("Parent Phone Number:");

            emailParentLabel = new javax.swing.JLabel();
            emailParentLabel.setText("Parent Email:");
            
            Update.setText("Update");
            Update.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    UpdateActionPerformed(evt);
                }
            });


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{{null, null, null, null, null, null, null, null, null}},
                new String[]{"Student ID", "Student Name", "Age", "Date of Birth", "Parent ID", "Parent Name", "Address", "Phone Number", "Email"}
        ) {
            Class[] types = new Class[]{java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class};

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        heading.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        heading.setText("Students Details");

        // Layout code...
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            	.addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            	.addGap(50, 50, 50)
                                .addComponent(studentIDLabel)
                                .addComponent(studentID, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(studentNameLabel)
                                .addComponent(student_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dobLabel)
                                .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(parentIDLabel)
                                .addComponent(parentID, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(parentNameLabel)
                                .addComponent(parent_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(parentAddressLabel)
                                .addComponent(parent_Address, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(parentPhoneNumLabel)
                                .addComponent(parentPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailParentLabel)
                                .addComponent(emailParent, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(heading))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(350, 350, 350)
                            .addComponent(Update)))
                    .addContainerGap())
        );

        layout.setVerticalGroup(
        	    layout.createSequentialGroup()
        	        .addContainerGap()
        	        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
        	        .addGap(18, 18, 18)
        	        .addComponent(heading)
        	        .addGap(18, 18, 18) // Added spacing between heading and first row
        	        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        	            .addComponent(studentIDLabel)
        	            .addComponent(parentIDLabel))
        	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        	        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        	            .addComponent(studentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        	            .addComponent(parentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Adjusted for more space between rows
        	        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        	            .addComponent(studentNameLabel)
        	            .addComponent(parentNameLabel))
        	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Adjusted for more space between rows
        	        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        	            .addComponent(student_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        	            .addComponent(parent_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Adjusted for more space between rows
        	        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        	            .addComponent(dobLabel)
        	            .addComponent(parentAddressLabel))
        	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Adjusted for more space between rows
        	        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        	            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        	            .addComponent(parent_Address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Adjusted for more space between rows
        	        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        	            .addComponent(parentPhoneNumLabel)
        	            .addComponent(emailParentLabel))
        	        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED) // Adjusted for more space between rows
        	        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        	            .addComponent(parentPhoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        	            .addComponent(emailParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        	        .addGap(18, 18, 18)
        	        .addComponent(Update)
        	        .addContainerGap(52, Short.MAX_VALUE)
        	);

    }// </editor-fold>

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // Validation and update logic here
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        if (studentID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Select a student to update", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (student_Name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Student Name Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (dob.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "DOB Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (parentID.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Parent ID Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (parent_Name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Parent Name Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (parent_Address.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Parent Address Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (parentPhoneNum.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Parent Phone Number Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (emailParent.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Parent Email Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!parentPhoneNum.getText().matches("^(1\\s?)?(\\d{3}|\\(\\d{3}\\))[\\s\\-]?\\d{3}[\\s\\-]?\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "Enter a Valid Phone Number", "Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!emailParent.getText().matches(regexPattern)) {
            JOptionPane.showMessageDialog(this, "Enter a Valid Email", "Invalid Email", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update logic here
        studentName = student_Name.getText();
        studentId = Integer.parseInt(studentID.getText());
        dateofBirth = dob.getText();
        parentId = Integer.parseInt(parentID.getText());
        parentName = parent_Name.getText();
        parentAddress = parent_Address.getText();
        parentPhoneNo = parentPhoneNum.getText();
        email = emailParent.getText();

        System.out.println("Student ID " + studentId);

        StudentController std = new StudentController();
        try {
            std.updateStudentAndParent(studentId, studentName, dateofBirth,
                    parentId, parentName, parentAddress, parentPhoneNo, email);
            tableShow();
        } catch (InterruptedException | SQLException ex) {
            Logger.getLogger(StudentViewOrUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UpdateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        int selectedRow = jTable1.getSelectedRow();

        studentID.setText(df.getValueAt(selectedRow, 0).toString());
        student_Name.setText(df.getValueAt(selectedRow, 1).toString());
        dob.setText(df.getValueAt(selectedRow, 3).toString());
        emailParent.setText(df.getValueAt(selectedRow, 8).toString());
        parentID.setText(df.getValueAt(selectedRow, 4).toString());
        parent_Name.setText(df.getValueAt(selectedRow, 5).toString());
        parent_Address.setText(df.getValueAt(selectedRow, 6).toString());
        parentPhoneNum.setText(df.getValueAt(selectedRow, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    public void tableShow() throws SQLException {
        DB db = DB.getObj();
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
        df.setRowCount(0);
        ResultSet rs = db.query("SELECT s.student_id,s.name,s.age,s.dob,s.parent_id,p.p_name,p.address,p.phone,p.email"
                + " FROM student s,guardians p WHERE s.parent_id=p.parent_id order by s.student_id ;");
        java.sql.ResultSetMetaData rss = rs.getMetaData();
        int c = rss.getColumnCount();
        while (rs.next()) {
            Vector v = new Vector();
            for (int a = 1; a <= c; a++) {
                v.add(rs.getString("student_id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("age"));
                v.add(rs.getString("dob"));
                v.add(rs.getString("parent_id"));
                v.add(rs.getString("p_name"));
                v.add(rs.getString("address"));
                v.add(rs.getString("phone"));
                v.add(rs.getString("email"));
            }
            df.addRow(v);
        }
    }

    int studentId;
    String studentName;
    String dateofBirth;
    double gpa;
    int parentId;
    String parentName;
    String parentAddress;
    String parentPhoneNo;
    String email;

    // Variables declaration - do not modify
    private javax.swing.JButton Update;
    private javax.swing.JTextField dob;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JTextField emailParent;
    private javax.swing.JLabel emailParentLabel;
    private javax.swing.JLabel heading;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField parent_Address;
    private javax.swing.JLabel parentAddressLabel;
    private javax.swing.JTextField parentID;
    private javax.swing.JLabel parentIDLabel;
    private javax.swing.JTextField parent_Name;
    private javax.swing.JLabel parentNameLabel;
    private javax.swing.JTextField parentPhoneNum;
    private javax.swing.JLabel parentPhoneNumLabel;
    private javax.swing.JTextField studentID;
    private javax.swing.JLabel studentIDLabel;
    private javax.swing.JTextField student_Name;
    private javax.swing.JLabel studentNameLabel;
    // End of variables declaration
}

