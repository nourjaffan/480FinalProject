package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuccessfulSignup extends JFrame{
    private Container container;
    private JLabel usernameLabel;
    
    public SuccessfulSignup() {
        usernameLabel = new JLabel("You have been registered and are paying $20 annually");
        usernameLabel.setBounds(20,50,400,30);
        container = getContentPane();
        container.setLayout(null);
        container.add(usernameLabel);
    }
    
}
