import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupGUI extends JFrame implements ActionListener {
    private JLabel signupLabel;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel phoneLabel;
    private JTextField phoneField;
    private JLabel billingLabel;
    private JLabel cardNumberLabel;
    private JTextField cardNumberField;
    private JLabel cardNameLabel;
    private JTextField cardNameField;
    private JLabel billingAddressLabel;
    private JTextField billingAddressField;
    private JLabel billingNumberLabel;
    private JTextField billingNumberField;

    private JButton signupButton;
    private Container container;

    public SignupGUI() {
        //initialize labels
        signupLabel = new JLabel("SIGN UP");
        emailLabel = new JLabel("Email");
        passwordLabel = new JLabel("Password");
        nameLabel = new JLabel("Name");
        phoneLabel = new JLabel("Phone Number");
        billingLabel = new JLabel("BILLING INFO");
        cardNumberLabel = new JLabel("Card Number");
        cardNameLabel = new JLabel("Name on Card");
        billingAddressLabel = new JLabel("Billing Address");
        billingNumberLabel = new JLabel("Billing Number");

        //initialize fields
        emailField = new JTextField(15);
        passwordField = new JPasswordField(15);
        nameField = new JTextField(15);
        phoneField = new JTextField(15);
        cardNumberField = new JTextField(15);
        cardNameField = new JTextField(15);
        billingAddressField = new JTextField(15);
        billingNumberField = new JTextField(15);

        //initiallize button
        signupButton = new JButton("Create Account");
        signupButton.addActionListener(this);

        //set bounds
        signupLabel.setBounds(150,10,150,30);
        emailLabel.setBounds(50,60,100,30);
        emailField.setBounds(150,60,150,30);
        passwordLabel.setBounds(50,110,100,30);
        passwordField.setBounds(150,110,150,30);
        nameLabel.setBounds(50,160,100,30);
        nameField.setBounds(150,160,150,30);
        phoneLabel.setBounds(50,210,100,30);
        phoneField.setBounds(150,210,150,30);

        billingLabel.setBounds(150,260,100,30);

        cardNumberLabel.setBounds(50,310,100,30);
        cardNumberField.setBounds(150,310,150,30);
        cardNameLabel.setBounds(50,360,100,30);
        cardNameField.setBounds(150,360,150,30);
        billingAddressLabel.setBounds(50,410,100,30);
        billingAddressField.setBounds(150,410,150,30);
        billingNumberLabel.setBounds(50,460,100,30);
        billingNumberField.setBounds(150,460,150,30);

        signupButton.setBounds(125,530,150,50);

        //add to container
        container = getContentPane();
        container.setLayout(null);
        container.add(signupLabel);
        container.add(emailLabel);
        container.add(emailField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(nameLabel);
        container.add(nameField);
        container.add(phoneLabel);
        container.add(phoneField);
        container.add(billingLabel);
        container.add(cardNumberLabel);
        container.add(cardNumberField);
        container.add(cardNameLabel);
        container.add(cardNameField);
        container.add(billingAddressLabel);
        container.add(billingAddressField);
        container.add(billingNumberLabel);
        container.add(billingNumberField);
        container.add(signupButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }
}
