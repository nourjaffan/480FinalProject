package GUI;

import javax.swing.*;

import AccountWork.Account;
import Database.DatabaseSingleton;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class GUIAccount extends JFrame implements ActionListener{
    
    private JLabel welcomeLabel;
    private JLabel newsLabel;
    private Vector<JLabel> announcementLabel = new Vector<JLabel>();
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private JLabel failSearch;
    private Container container;

    private Account acc;
    private DatabaseSingleton database = DatabaseSingleton.getOnlyInstance();

    public GUIAccount(Account acc) {
        //initiallize labels
        welcomeLabel = new JLabel("Welcome " + acc.getName());
        newsLabel = new JLabel("NEWS");
        failSearch = new JLabel();
        boolean checkIfNews = false;
        Vector<String> newsList = database.getAllNews();
        for(String news : newsList){
            JLabel announceTmp = new JLabel(news);
            announcementLabel.add(announceTmp);
            checkIfNews = true;
            
        }

        searchLabel = new JLabel("Search for Movies");

        //initiallize field and buttons
        searchField = new JTextField(15);
        searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        //set bounds
        welcomeLabel.setBounds(125,10,150,30);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        newsLabel.setBounds(0, 0, 300, 30);
        newsLabel.setHorizontalAlignment(SwingConstants.CENTER);

        
        int yAxis = 30;
        if(checkIfNews){
            for(JLabel label : announcementLabel){
                label.setBounds(0, yAxis, 300, 30);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                yAxis += 30;
            }
        }

        searchLabel.setBounds(125, 210, 150, 30);
        searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setBounds(125, 240, 150, 30);
        searchButton.setBounds(125, 280, 150, 30);

        failSearch.setForeground(Color.red);
        failSearch.setBounds(125, 310, 150, 30);
        failSearch.setHorizontalAlignment(SwingConstants.CENTER);
        //create news panel
        JPanel newsPanel = new JPanel();
        newsPanel.setLayout(null);
        newsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newsPanel.add(newsLabel);
        if(checkIfNews){
            for(JLabel label : announcementLabel){
                newsPanel.add(label);
            }
        }
        
        newsPanel.setBounds(50, 60, 300, 130);

        //add everything
        container = getContentPane();
        container.setLayout(null);
        container.add(welcomeLabel);
        container.add(newsPanel);
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
            SelectShowtimeGUI showtimeGUI = new SelectShowtimeGUI(searchField.getText(), acc);
            showtimeGUI.setBounds(10, 10, 400, 400);
            showtimeGUI.setVisible(true);
            dispose();
        }else{
            failSearch.setText("No movie was found");
            
        }
    }
}
