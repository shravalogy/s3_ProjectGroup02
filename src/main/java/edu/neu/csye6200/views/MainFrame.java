//package edu.neu.csye6200.views;
//import edu.neu.csye6200.controllers.SignInController;
//import edu.neu.csye6200.model.Auth;
//import edu.neu.csye6200.views.TeacherRegistrationPannel;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class MainFrame extends JFrame {
//
//    private JButton teacherRegistrationButton;
//    private JButton studentRegistrationButton;
//    private JButton studentViewUpdateButton;
//    private JButton immunizationButton;
//    private JButton assignStudentsButton;
//    private JButton teacherViewUpdateButton;
//    private JButton annualReviewButton;
//    private JButton classViewUpdateButton;
//    private JButton signOutButton;
//    private JPanel mainContentPanel;
//    private JSplitPane jSplitPane1;
//
//    public MainFrame() {
//        initComponents();
//        setupButtonActions();
//        setTitle("Daycare Management System");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(800, 600); // Set the initial size of the frame
//        setLocationRelativeTo(null); // Center the frame
//        setVisible(true);
//    }
//
//    private void initComponents() {
//        // Initialize the split pane and main content panel
//        jSplitPane1 = new JSplitPane();
//        jSplitPane1.setDividerLocation(150);
//        mainContentPanel = new JPanel();
//
//        // Initialize buttons
//        teacherRegistrationButton = new JButton("Teacher Registration");
//        studentRegistrationButton = new JButton("Student Registration");
//        studentViewUpdateButton = new JButton("Student View/Update");
//        immunizationButton = new JButton("Immunization");
//        assignStudentsButton = new JButton("Assign Students");
//        teacherViewUpdateButton = new JButton("Teacher View/Update");
//        annualReviewButton = new JButton("Annual Review");
//        classViewUpdateButton = new JButton("Class View/Update");
//        signOutButton = new JButton("Log Out");
//
//        // Initialize left panel with buttons
//        JPanel leftPanel = new JPanel();
//        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
//        leftPanel.add(teacherRegistrationButton);
//        leftPanel.add(studentRegistrationButton);
//        leftPanel.add(studentViewUpdateButton);
//        leftPanel.add(immunizationButton);
//        leftPanel.add(assignStudentsButton);
//        leftPanel.add(teacherViewUpdateButton);
//        leftPanel.add(annualReviewButton);
//        leftPanel.add(classViewUpdateButton);
//        leftPanel.add(signOutButton);
//
//        // Add components to split pane
//        jSplitPane1.setLeftComponent(new JScrollPane(leftPanel));
//        jSplitPane1.setRightComponent(mainContentPanel);
//
//        // Add the split pane to the frame
//        setContentPane(jSplitPane1);
//    }
//
//    private void setupButtonActions() {
//        teacherRegistrationButton.addActionListener(evt -> switchToPanel(new TeacherRegistrationPanel()));
//        studentRegistrationButton.addActionListener(evt -> switchToPanel(new StudentRegistrationPanel()));
//        studentViewUpdateButton.addActionListener(evt -> switchToPanel(new StudentViewUpdatePanel()));
//        immunizationButton.addActionListener(evt -> switchToPanel(new ImmunizationPanel()));
//        assignStudentsButton.addActionListener(evt -> switchToPanel(new AssignStudentsPanel()));
//        teacherViewUpdateButton.addActionListener(evt -> switchToPanel(new TeacherViewUpdatePanel()));
//        annualReviewButton.addActionListener(evt -> switchToPanel(new AnnualReviewPanel()));
//        classViewUpdateButton.addActionListener(evt -> switchToPanel(new ClassViewUpdatePanel()));
//        signOutButton.addActionListener(evt -> signOut());
//    }
//
//    // Helper method to switch the main content panel
//    private void switchToPanel(JPanel panel) {
//        mainContentPanel.removeAll();
//        mainContentPanel.setLayout(new BorderLayout());
//        mainContentPanel.add(panel);
//        mainContentPanel.revalidate();
//        mainContentPanel.repaint();
//    }
//
//    // Placeholder methods for actions
//    private void signOut() {
//        // Perform sign out logic here
//        JOptionPane.showMessageDialog(this, "Signed out");
//        Auth.logOut();
//        new SignIn().setVisible(true);
//        this.setVisible(false);
//    }
//
//    public static void main(String[] args) {
//        EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
//    }
//
//    // Placeholder inner classes for panel components
//    // Replace with your actual panel class implementations
//    class TeacherRegistrationPanel extends JPanel {
//        public TeacherRegistrationPanel() {
//        	TeacherRegistrationPannel comp = new TeacherRegistrationPannel();
//        	jSplitPane1.setRightComponent(comp);
//            add(new JLabel("Teacher Registration Panel"));
//        }
//    }
//
//    class StudentRegistrationPanel extends JPanel {
//        public StudentRegistrationPanel() {
//            add(new JLabel("Student Registration Panel"));
//            StudentRegistration comp = new StudentRegistration();
//            jSplitPane1.setRightComponent(comp);
//        }
//    }
//
//    class StudentViewUpdatePanel extends JPanel {
//        public StudentViewUpdatePanel() {
//            try {
//                StudentViewOrUpdate comp = new StudentViewOrUpdate();
//                jSplitPane1.setRightComponent(comp);
//                add(new JLabel("Student View/Update Panel"));
//            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "Error while viewing or updating students.", "Database Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//
//    class ImmunizationPanel extends JPanel {
//        public ImmunizationPanel() {
//        	try {
//                ImmunizationAdd comp = new ImmunizationAdd();
//                jSplitPane1.setRightComponent(comp);
//                add(new JLabel("Immunization Panel"));
//            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                // Handle exception, possibly with a user-friendly message
//                JOptionPane.showMessageDialog(this, "Error accessing the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    class AssignStudentsPanel extends JPanel {
//        public AssignStudentsPanel() {
//            try {
//                StudentAssignment comp = new StudentAssignment();
//                jSplitPane1.setRightComponent(comp);
//                add(new JLabel("Assign Students Panel"));
//            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "Error while assigning students.", "Database Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    class TeacherViewUpdatePanel extends JPanel {
//        public TeacherViewUpdatePanel() {
//            try {
//                TeacherViewOrUpdate comp = new TeacherViewOrUpdate();
//                jSplitPane1.setRightComponent(comp);
//                add(new JLabel("Teacher View/Update Panel"));
//            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(this, "Error while updating teacher view.", "Database Error", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//
//    class AnnualReviewPanel extends JPanel {
//        public AnnualReviewPanel() {
//            add(new JLabel("Annual Review Panel"));
//            AnnualReview comp = new AnnualReview();
//            jSplitPane1.setRightComponent(comp);
//        }
//    }
//
//    class ClassViewUpdatePanel extends JPanel {
//        public ClassViewUpdatePanel() {
//            // Initialization code here
//            add(new JLabel("Class View/Update Panel"));
//            ClassesViewOrUpdate comp = new ClassesViewOrUpdate();
//            jSplitPane1.setRightComponent(comp);
//        }
//    }
//}





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.neu.csye6200.views;
import edu.neu.csye6200.model.Auth;
import edu.neu.csye6200.views.TeacherRegistrationPannel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author premkumarmanoharan
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        checkVisibility();
    }
    
    /**
     * This function accesses the authentication service and 
     * decides which views to keep visible
     */
    private void checkVisibility(){
        String userType = Auth.getUserType();
        
        if(!userType.contentEquals("admin")){
                teacherRegistrationButton.setVisible(false);
                annualReviewButton.setVisible(false);
                teacherViewUpdateButton.setVisible(false);
                immunizationButton.setVisible(false);
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

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        teacherRegistrationButton = new javax.swing.JButton();
        studentRegistrationButton = new javax.swing.JButton();
        studentViewUpdateButton = new javax.swing.JButton();
        immunizationButton = new javax.swing.JButton();
        assignStudentsButton = new javax.swing.JButton();
        teacherViewUpdateButton = new javax.swing.JButton();
        annualReviewButton = new javax.swing.JButton();
        classViewUpdateButton = new javax.swing.JButton();
        signOutButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        teacherRegistrationButton.setText("Teacher Registration");
        teacherRegistrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherRegistrationButtonActionPerformed(evt);
            }
        });

        studentRegistrationButton.setText("Student Registration");
        studentRegistrationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentRegistrationButtonActionPerformed(evt);
            }
        });

        studentViewUpdateButton.setText("Student View/Update");
        studentViewUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentViewUpdateButtonActionPerformed(evt);
            }
        });

        immunizationButton.setText("Immunization");
        immunizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                immunizationButtonActionPerformed(evt);
            }
        });

        assignStudentsButton.setText("Assign Students");
        assignStudentsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignStudentsButtonActionPerformed(evt);
            }
        });

        teacherViewUpdateButton.setText("Teacher View/Update");
        teacherViewUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherViewUpdateButtonActionPerformed(evt);
            }
        });

        annualReviewButton.setText("Annual Review");
        annualReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annualReviewButtonActionPerformed(evt);
            }
        });

        classViewUpdateButton.setText("Class View/Update");
        classViewUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classViewUpdateButtonActionPerformed(evt);
            }
        });

        signOutButton.setText("Log Out");
        signOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(signOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentRegistrationButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentViewUpdateButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classViewUpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(annualReviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(teacherViewUpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherRegistrationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(assignStudentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(immunizationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(teacherRegistrationButton)
                .addGap(18, 18, 18)
                .addComponent(studentRegistrationButton)
                .addGap(18, 18, 18)
                .addComponent(studentViewUpdateButton)
                .addGap(18, 18, 18)
                .addComponent(immunizationButton)
                .addGap(18, 18, 18)
                .addComponent(assignStudentsButton)
                .addGap(27, 27, 27)
                .addComponent(teacherViewUpdateButton)
                .addGap(27, 27, 27)
                .addComponent(annualReviewButton)
                .addGap(18, 18, 18)
                .addComponent(classViewUpdateButton)
                .addGap(18, 18, 18)
                .addComponent(signOutButton)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 895, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void teacherRegistrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherRegistrationButtonActionPerformed
           // TODO add your handling code here:
           TeacherRegistrationPannel comp = new TeacherRegistrationPannel();
           jSplitPane1.setRightComponent(comp);
    }//GEN-LAST:event_teacherRegistrationButtonActionPerformed

    private void studentRegistrationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentRegistrationButtonActionPerformed
        // TODO add your handling code here:
        StudentRegistration comp = new StudentRegistration();
        jSplitPane1.setRightComponent(comp);
    }//GEN-LAST:event_studentRegistrationButtonActionPerformed

    private void annualReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annualReviewButtonActionPerformed
        // TODO add your handling code here:
        AnnualReview comp = new AnnualReview();
        jSplitPane1.setRightComponent(comp);
    }//GEN-LAST:event_annualReviewButtonActionPerformed

    private void studentViewUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentViewUpdateButtonActionPerformed
        try {
            // TODO add your handling code here:
            StudentViewOrUpdate comp  = new StudentViewOrUpdate();
            jSplitPane1.setRightComponent(comp);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_studentViewUpdateButtonActionPerformed

    private void assignStudentsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignStudentsButtonActionPerformed
        try {
            // TODO add your handling code here:
            StudentAssignment comp = new StudentAssignment();
            jSplitPane1.setRightComponent(comp);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_assignStudentsButtonActionPerformed

    private void classViewUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classViewUpdateButtonActionPerformed
        // TODO add your handling code here:
        ClassesViewOrUpdate comp = new ClassesViewOrUpdate();
         jSplitPane1.setRightComponent(comp);
        
    }//GEN-LAST:event_classViewUpdateButtonActionPerformed

    private void teacherViewUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherViewUpdateButtonActionPerformed
        try {
            // TODO add your handling code here:
            TeacherViewOrUpdate comp = new TeacherViewOrUpdate();
            jSplitPane1.setRightComponent(comp);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_teacherViewUpdateButtonActionPerformed

    private void immunizationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_immunizationButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ImmunizationAdd comp = new ImmunizationAdd();
            jSplitPane1.setRightComponent(comp);
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_immunizationButtonActionPerformed

    private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutButtonActionPerformed
        // TODO add your handling code here:
        Auth.logOut();
        new SignIn().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_signOutButtonActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annualReviewButton;
    private javax.swing.JButton assignStudentsButton;
    private javax.swing.JButton classViewUpdateButton;
    private javax.swing.JButton immunizationButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton signOutButton;
    private javax.swing.JButton studentRegistrationButton;
    private javax.swing.JButton studentViewUpdateButton;
    private javax.swing.JButton teacherRegistrationButton;
    private javax.swing.JButton teacherViewUpdateButton;
    // End of variables declaration//GEN-END:variables
}

