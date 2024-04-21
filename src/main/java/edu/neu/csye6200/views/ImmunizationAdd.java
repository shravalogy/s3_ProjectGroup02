package edu.neu.csye6200.views;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.controllers.ImmunizationController;
import edu.neu.csye6200.controllers.StudentController;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ImmunizationAdd extends javax.swing.JPanel {

    private JLabel title;
    private JLabel studentIdLabel;
    private JComboBox<String> studentIdDropdown;
    private JLabel fullyVaccinatedLabel;
    private JRadioButton yesOption;
    private JRadioButton noOption;
    private JLabel upcomingDoseDateLabel;
    private JButton submitButton;
    private JScrollPane tableScrollPane;
    private JTable immunizationRecordTable;
    private JButton sendEmailButton;
    private JTextField upcomingDoseDateText;
    private boolean isFullyVaccinated;

    public ImmunizationAdd() throws SQLException {
        initComponents();
        loadStudentIds();
        setupVaccinationRadioButtons();
        loadImmunizationRecords();
    }

    private void initComponents() {

        title = new JLabel("Student Immunization Management");
        studentIdLabel = new JLabel("Student ID");
        studentIdDropdown = new JComboBox<>();
        fullyVaccinatedLabel = new JLabel("Fully Vaccinated");
        yesOption = new JRadioButton("Yes");
        noOption = new JRadioButton("No");
        upcomingDoseDateLabel = new JLabel("Upcoming Dose Date");
        submitButton = new JButton("SUBMIT");
        tableScrollPane = new JScrollPane();
        immunizationRecordTable = new JTable();
        sendEmailButton = new JButton("Send Email");
        upcomingDoseDateText = new JTextField();
        ButtonGroup vaccinationButtonGroup = new ButtonGroup();

        setBackground(new java.awt.Color(153,0,0));
        title.setFont(new java.awt.Font("Helvetica Neue", 1, 24));
        
        // Table setup
        immunizationRecordTable.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "SVID", "Student ID", "Vaccinated", "Upcoming Dose Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableScrollPane.setViewportView(immunizationRecordTable);

        // Layout setup
        setLayout(new java.awt.BorderLayout());

        // Top Panel setup
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new java.awt.GridLayout(5, 2, 10, 10));
        topPanel.add(studentIdLabel);
        topPanel.add(studentIdDropdown);
        topPanel.add(fullyVaccinatedLabel);
        topPanel.add(yesOption);
        topPanel.add(noOption);
        topPanel.add(upcomingDoseDateLabel);
        topPanel.add(upcomingDoseDateText);
        topPanel.add(submitButton);
        topPanel.add(sendEmailButton);

        vaccinationButtonGroup.add(yesOption);
        vaccinationButtonGroup.add(noOption);

        add(title, java.awt.BorderLayout.NORTH);
        add(topPanel, java.awt.BorderLayout.CENTER);
        add(tableScrollPane, java.awt.BorderLayout.SOUTH);

        // Button actions
        submitButton.addActionListener(evt -> onSubmit());
        sendEmailButton.addActionListener(evt -> onSendEmail());
    }

    private void loadStudentIds() throws SQLException {
        List<Integer> studentIds = StudentController.getAllStudents();
        for (int id : studentIds) {
            studentIdDropdown.addItem(Integer.toString(id));
        }
    }

    private void setupVaccinationRadioButtons() {
        yesOption.addActionListener(evt -> {
            isFullyVaccinated = true;
            upcomingDoseDateText.setEnabled(false);
        });

        noOption.addActionListener(evt -> {
            isFullyVaccinated = false;
            upcomingDoseDateText.setEnabled(true);
        });
    }

 // Method to load student records into the table
    public void loadImmunizationRecords() {
        DefaultTableModel tableModel = (DefaultTableModel) immunizationRecordTable.getModel();
        tableModel.setRowCount(0); // Clear the existing table content

        try {
            // Assuming you have a static method getObj() in DB class that returns a DB instance
            DB db = DB.getObj();
            ResultSet rs = db.query("SELECT * FROM student_immunizations;"); // Your SQL query
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Processing the result set
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getString("svid")); // Matches "SVID"
                    vector.add(rs.getString("student_id")); // Matches "Student ID"
                    vector.add(rs.getString("vaccinated")); // Matches "Vaccinated"
                    vector.add(rs.getString("next_dose_due_date")); // Matches "Upcoming Dose Date"
                }
                tableModel.addRow(vector);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImmunizationAdd.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading immunization records: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ... rest of your code



    private void onSubmit() {
        // ... Your original code to prepare for submission
        int selectedStudentId = Integer.parseInt(studentIdDropdown.getSelectedItem().toString());
        boolean isVaccinated = yesOption.isSelected();
        String nextDoseDate = isVaccinated ? null : upcomingDoseDateText.getText();

        // Implement your validation and submission logic here
        if (!isVaccinated && nextDoseDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please provide the upcoming vaccination date.", "Field Empty", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
        	 ImmunizationController std = new ImmunizationController();
        	boolean success = std.addImmunization( 
        		    isVaccinated ? "Yes" : "No", // Convert boolean to String
        		    nextDoseDate,
        		    selectedStudentId// Already a String
        		);
            if (success) {
                JOptionPane.showMessageDialog(this, "Immunization record added successfully.");
                loadImmunizationRecords(); // Reload the table
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add the immunization record.");
            }
        } catch (Exception ex) {
            Logger.getLogger(ImmunizationAdd.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error occurred while adding immunization record: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onSendEmail() {
        // Call the controller method to send emails
        try {
        	 ImmunizationController imc = new ImmunizationController();
             imc.sendMail();
            JOptionPane.showMessageDialog(this, "Immunization reminders sent successfully.");
        } catch (Exception ex) {
            Logger.getLogger(ImmunizationAdd.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error occurred while sending email reminders: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ... Other methods as necessary


    // Additional methods as necessary
}
