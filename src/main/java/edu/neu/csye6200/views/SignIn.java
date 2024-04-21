/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.neu.csye6200.views;
import edu.neu.csye6200.controllers.SignInController;
import edu.neu.csye6200.model.Auth;
import edu.neu.csye6200.views.TeacherRegistrationPannel;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SignIn extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signInButton, signUpButton;
    private JLabel errorMessageLabel, heading, usernameLabel, passwordLabel;

    public SignIn() {
        initComponents();
        setupLayout();
        setTitle("Student Information System - Sign In");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Center on screen
        setResizable(false);
    }

    private void initComponents() {
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        signInButton = new JButton("Sign In");
        signUpButton = new JButton("Sign Up");
        errorMessageLabel = new JLabel();
        heading = new JLabel("Student Information System", SwingConstants.CENTER);
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        signInButton.addActionListener(this::signInAction);
        signUpButton.addActionListener(this::signUpAction);
    }

    private void setupLayout() {
        setLayout(new BorderLayout(10, 10));
        heading.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.EAST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        centerPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        centerPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        centerPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        centerPanel.add(passwordField, gbc);

        add(centerPanel, BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        southPanel.add(signInButton);
        southPanel.add(signUpButton);
        southPanel.add(errorMessageLabel);
        add(southPanel, BorderLayout.SOUTH);
    }

    private void signInAction(ActionEvent evt) {
        // Placeholder for sign-in logic
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();

        if (username.isBlank()) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            errorMessageLabel.setText("Username cannot be empty");
            return;
        }
        if (password.length == 0) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            errorMessageLabel.setText("Password cannot be empty");
            return;
        }
        
        // Call the SignInController to validate the credentials
        boolean loginValid = SignInController.isLoginValid(username, password);
        if (loginValid) {
            errorMessageLabel.setText("Valid Login");
            // Open MainFrame and close SignIn window
            System.out.print("inside login");
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
            this.dispose(); // Hide SignIn frame
        } else {
            errorMessageLabel.setText("Invalid Login");
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void signUpAction(ActionEvent evt) {
        // Placeholder for sign-up logic
        new SignUp().setVisible(true); // Make sure SignUp is defined somewhere
        this.dispose(); // Close the sign-in window
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new SignIn().setVisible(true));
    }

    // MainFrame class definition
    // This is a placeholder for your MainFrame class
    // Replace this with the actual MainFrame class content

    // SignUp class definition
    // This is a placeholder for your SignUp class
    // Replace this with the actual SignUp class content
    

    // Additional methods and class variables...

}
