package GUI;

import javax.swing.*;

import AccountWork.Account;
import Database.DatabaseSingleton;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class RegularSearchGUI extends JFrame implements ActionListener {
    private JLabel welcomeLabel;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JLabel failSearch;
    private Container container;
    private Account acc;
    private DatabaseSingleton database = DatabaseSingleton.getOnlyInstance();
    public RegularSearchGUI(Account acc) {
        welcomeLabel = new JLabel("Welcome");
        searchLabel = new JLabel("Search for Movies");
        searchField = new JTextField(15);
        failSearch = new JLabel();
        searchButton = new JButton("Search");

        welcomeLabel.setBounds(125,10,150,30);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchLabel.setBounds(125, 60, 150, 30);
        searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setBounds(125, 90, 150, 30);
        searchButton.setBounds(125, 130, 150, 30);

        failSearch.setForeground(Color.red);
        failSearch.setBounds(125, 155, 150, 30);
        failSearch.setHorizontalAlignment(SwingConstants.CENTER);
        searchButton.addActionListener(this);

        container = getContentPane();
        container.setLayout(null);
        container.add(welcomeLabel);
        container.add(searchLabel);
        container.add(searchField);
        container.add(searchButton);
        container.add(failSearch);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.acc = acc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if movie exists in database:
        
        if(database.getSpecificMovie(searchField.getText())){
            LocalDate today = LocalDate.now();
            String[] tmp = database.getSpecificStringMovie(searchField.getText()).split("/");
            LocalDate theRelease = LocalDate.of(Integer.parseInt(tmp[6]), Integer.parseInt(tmp[5]), Integer.parseInt(tmp[4]));
            System.out.println(theRelease.getDayOfYear());
            if( theRelease.getDayOfYear() - today.getDayOfYear() <= 3){
                SelectShowtimeGUI showtimeGUI = new SelectShowtimeGUI(searchField.getText(), acc);
                showtimeGUI.setBounds(10, 10, 400, 400);
                showtimeGUI.setVisible(true);
                showtimeGUI.setResizable(false);
                dispose();
            }else{
                failSearch.setText("No movie was found");
                
            }

            
        }else{
            failSearch.setText("No movie was found");
            
        }
    }
}
