package GUI;

import javax.swing.*;

import SendEmails.SendEmail;
import AccountWork.Account;
import Database.DatabaseSingleton;
import Payment.PaymentImplement;
import Payment.PaymentTicket;

import java.awt.*;
import java.awt.event.*;

public class TicketPaymentGUI extends JFrame implements ActionListener {
    
    private JLabel titleLabel;
    private JLabel info;

    private String movie;
    private String showtime;
    private int seat;
    private JButton confirmButton;
    private Container container;
    private Account acc;

    private int day;
    private int month;
    private int year;
    private static DatabaseSingleton access = DatabaseSingleton.getOnlyInstance();

    //should be given a size of 400, 250
    public TicketPaymentGUI(Account acc, int seatNum, String title, String showTime, int day, int month , int year) {
        this.acc = acc;
        this.movie = title;
        this.showtime = showTime;
        this.seat = seatNum;
        this.day = day;
        this.month = month;
        this.year = year;
        titleLabel = new JLabel("Confirm Ticket Purchase");
        info = new JLabel("Watching " + title + " in seat number " + seatNum + " at " + showtime);
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);

        titleLabel.setBounds(125,10,150,30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        info.setBounds(0,60,400,30);
        info.setHorizontalAlignment(SwingConstants.CENTER);

        confirmButton.setBounds(125,120,150,50);

        container = getContentPane();
        container.setLayout(null);
        container.add(titleLabel);
        container.add(info);
        container.add(confirmButton);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int tickNum = access.addNewTicket(this.seat, this.showtime, this.movie, 15.0, this.day, this.month, this.year, this.acc.getEmail());
        PaymentImplement pay = new PaymentImplement(){};
        pay.setPaymentStrategy(new PaymentTicket());
        int cost = pay.performPayment();
        access.setSpecificSeat(movie, seat, showtime, day, month, year, 0);
        new SendEmail(this.acc.getEmail(), "Ticket Reciept", "Ticket cost = $"+ cost +" \n\n please enjoy "+ this.movie +" at "+this.showtime+ " on the " + this.day + " day of the month in seat " + this.seat 
                                            + "\n" + "Your unique ticket number is " + tickNum);
        JOptionPane.showMessageDialog(null, "The order has been completed and the ticket has been sent to your email");
        dispose();
    }
 
}
