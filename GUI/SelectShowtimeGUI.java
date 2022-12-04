package GUI;

import javax.swing.*;
import javax.xml.crypto.Data;

import AccountWork.Account;
import Database.DatabaseSingleton;

import java.awt.*;
import java.awt.event.*;

public class SelectShowtimeGUI extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel selectLabel;
    private JComboBox<String> choices;
    private JButton selectButton;
    private Container container;

    private String movieName;
    private DatabaseSingleton database = DatabaseSingleton.getOnlyInstance();
    private Account acc;

    public SelectShowtimeGUI(String name, Account acc) {
        movieName = name;
        String availableTimes[] = database.getAllShowTimes(movieName).split("\n");
        titleLabel = new JLabel("Select Showtime");
        selectLabel = new JLabel("Showtimes for " + movieName);

        choices = new JComboBox<String>();
        for(String s : availableTimes) {
            choices.addItem(s);
        }

        selectButton = new JButton("Confirm");

        titleLabel.setBounds(125,10,150,30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        selectLabel.setBounds(125, 60, 150, 30);
        selectLabel.setHorizontalAlignment(SwingConstants.CENTER);
        choices.setBounds(125, 90, 150, 30);
        selectButton.setBounds(125, 130, 150, 30);
        
        selectButton.addActionListener(this);

        container = getContentPane();
        container.setLayout(null);
        container.add(titleLabel);
        container.add(selectLabel);
        container.add(choices);
        container.add(selectButton);

        this.acc = acc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] tmp = choices.getSelectedItem().toString().split("/");

        SeatingGUI frame = new SeatingGUI(tmp[3], tmp[4], acc);
        frame.setTitle("Seating");
        frame.setVisible(true);
        frame.setBounds(10,10, 680,400);
        frame.setResizable(false);
        // TODO Auto-generated method stub
        
    }
}
