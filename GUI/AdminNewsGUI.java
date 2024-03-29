package GUI;

import javax.swing.*;

import Database.DatabaseSingleton;

import java.awt.*;
import java.awt.event.*;

public class AdminNewsGUI extends JFrame implements ActionListener {
    private JLabel newsLabel;
    private JLabel titleLabel;
    private JLabel dayLabel;
    private JLabel monthLabel;
    private JLabel yearLabel;

    private JTextField titleField;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;

    private JButton confirmButton;
    private Container container;
    private DatabaseSingleton database = DatabaseSingleton.getOnlyInstance();

    public AdminNewsGUI() {
        newsLabel = new JLabel("Add News");
        titleLabel = new JLabel("Title");
        dayLabel = new JLabel("Day");
        monthLabel = new JLabel("Month");
        yearLabel = new JLabel("Year");

        titleField = new JTextField(15);
        dayField = new JTextField(15);
        monthField = new JTextField(15);
        yearField = new JTextField(15);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);

        newsLabel.setBounds(125, 10, 150, 30);
        newsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(50, 60, 100, 30);
        dayLabel.setBounds(50, 110, 100, 30);
        monthLabel.setBounds(50, 160, 100, 30);
        yearLabel.setBounds(50, 210, 100, 30);
        titleField.setBounds(150, 60, 100, 30);
        dayField.setBounds(150, 110, 100, 30);
        monthField.setBounds(150, 160, 100, 30);
        yearField.setBounds(150, 210, 100, 30);
        confirmButton.setBounds(125, 260, 150, 50);

        container = getContentPane();
        container.setLayout(null);
        container.add(newsLabel);
        container.add(titleLabel);
        container.add(titleField);
        container.add(dayLabel);
        container.add(dayField);
        container.add(monthLabel);
        container.add(monthField);
        container.add(yearLabel);
        container.add(yearField);
        container.add(confirmButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (titleField.getText().isEmpty() || dayField.getText().isEmpty() || monthField.getText().isEmpty()
                || yearField.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Please enter all info");

        } else {
            database.addNewNews(titleField.getText(), Integer.parseInt(dayField.getText()),
                    Integer.parseInt(monthField.getText()), Integer.parseInt(yearField.getText()));
                    
            JOptionPane.showMessageDialog(null, "The news has been added");
            // TODO Auto-generated method stub

        }
    }
}
