package edu.neu.csye6200.views;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.controllers.StudentController;
import edu.neu.csye6200.controllers.TeacherController;
import edu.neu.csye6200.model.ClassRoom;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class StudentAssignment extends javax.swing.JPanel {
    
    private javax.swing.JButton btnAssign;
    private javax.swing.JComboBox<String> comboClassId;
    private javax.swing.JComboBox<String> comboStudentId;
    private javax.swing.JComboBox<String> comboTeacherName;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JLabel lblStudentId;
    private javax.swing.JLabel lblClassId;
    private javax.swing.JLabel lblTeacherName;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tableStudents;

    public StudentAssignment() throws SQLException {
    	initComponents();
        populateStudentIdDropdown();
            populateTeacherNameDropdown();
            populateTables(); // Assuming this method sets up the table
    }

    private void initComponents() {
        lblStudentId = new javax.swing.JLabel("Student ID");
        lblClassId = new javax.swing.JLabel("Class ID");
        lblTeacherName = new javax.swing.JLabel("Teacher Name");
        btnAssign = new javax.swing.JButton("Assign");
        scrollPane = new javax.swing.JScrollPane();
        tableStudents = new javax.swing.JTable();
        lblHeading = new javax.swing.JLabel("Student Class Assignment");
        comboStudentId = new javax.swing.JComboBox<>();
        comboClassId = new javax.swing.JComboBox<>();
        comboTeacherName = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(51, 102, 255));
        lblHeading.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        // Table model setup and other component initializations should be done here
        // Add your action listeners and other component setup code here

        btnAssign.addActionListener(evt -> assignActionPerformed(evt));
        comboStudentId.addActionListener(evt -> studentIdActionPerformed(evt));
        comboClassId.addActionListener(evt -> classIdActionPerformed(evt));
        // Layout setup code, adding components to the panel should be done here
    }

    private void assignActionPerformed(java.awt.event.ActionEvent evt) {
        int classId = Integer.parseInt(comboClassId.getSelectedItem().toString());
        int studentId = Integer.parseInt(comboStudentId.getSelectedItem().toString());
        String teacherName = comboTeacherName.getSelectedItem().toString();

        StudentController studentController = new StudentController();
        TeacherController teacherController = new TeacherController();
        
        try {
            studentController.UpdateStudentClass(studentId, classId);
            teacherController.updateClass(teacherName, classId);
            populateTables();
        } catch (SQLException ex) {
            Logger.getLogger(StudentAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populateTables() throws SQLException {
        DB db = DB.getObj();
        DefaultTableModel tableModel = (DefaultTableModel) tableStudents.getModel();
        tableModel.setRowCount(0);
        ResultSet rs = db.query("SELECT s.student_id, s.name, c.class_id FROM student s, classroom c WHERE s.class_id=c.class_id ORDER BY s.student_id;");
        System.out.println(rs);
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                row.add(rs.getObject(i));
            }
            tableModel.addRow(row);
        }
scrollPane.setViewportView(tableStudents);
        System.out.println(tableModel.getRowCount());
    }

    private void populateStudentIdDropdown() throws SQLException {
        List<Integer> studentIds = StudentController.getUnAssignedStudents();
        System.out.print("Stuydents"+ studentIds);
        for (Integer id : studentIds) {
        	 System.out.print(id);
            comboStudentId.addItem(id.toString());
        }
        scrollPane.setViewportView(tableStudents);
    }

    private void populateTeacherNameDropdown() throws SQLException {
        List<String> teacherNames = TeacherController.getTeacherList();
        for (String name : teacherNames) {
            comboTeacherName.addItem(name);
        }
        scrollPane.setViewportView(tableStudents);
    }


    private void classIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classidActionPerformed

    private void studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidActionPerformed
        // TODO add your handling code here:
        System.out.println("changed");
         ClassRoom cr = new ClassRoom();
        List<Integer> classes = new ArrayList<>();
        classes = cr.getClassList(Integer.parseInt(comboStudentId.getSelectedItem().toString()));
        comboClassId.removeAllItems();
        System.out.println(classes);
        for(int i=0;i<classes.size();i++){
        	comboClassId.addItem(classes.get(i).toString());
           // System.out.println(classes.get(i));
        }
        
    }//GEN-LAST:event_studentidActionPerformed

 public void tableShow5() throws SQLException{
         DB db = DB.getObj();
        DefaultTableModel df = (DefaultTableModel) tableStudents.getModel();
        df.setRowCount(0);
        ResultSet rs = db.query("SELECT s.student_id,s.name,c.class_id FROM student s,classroom c WHERE s.class_id=c.class_id order by s.student_id;");
        ResultSetMetaData rss = rs.getMetaData();
        int c = rss.getColumnCount();
        while(rs.next()){
            Vector v = new Vector();
            for (int a=1;a<=c;a++){
                v.add(rs.getString("student_id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("class_id"));
                  
            }
            df.addRow(v);
        }
    }
    
    int studentId;
    int classId;
    String fname;
    

    // End of variables declaration//GEN-END:variables
}
