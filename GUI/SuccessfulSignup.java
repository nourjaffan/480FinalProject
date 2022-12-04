package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuccessfulSignup extends JFrame implements ActionListener{
    private Container container;
    private JButton Button;
    private JLabel usernameLabel;
    
    public SuccessfulSignup() {
        usernameLabel = new JLabel("You have been registered and are paying $20 annually");
        usernameLabel.setBounds(20,50,400,30);
        Button = new JButton("continue");
        Button.addActionListener(this);
        Button.setBounds(100,200,150,30);
        container = getContentPane();
        container.setLayout(null);
        container.add(usernameLabel);
        container.add(Button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Button){
            LoginGUI login = new LoginGUI();
            login.setBounds(10, 10, 400, 400);
            login.setVisible(true);
            dispose();
        }
        
    }
    
}
