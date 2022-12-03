package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FailSignup extends JFrame {
    private Container container;
    private JLabel usernameLabel;
    
    public FailSignup() {
        usernameLabel = new JLabel("Email has been used");
        usernameLabel.setBounds(50,50,200,30);
        container = getContentPane();
        container.setLayout(null);
        container.add(usernameLabel);
    }

    public static void main(String[] args) {
        FailSignup frame = new FailSignup();
        frame.setTitle("fail");
        frame.setVisible(true);
        frame.setBounds(10,10, 400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
