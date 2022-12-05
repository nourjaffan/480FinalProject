package GUI;

import javax.swing.*;

import AccountWork.Account;
import Database.DatabaseSingleton;


import java.awt.*;
import java.awt.event.*;


public class CancelTicketGUI extends JFrame implements ActionListener {
    private JLabel cancelLabel;
    private JLabel ticketNumLabel;
    private JTextField ticketNumField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JButton cancelButton;
    private Container container;

    private Account acc;
    private DatabaseSingleton database = DatabaseSingleton.getOnlyInstance();
    public CancelTicketGUI(Account acc) {
        cancelLabel = new JLabel("Cancel Ticket");
        ticketNumLabel = new JLabel("Enter Ticket Number");
        ticketNumField = new JTextField(15);
        emailLabel = new JLabel("Enter your email");
        emailField = new JTextField(15);
        cancelButton = new JButton("Confirm");

        cancelLabel.setBounds(125,10,150,30);
        cancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ticketNumLabel.setBounds(125, 60, 150, 30);
        ticketNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ticketNumField.setBounds(125, 90, 150, 30);
        emailLabel.setBounds(125, 120, 150, 30);
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emailField.setBounds(125, 150, 150, 30);
        cancelButton.setBounds(125, 190, 150, 30);

        container = getContentPane();
        container.setLayout(null);
        container.add(cancelLabel);
        container.add(ticketNumLabel);
        container.add(ticketNumField);
        container.add(emailLabel);
        container.add(emailField);
        container.add(cancelButton);

        cancelButton.addActionListener(this);
        this.acc = acc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        acc.cancelTheTicket(Integer.parseInt(ticketNumField.getText()), emailField.getText());
        LoginGUI login = new LoginGUI();
            login.setBounds(10, 10, 400, 400);
            login.setVisible(true);
            dispose();
        // TODO Auto-generated method stub
        
    }
}
