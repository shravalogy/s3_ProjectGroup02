package edu.neu.csye6200.views;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.model.ClassRoom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for viewing or updating classes.
 */
public class ClassesViewOrUpdate extends JPanel {

    private JComboBox<String> classComboBox;
    private JLabel titleLabel;
    private JLabel classLabel;
    private JButton viewButton;
    private JScrollPane scrollPane;
    private JTable classTable;
    private JPanel controlPanel;

    public ClassesViewOrUpdate() {
        initComponents();
        populateClassComboBox();
    }

    private void initComponents() {
        controlPanel = new JPanel();
        classLabel = new JLabel("Class:");
        viewButton = new JButton("View");
        classComboBox = new JComboBox<>();
        scrollPane = new JScrollPane();
        classTable = new JTable();
        titleLabel = new JLabel("Classrooms");

        setBackground(new Color(51, 102, 255));
        controlPanel.setBackground(new Color(240, 240, 240));

        viewButton.addActionListener(this::viewButtonActionPerformed);

        classTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {"Teacher ID", "Teacher Name", "Student ID", "Student Name"}
        ));
        scrollPane.setViewportView(classTable);

        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(255, 255, 255));

        // Layout configuration for this panel
        setLayout(new BorderLayout(10, 10));
        add(titleLabel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        // Layout configuration for the control panel
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.PAGE_AXIS));
        controlPanel.add(classLabel);
        controlPanel.add(classComboBox);
        controlPanel.add(viewButton);
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void populateClassComboBox() {
        ClassRoom classroom = new ClassRoom();
        List<Integer> classList = classroom.getallClassList();
        for (int classId : classList) {
            classComboBox.addItem(Integer.toString(classId));
        }
    }

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedClass = (String) classComboBox.getSelectedItem();
        if (selectedClass != null) {
            updateClassTable(selectedClass);
        }
    }

    private void updateClassTable(String classId) {
        try {
        	
//        	DB db = DB.getObj();
//            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();
//            df.setRowCount(0);
//              ResultSet rs = db.query("SELECT e.employee_id ,e.fname,s.student_id,s.name FROM student s, teacher e"
//                      + " WHERE s.class_id="+inp+" AND s.class_id=e.class_id;");
//            ResultSetMetaData rss = rs.getMetaData();
//            int c = rss.getColumnCount();
//            while (rs.next()) {
//                Vector v = new Vector();
//                for (int a = 1; a <= c; a++) {
//                    v.add(rs.getString("employee_id"));
//                    v.add(rs.getString("fname"));
//                    v.add(rs.getString("student_id"));
//                    v.add(rs.getString("name"));
//                    
//                }
//                df.addRow(v);
            DB db = DB.getObj(); // Assuming 'getInstance' is the method to get a DB object
            DefaultTableModel model = (DefaultTableModel) classTable.getModel();
            model.setRowCount(0);
            ResultSet rs = db.query("SELECT teacher.employee_id, teacher.fname, student.student_id, student.name " +
                    "FROM student, teacher WHERE student.class_id=" + classId + " AND student.class_id=teacher.class_id;");
            while (rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString("employee_id"));
                row.add(rs.getString("fname"));
                row.add(rs.getString("student_id"));
                row.add(rs.getString("name"));
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassesViewOrUpdate.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
