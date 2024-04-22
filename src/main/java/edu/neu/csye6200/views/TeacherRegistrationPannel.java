package edu.neu.csye6200.views;

import edu.neu.csye6200.controllers.TeacherController;
import edu.neu.csye6200.model.Teacher;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.util.List;
import edu.neu.csye6200.model.ClassRoom;

public class TeacherRegistrationPannel extends javax.swing.JPanel {
	private JComboBox<String> classidComboBox;

    public TeacherRegistrationPannel() {
        initComponents();
        populateClassIDs();
    }

    private void populateClassIDs() {
        ClassRoom cr = new ClassRoom();
        List<Integer> classes = cr.getallClassList();
        for (Integer classId : classes) {
        	classidComboBox.addItem(classId.toString());
        }
    }

    private void initComponents() {
        setBackground(new java.awt.Color(245, 245, 245));

        // Labels
        JLabel firstNameLabel = new JLabel("First Name:");
        JLabel lastNameLabel = new JLabel("Last Name:");
        JLabel phoneLabel = new JLabel("Phone Number:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel typeLabel = new JLabel("Employee Type:");
        JLabel classidLabel = new JLabel("Class ID:");
        JLabel heading = new JLabel("Instructor Registration", SwingConstants.CENTER);
        heading.setFont(new java.awt.Font("Segoe UI", 1, 24));

        // Text fields and area
        JTextField firstNameTextField = new JTextField(20);
        JTextField lastNameTextField = new JTextField(20);
        JTextField phoneTextField = new JTextField(20);
        JTextArea addressTextArea = new JTextArea(5, 20);
        addressTextArea.setWrapStyleWord(true);
        addressTextArea.setLineWrap(true);
        JScrollPane addressScrollPane = new JScrollPane(addressTextArea);

        // ComboBoxes
        JComboBox<String> typeComboBox = new JComboBox<>(new String[] {"Teacher", "Accountant", "Worker"});
        classidComboBox = new JComboBox<>();

        // Button
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(evt -> registerTeacher(firstNameTextField, lastNameTextField, phoneTextField, addressTextArea, typeComboBox, classidComboBox));

        // Layout setup using GroupLayout for flexibility
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Horizontal layout
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(heading, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel)
                    .addComponent(lastNameLabel)
                    .addComponent(phoneLabel)
                    .addComponent(addressLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameTextField)
                    .addComponent(lastNameTextField)
                    .addComponent(phoneTextField)
                    .addComponent(addressScrollPane)))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(typeLabel)
                    .addComponent(classidLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(typeComboBox)
                    .addComponent(classidComboBox)))
            .addComponent(registerButton, GroupLayout.Alignment.CENTER)
        );

        // Vertical layout
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addComponent(heading)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(firstNameLabel)
                .addComponent(firstNameTextField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(lastNameLabel)
                .addComponent(lastNameTextField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(phoneLabel)
                .addComponent(phoneTextField))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(addressLabel)
                .addComponent(addressScrollPane))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(typeLabel)
                .addComponent(typeComboBox))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(classidLabel)
                .addComponent(classidComboBox))
            .addComponent(registerButton)
        );
    }

    private void registerTeacher(JTextField firstName, JTextField lastName, JTextField phone, JTextArea address, JComboBox<String> type, JComboBox<String> classid) {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || phone.getText().isEmpty() || address.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!phone.getText().matches("^(1\\s?)?(\\d{3}|\\(\\d{3}\\))[\\s\\-]?\\d{3}[\\s\\-]?\\d{4}$")) {
            JOptionPane.showMessageDialog(this, "Enter a valid phone number", "Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Teacher teacher = new Teacher();
        teacher.setFname(firstName.getText());
        teacher.setLname(lastName.getText());
        teacher.setAddress(address.getText());
        teacher.setPhoneNo(phone.getText());
        teacher.setClassId(Integer.parseInt(classid.getSelectedItem().toString()));

        TeacherController teacherController = new TeacherController();
        boolean isSuccess = teacherController.register(teacher);
        if (isSuccess) {
            JOptionPane.showMessageDialog(null, "Teacher registered successfully!");
            firstName.setText("");
            lastName.setText("");
            address.setText("");
            phone.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Registration failed. Please try again.", "Registration Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}
