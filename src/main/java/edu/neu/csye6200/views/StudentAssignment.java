/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package edu.neu.csye6200.views;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.controllers.StudentController;
import edu.neu.csye6200.controllers.TeacherController;
import edu.neu.csye6200.model.ClassRoom;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author premkumarmanoharan
 */
public class StudentAssignment extends javax.swing.JPanel {

    /**
     * Creates new form StudentAssignment
     */
    public StudentAssignment() throws SQLException {
        initComponents();
        tableShow5();
        List<Integer> list = new ArrayList<>();
        list = StudentController.getUnAssignedStudents();
        for(int i=0;i<list.size();i++){
            studentid.addItem(list.get(i).toString());
            // System.out.println(list.get(i));
        }

        List<String> teachers = new ArrayList<>();
        teachers = TeacherController.getTeacherList();
        for(int i=0;i<teachers.size();i++){
            teacherName.addItem(teachers.get(i));
            System.out.println(teachers.get(i));
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

        jLabel2 = new javax.swing.JLabel();
        assign = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        heading = new javax.swing.JLabel();
        studentid = new javax.swing.JComboBox<>();
        classid = new javax.swing.JComboBox<>();
        teacherName = new javax.swing.JComboBox<>();

        setBackground(new Color(153, 0, 0));

        jLabel2.setText("Class ID");

        assign.setText("Assign");
        assign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignActionPerformed(evt);
            }
        });

        jLabel3.setText("Teacher Name");

        jLabel1.setText("Student ID");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null}
                },
                new String [] {
                        "Student ID", "Student Name", "Class ID"
                }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        heading.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        heading.setText("Student Class Assignment");

        studentid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentidActionPerformed(evt);
            }
        });

        classid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(111, 111, 111)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(studentid, 0, 99, Short.MAX_VALUE)
                                                        .addComponent(classid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(teacherName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(assign)))
                                .addGap(85, 85, 85)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(65, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(heading)
                                .addGap(357, 357, 357))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(studentid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(classid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(teacherName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(38, 38, 38)
                                                .addComponent(assign))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(heading)
                                                .addGap(36, 36, 36)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignActionPerformed
        // TODO add your handling code here:
        classId=Integer.parseInt(classid.getSelectedItem().toString());
        studentId=Integer.parseInt(studentid.getSelectedItem().toString());
        fname = teacherName.getSelectedItem().toString();

        StudentController std = new StudentController();
        try {
            std.UpdateStudentClass(studentId, classId);
            tableShow5();
        } catch (SQLException ex) {
            Logger.getLogger(StudentAssignment.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        TeacherController tc = new TeacherController();
        try {
            tc.updateClass(fname, classId);
            tableShow5();
        } catch (SQLException ex) {
            Logger.getLogger(StudentAssignment.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
    }//GEN-LAST:event_assignActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
//        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
//        int selectedRow = jTable1.getSelectedRow();

        //studentId5.setText(df.getValueAt(selectedRow,0).toString());
        //  classID.setText(df.getValueAt(selectedRow,2).toString());
        // TeacherName.setText(df.getValueAt(selectedRow,3).toString());

    }//GEN-LAST:event_jTable1MouseClicked

    private void classidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classidActionPerformed

    private void studentidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentidActionPerformed
        // TODO add your handling code here:
        System.out.println("changed");
        ClassRoom cr = new ClassRoom();
        List<Integer> classes = new ArrayList<>();
        classes = cr.getClassList(Integer.parseInt(studentid.getSelectedItem().toString()));
        classid.removeAllItems();
        System.out.println(classes);
        for(int i=0;i<classes.size();i++){
            classid.addItem(classes.get(i).toString());
            // System.out.println(classes.get(i));
        }

    }//GEN-LAST:event_studentidActionPerformed

    public void tableShow5() throws SQLException{
        DB db = DB.getObj();
        DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assign;
    private javax.swing.JComboBox<String> classid;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> studentid;
    private javax.swing.JComboBox<String> teacherName;
    // End of variables declaration//GEN-END:variables
}
