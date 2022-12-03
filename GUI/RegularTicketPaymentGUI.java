import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegularTicketPaymentGUI extends JFrame implements ActionListener {
    
    private JLabel titleLabel;
    private JLabel info;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel billingLabel;
    private JLabel cardNumberLabel;
    private JTextField cardNumberField;
    private JLabel cardNameLabel;
    private JTextField cardNameField;
    private JLabel billingAddressLabel;
    private JTextField billingAddressField;
    private JLabel billingNumberLabel;
    private JTextField billingNumberField;
    private JButton confirmButton;
    private Container container;

    private String movie = "Movie";
    private String theatre = "Theatre";
    private String showtime = "Showtime";
    private String seat = "Seat Num";

    public RegularTicketPaymentGUI() {
        titleLabel = new JLabel("Confirm Ticket Purchase");
        info = new JLabel(movie + " in " + seat + " at " + theatre + " on " + showtime);
        emailLabel = new JLabel("Email");
        billingLabel = new JLabel("BILLING INFO");
        cardNumberLabel = new JLabel("Card Number");
        cardNameLabel = new JLabel("Name on Card");
        billingAddressLabel = new JLabel("Billing Address");
        billingNumberLabel = new JLabel("Billing Number");

        emailField = new JTextField(15);
        cardNumberField = new JTextField(15);
        cardNameField = new JTextField(15);
        billingAddressField = new JTextField(15);
        billingNumberField = new JTextField(15);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);

        titleLabel.setBounds(125,10,150,30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        info.setBounds(0,40,400,30);
        info.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.setBounds(50,90,100,30);
        emailField.setBounds(150,90,150,30);
        billingLabel.setBounds(150,130,100,30);
        cardNumberLabel.setBounds(50,170,100,30);
        cardNumberField.setBounds(150,170,150,30);
        cardNameLabel.setBounds(50,220,100,30);
        cardNameField.setBounds(150,220,150,30);
        billingAddressLabel.setBounds(50,270,100,30);
        billingAddressField.setBounds(150,270,150,30);
        billingNumberLabel.setBounds(50,320,100,30);
        billingNumberField.setBounds(150,320,150,30);
        confirmButton.setBounds(125,380,150,50);

        container = getContentPane();
        container.setLayout(null);
        container.add(titleLabel);
        container.add(info);
        container.add(emailLabel);
        container.add(emailField);
        container.add(billingLabel);
        container.add(cardNumberLabel);
        container.add(cardNumberField);
        container.add(cardNameLabel);
        container.add(cardNameField);
        container.add(billingAddressLabel);
        container.add(billingAddressField);
        container.add(billingNumberLabel);
        container.add(billingNumberField);
        container.add(confirmButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}