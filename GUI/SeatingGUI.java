package GUI;

import javax.swing.*;

import AccountWork.Account;

import java.awt.*;
import java.awt.event.*;

public class SeatingGUI extends JFrame implements ActionListener {
    
    private JLabel titleLabel;
    private JButton confirmButton;
    private Container container;
    private JButton[] buttons = new JButton[40];
    private String selected;
    private Account acc;
    public SeatingGUI(String title, String showtime, Account acc) {
        titleLabel = new JLabel("Select Seat");
        titleLabel.setBounds(0,10,650,30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        container = getContentPane();
        container.setLayout(null);
        container.add(titleLabel);

        int x = 30;
        int y = 30;
        for(int i = 0; i < 40; i++) {
            JButton seatButton = new JButton("S " + (i + 1));
            buttons[i] = seatButton;
            seatButton.addActionListener(this);
            if(i % 8 == 0) {
                x = 30;
                y += 40;
            }

            if((i - 2) % 4 == 0) {
                x += 30;
            }

            seatButton.setBounds(x, y, 60, 30);
            container.add(seatButton);
            x += 70;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton b : buttons) {
            if(b == e.getSource()) {
                b.setBackground(Color.BLUE);
                JLabel info = new JLabel(b.getText());
                info.setBounds(0, 300, 150, 30);
                container.add(info);
                selected = b.getText();
                System.out.println(selected);
                break;
            }
        }
    }
/*
    public static void main(String[] args) {
        SeatingGUI frame = new SeatingGUI();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setBounds(10,10, 680,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    */
}
