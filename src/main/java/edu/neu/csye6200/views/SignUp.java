/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.neu.csye6200.views;
import edu.neu.csye6200.controllers.SignInController;
import edu.neu.csye6200.controllers.SignUpController;
import edu.neu.csye6200.model.Auth;
import edu.neu.csye6200.views.TeacherRegistrationPannel;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.*;
import java.awt.*;

public class SignUp extends JFrame {

    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton signUpButton, signInButton;
    private JLabel errorMessageLabel, heading, userNameLabel, passwordLabel, userTypeLabel;
    private JComboBox<String> userTypeComboBox;

    public SignUp() {
        initComponents();
        setupLayout();
        setTitle("Student Information System - Sign Up");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center on screen
        setResizable(false);
    }

    private void initComponents() {
        userNameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        signUpButton = new JButton("Sign Up");
        signInButton = new JButton("Sign In");
        errorMessageLabel = new JLabel();
        heading = new JLabel("Student Information System - Sign Up", SwingConstants.CENTER);
        userNameLabel = new JLabel("User Name:");
        passwordLabel = new JLabel("Password:");
        userTypeLabel = new JLabel("User Type:");
        userTypeComboBox = new JComboBox<>(new String[]{"Admin", "Teacher"});

        signUpButton.addActionListener(evt -> signUpAction());
        signInButton.addActionListener(evt -> {
            SignIn signIn = new SignIn();
            signIn.setVisible(true);
            this.dispose();
        });
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        heading.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(userNameLabel, gbc);

        gbc.gridx = 1;
        centerPanel.add(userNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        centerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        centerPanel.add(userTypeLabel, gbc);

        gbc.gridx = 1;
        centerPanel.add(userTypeComboBox, gbc);

        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        southPanel.add(signUpButton);
        southPanel.add(signInButton);
        southPanel.add(errorMessageLabel);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void signUpAction() {
        String userName = userNameField.getText();
        char[] password = passwordField.getPassword();
        String userType = userTypeComboBox.getSelectedItem().toString();
        
        if (userName.isBlank()) {
            JOptionPane.showMessageDialog(this, "User Name Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            errorMessageLabel.setText("User Name Cannot be empty");
            return;
        }
        if (password.length == 0) {
            JOptionPane.showMessageDialog(this, "Password Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            errorMessageLabel.setText("Password Cannot be empty");
            return;
        }
        
        // Replace this with the actual sign-up process logic.
        boolean userCreationSuccess = SignUpController.signUp(userName, password, userType);
        
        if (userCreationSuccess) {
            errorMessageLabel.setText("User successfully created");
            SignIn signIn = new SignIn();
            signIn.setVisible(true);
            this.dispose();
        } else {
            errorMessageLabel.setText("Error in creating user");
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new SignUp().setVisible(true));
    }
}

// You will need to create the SignUpController class with a signUp method that matches the call above.
// The signUp method should handle the business logic for registering a new user.
