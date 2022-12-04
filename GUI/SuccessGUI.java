//package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SuccessGUI extends JFrame {
    private Container container;
    private JLabel usernameLabel;
    
    public SuccessGUI() {
        usernameLabel = new JLabel("Success");
        usernameLabel.setBounds(50,50,100,30);
        container = getContentPane();
        container.setLayout(null);
        container.add(usernameLabel);
    }

    public static void main(String[] args) {
        SuccessGUI frame = new SuccessGUI();
        frame.setTitle("Success");
        frame.setVisible(true);
        frame.setBounds(10,10, 400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
