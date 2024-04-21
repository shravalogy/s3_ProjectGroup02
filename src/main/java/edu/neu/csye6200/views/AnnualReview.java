package edu.neu.csye6200.views;

import edu.neu.csye6200.DB;
import edu.neu.csye6200.model.Rating;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

// ... any other Swing components you use


/**
 * AnnualReview panel with modernized UI.
 */
public class AnnualReview extends JPanel {

    private JLabel title;
    private JButton saveButton;
    private JLabel employeeIdLabel;
    private JTextField employeeIdField;
    private JLabel ratingLabel;
    private JTextField ratingField;
    private JLabel yearLabel;
    private JTextField yearField;
    private JPanel formPanel;

    public AnnualReview() {
        initComponents();
        customizeComponents();
    }

    private void initComponents() {
        formPanel = new JPanel();
        employeeIdLabel = new JLabel();
        employeeIdField = new JTextField();
        ratingLabel = new JLabel();
        ratingField = new JTextField();
        saveButton = new JButton();
        yearLabel = new JLabel();
        yearField = new JTextField();
        title = new JLabel();

        setBackground(new Color(245, 245, 245));

        employeeIdLabel.setText("Employee ID:");
        ratingLabel.setText("Rating (out of 5):");
        yearLabel.setText("Year (as YYYY):");

        saveButton.setText("Submit");
        saveButton.addActionListener(this::saveButtonActionPerformed);

        yearField.addActionListener(this::yearFieldActionPerformed);

        layoutFormPanel();

        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setText("Annual Employee Review");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(title)
                    .addComponent(formPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(formPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }

    private void layoutFormPanel() {
        GroupLayout formPanelLayout = new GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(employeeIdLabel)
                    .addComponent(ratingLabel)
                    .addComponent(yearLabel))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeIdField)
                    .addComponent(ratingField)
                    .addComponent(yearField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(employeeIdLabel)
                    .addComponent(employeeIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ratingLabel)
                    .addComponent(ratingField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(yearLabel)
                    .addComponent(yearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(saveButton))
        );
    }

    private void saveButtonActionPerformed(ActionEvent evt) {
        // Save info into DB
        try {
            String empID = employeeIdField.getText();
            String empRating = ratingField.getText();
            String reviewYear = yearField.getText();
            if (empID.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Employee ID Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            } else if (empRating.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Rating Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            } else if (reviewYear.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Year Cannot be empty", "Field Empty", JOptionPane.ERROR_MESSAGE);
            } else {
                Rating rating = new Rating(Integer.parseInt(empID), Integer.parseInt(reviewYear), Integer.parseInt(empRating));

                DB db = DB.getObj(); // Assuming 'getInstance' is the method to get a DB object

                PreparedStatement statement = db.conn.prepareStatement("INSERT INTO employee_ratings (employee_id, rating, year) VALUES (?, ?, ?);");
                statement.setInt(1, rating.getEmpID());
                statement.setInt(2, rating.getRating());
                statement.setInt(3, rating.getYear());
                statement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Record Added Successfully");
                employeeIdField.setText("");
                ratingField.setText("");
                yearField.setText("");
            }
        } catch (SQLException ex) {
            //Logger.getLogger(AnnualReviewPanel.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void yearFieldActionPerformed(ActionEvent evt) {
        // Action for yearField if needed
    }

    private void customizeComponents() {
        // Customizing the UI components...
        formPanel.setBackground(new Color(225, 225, 225));
        formPanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        employeeIdLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        ratingLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        employeeIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        ratingField.setFont(new Font("Arial", Font.PLAIN, 16));
        yearField.setFont(new Font("Arial", Font.PLAIN, 16));

        saveButton.setBackground(new Color(76, 153, 0));
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(new Font("Arial", Font.BOLD, 16));
        saveButton.setBorderPainted(false);
        saveButton.setFocusPainted(false);
        saveButton.setOpaque(true);

        title.setForeground(new Color(128, 0, 0));
    }
}
