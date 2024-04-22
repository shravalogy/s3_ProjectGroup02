package edu.neu.csye6200.views;
import edu.neu.csye6200.controllers.SignInController;
import edu.neu.csye6200.model.Auth;
import edu.neu.csye6200.views.TeacherRegistrationPannel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainFrame extends JFrame {

    private JButton teacherRegistrationButton;
    private JButton studentRegistrationButton;
    private JButton studentViewUpdateButton;
    private JButton immunizationButton;
    private JButton assignStudentsButton;
    private JButton teacherViewUpdateButton;
    private JButton annualReviewButton;
    private JButton classViewUpdateButton;
    private JButton signOutButton;
    private JPanel mainContentPanel;
    private CardLayout cardLayout;

    public MainFrame() {
        initComponents();
        setupButtonActions();
        setTitle("Student Information System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Set the initial size of the frame
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void initComponents() {
        mainContentPanel = new JPanel();
        cardLayout = new CardLayout();
        mainContentPanel.setLayout(cardLayout);

        // Create the actual panels for each part of the application
        try {
			createPanels();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(153, 0, 0));
        
        // Initialize and add buttons to the button panel
        teacherRegistrationButton = new JButton("Instructor Registration");
        studentRegistrationButton = new JButton("Student Registration");
        studentViewUpdateButton = new JButton("Student View/Update");
        immunizationButton = new JButton("Student_immunizations");
        assignStudentsButton = new JButton("Assign Students");
        teacherViewUpdateButton = new JButton("Teacher View/Update");
        annualReviewButton = new JButton("Annual Review");
        classViewUpdateButton = new JButton("Class View/Update");
        signOutButton = new JButton("LOG OUT");

        buttonPanel.add(teacherRegistrationButton);
        buttonPanel.add(studentRegistrationButton);
        buttonPanel.add(studentViewUpdateButton);
        buttonPanel.add(immunizationButton);
        buttonPanel.add(assignStudentsButton);
        buttonPanel.add(teacherViewUpdateButton);
        buttonPanel.add(annualReviewButton);
        buttonPanel.add(classViewUpdateButton);
        buttonPanel.add(signOutButton);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, mainContentPanel, buttonPanel);
        splitPane.setResizeWeight(1); // Content takes all the initial resize space
        splitPane.setDividerSize(0);
        setContentPane(splitPane);
        checkVisibility();
    }
    
    private void checkVisibility(){
        String userType = Auth.getUserType();

        if(!userType.contentEquals("Admin")){
                teacherRegistrationButton.setVisible(false);
                annualReviewButton.setVisible(false);
                teacherViewUpdateButton.setVisible(false);
                immunizationButton.setVisible(false);
        }
    }

    private void setupButtonActions() {
        teacherRegistrationButton.addActionListener(e -> cardLayout.show(mainContentPanel, "TeacherRegistrationPanel"));
        studentRegistrationButton.addActionListener(e -> cardLayout.show(mainContentPanel, "StudentRegistrationPanel"));
        studentViewUpdateButton.addActionListener(e -> cardLayout.show(mainContentPanel, "StudentViewUpdatePanel"));
        immunizationButton.addActionListener(e -> cardLayout.show(mainContentPanel, "ImmunizationPanel"));
        assignStudentsButton.addActionListener(e -> cardLayout.show(mainContentPanel, "AssignStudentsPanel"));
        teacherViewUpdateButton.addActionListener(e -> cardLayout.show(mainContentPanel, "TeacherViewUpdatePanel"));
        annualReviewButton.addActionListener(e -> cardLayout.show(mainContentPanel, "AnnualReviewPanel"));
        classViewUpdateButton.addActionListener(e -> cardLayout.show(mainContentPanel, "ClassViewUpdatePanel"));
        signOutButton.addActionListener(e -> signOut());

    }

    private void createPanels() throws SQLException {
        mainContentPanel.add(new TeacherRegistrationPannel(), "TeacherRegistrationPanel");
        mainContentPanel.add(new StudentRegistration(), "StudentRegistrationPanel");
        mainContentPanel.add(new StudentViewOrUpdate(), "StudentViewUpdatePanel");
        mainContentPanel.add(new ImmunizationAdd(), "ImmunizationPanel");
        mainContentPanel.add(new StudentAssignment(), "AssignStudentsPanel");
        mainContentPanel.add(new TeacherViewOrUpdate(), "TeacherViewUpdatePanel");
        mainContentPanel.add(new AnnualReview(), "AnnualReviewPanel");
        mainContentPanel.add(new ClassesViewOrUpdate(), "ClassViewUpdatePanel");
    }

    private void signOut() {
        JOptionPane.showMessageDialog(this, "Signed out");
        Auth.logOut();
        new SignIn().setVisible(true);
        this.dispose();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Definitions for the panel inner classes
    

    // Additional panel classes are defined similarly...
}
