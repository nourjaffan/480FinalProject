package GUI;

import javax.swing.*;

import AccountWork.Account;
import Database.DatabaseSingleton;

import java.awt.*;
import java.awt.event.*;

public class SeatingGUI extends JFrame implements ActionListener {
    
    private JLabel titleLabel;
    private JButton confirmButton;
    private Container container;
    private final int AMOUNTOFSEATS = 40;
    private JButton[] buttons = new JButton[AMOUNTOFSEATS];
    private int selected = -1;
    private Color defaultColor;
    private String title;
    private String showTime;
    private Account acc;
    private DatabaseSingleton database = DatabaseSingleton.getOnlyInstance();

    public SeatingGUI(String title, String showTime, Account acc, int day, int month, int year) {
        titleLabel = new JLabel("Select Seat");
        titleLabel.setBounds(0,10,650,30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(250, 300, 150, 30);
        confirmButton.addActionListener(this);

        defaultColor = confirmButton.getBackground();

        container = getContentPane();
        container.setLayout(null);
        container.add(titleLabel);
        container.add(confirmButton);

        int x = 30;
        int y = 30;
        for(int i = 0; i < AMOUNTOFSEATS; i++) {
            
            //NEED CHECK FOR SELECTED SEAT AVAILABLE

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
            if(!database.getSpecificSeat(title, (i+1), showTime, day, month, year)){
                seatButton.setBackground(Color.GREEN);
                seatButton.setEnabled(false);
            }
            x += 70;
        }
        this.title = title;
        this.showTime = showTime;
        this.acc = acc;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmButton) {
            if(selected == -1) {
                //do nothing
            } else {    //NEED CHECK FOR REGISTERED USER AND WHETHER SELECTED SEAT IS AVAILABLE
                if(acc.getReg()){
                    TicketPaymentGUI frame = new TicketPaymentGUI(acc, selected, title, showTime);
                    frame.setTitle("Payment");
                    frame.setVisible(true);
                    frame.setBounds(10,10, 400,500);
                    frame.setResizable(false);
                    dispose();
                }else{
                    RegularTicketPaymentGUI frame = new RegularTicketPaymentGUI(selected, title, showTime);
                    frame.setTitle("Payment");
                    frame.setVisible(true);
                    frame.setBounds(10,10, 400,500);
                    frame.setResizable(false);
                    dispose();
                }
            }
        }
        else {
            
            
            for(JButton b : buttons) {
                
                if(b.getBackground() == Color.GREEN) {
                    b.setBackground(defaultColor);
                }
                if(b == e.getSource()) {
                    b.setBackground(Color.GREEN);
                    selected = Integer.parseInt(b.getText().substring(2));
                }
            }
        }
    }

}
