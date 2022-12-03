package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fail extends JFrame {
    private Container container;
    private JLabel usernameLabel;
    
    public Fail() {
        usernameLabel = new JLabel("Invalid Login");
        usernameLabel.setBounds(50,50,100,30);
        container = getContentPane();
        container.setLayout(null);
        container.add(usernameLabel);
    }

    public static void main(String[] args) {
        Fail frame = new Fail();
        frame.setTitle("fail");
        frame.setVisible(true);
        frame.setBounds(10,10, 400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}