    package edu.neu.csye6200.views;
    import edu.neu.csye6200.controllers.StudentController;
    import javax.swing.*;
    import java.awt.*;

    public class StudentRegistration extends JPanel {

        private JLabel titleLbl;
        private JTextField studentNameField, dobField, parentNameField, addressField, phoneField, emailField;
        private JButton addStudentButton;

        public StudentRegistration() {
            setLayout(new BorderLayout());
            initializeUIComponents();
            constructLayout();
        }

        private void initializeUIComponents() {
            titleLbl = new JLabel("Student Registration");
            titleLbl.setFont(new Font("Helvetica Neue", Font.BOLD, 24));
            titleLbl.setHorizontalAlignment(JLabel.CENTER);
            titleLbl.setForeground(Color.WHITE);

            studentNameField = new JTextField(20);
            dobField = new JTextField(20);
            parentNameField = new JTextField(20);
            addressField = new JTextField(20);
            phoneField = new JTextField(20);
            emailField = new JTextField(20);

            addStudentButton = new JButton("Add Student");
            addStudentButton.addActionListener(e -> addStudent());
        }

        private void constructLayout() {
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(6, 2, 10, 10));
            formPanel.add(new JLabel("Student Name:"));
            formPanel.add(studentNameField);
            formPanel.add(new JLabel("Date of Birth (YYYY-MM-DD):"));
            formPanel.add(dobField);
            formPanel.add(new JLabel("Parent Name:"));
            formPanel.add(parentNameField);
            formPanel.add(new JLabel("Address:"));
            formPanel.add(addressField);
            formPanel.add(new JLabel("Phone:"));
            formPanel.add(phoneField);
            formPanel.add(new JLabel("Email:"));
            formPanel.add(emailField);

            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            add(titleLbl, BorderLayout.NORTH);
            add(formPanel, BorderLayout.CENTER);
            add(addStudentButton, BorderLayout.SOUTH);

            setBackground(new Color(0, 102, 255));
        }
        private boolean isValidEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            return email.matches(emailRegex);
        }

        private boolean isValidPhone(String phone) {
            // This regex will validate a phone number in the format "123-456-7890"
            String phoneRegex = "^(\\d{3}[- ]?){2}\\d{4}$";
            return phone.matches(phoneRegex);
        }

        private void addStudent() {
            String studentName = studentNameField.getText();
            String dob = dobField.getText();
            String parentName = parentNameField.getText();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();

            if (studentName.isEmpty() || dob.isEmpty() || parentName.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please provide all fields.", "Field Empty", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidEmail(email)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Invalid Email", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isValidPhone(phone)) {
                JOptionPane.showMessageDialog(this, "Please enter a valid phone number.", "Invalid Phone", JOptionPane.ERROR_MESSAGE);
                return;
            }
            StudentController std = new StudentController();

            boolean success = std.addStudentAndParent(studentName, dob, parentName, phone, address, email);
            if (success) {
                JOptionPane.showMessageDialog(this, "Student registered Successfully");
                clearFormFields();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to register student.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void clearFormFields() {
            studentNameField.setText("");
            dobField.setText("");
            parentNameField.setText("");
            addressField.setText("");
            phoneField.setText("");
            emailField.setText("");
        }
    }
  
