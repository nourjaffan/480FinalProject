package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import AccountWork.Account;
public class LoginGUI extends JFrame implements ActionListener {
    private JPasswordField passwordField;
    private JTextField usernameField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JButton guestButton;
    private JButton signupButton;
    private JButton cancelButton;
    private Container container;
    private Account acc;

    public LoginGUI() {
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");
        loginButton = new JButton("Login");
        guestButton = new JButton("Proceed As Guest");
        signupButton = new JButton("Signup");
        cancelButton = new JButton("Cancel Ticket");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);

        usernameLabel.setBounds(50,50,100,30);
        passwordLabel.setBounds(50,100,100,30);
        usernameField.setBounds(150,50,150,30);
        passwordField.setBounds(150,100,150,30);
        loginButton.setBounds(150,150,100,30);
        guestButton.setBounds(100,250,200,30);
        signupButton.setBounds(150,200,100,30);
        cancelButton.setBounds(100,300,200,30);

        loginButton.addActionListener(this);
        guestButton.addActionListener(this);
        signupButton.addActionListener(this);
        cancelButton.addActionListener(this);

        container = getContentPane();
        container.setLayout(null);
        container.add(usernameLabel);
        container.add(usernameField);
        container.add(passwordLabel);
        container.add(passwordField);
        container.add(loginButton);
        container.add(guestButton);
        container.add(signupButton);
        container.add(cancelButton);

        acc = new Account();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            boolean loginCheck = true;
            try{
                acc.login(username, password);
            }catch(Exception k){
                loginCheck = false;
            }
            
            if(loginCheck) {
                GUIAccount GUIAccount = new GUIAccount(acc);
                GUIAccount.setBounds(10,10, 400,400);
                GUIAccount.setVisible(true);
            } else {
                Fail fail = new Fail();
                fail.setBounds(10,10, 400,400);
                fail.setVisible(true);
            }
        }

        else if(e.getSource() == signupButton) {
            SignupGUI signupGUI = new SignupGUI();
            signupGUI.setBounds(10, 10, 400, 660);
            signupGUI.setVisible(true);
        }

        else if(e.getSource() == guestButton) {
            RegularSearchGUI regularSearchGUI = new RegularSearchGUI(acc);
            regularSearchGUI.setBounds(10, 10, 400, 400);
            regularSearchGUI.setVisible(true);
        }
        
        else if(e.getSource() == cancelButton) {
            CancelTicketGUI cancelTicketGUI = new CancelTicketGUI();
            cancelTicketGUI.setBounds(10, 10, 400, 400);
            cancelTicketGUI.setVisible(true);
        }
    }

    public static void main(String[] args) {
        LoginGUI frame = new LoginGUI();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setBounds(10,10, 400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        // JFrame frame = new JFrame("Login");
        // frame.getContentPane().add(gui);
        // frame.setSize(400,400);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(true);
    }
}
