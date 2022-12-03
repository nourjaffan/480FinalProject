import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountGUI extends JFrame implements ActionListener{
    
    private JLabel welcomeLabel;
    private JLabel newsLabel;
    private JLabel announcement1Label;
    private JLabel announcement2Label;
    private JLabel announcement3Label;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private Container container;

    private String name = "User";   //hardcoded fields; must be replaced with gets
    private String movie1 = "Movie 1";
    private String date1 = "Date 1";
    private String movie2 = "Movie 2";
    private String date2 = "Date 2";
    private String movie3 = "Movie 3";
    private String date3 = "Date 3";

    public AccountGUI() {
        //initiallize labels
        welcomeLabel = new JLabel("Welcome " + name);
        newsLabel = new JLabel("NEWS");
        announcement1Label = new JLabel(movie1 + " in theatres on " + date1);
        announcement2Label = new JLabel(movie2 + " in theatres on " + date2);
        announcement3Label = new JLabel(movie3 + " in theatres on " + date3);
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
        announcement1Label.setBounds(0, 30, 300, 30);
        announcement1Label.setHorizontalAlignment(SwingConstants.CENTER);
        announcement2Label.setBounds(0, 60, 300, 30);
        announcement2Label.setHorizontalAlignment(SwingConstants.CENTER);
        announcement3Label.setBounds(0, 90, 300, 30);
        announcement3Label.setHorizontalAlignment(SwingConstants.CENTER);
        searchLabel.setBounds(125, 210, 150, 30);
        searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setBounds(125, 240, 150, 30);
        searchButton.setBounds(125, 280, 150, 30);

        //create news panel
        JPanel newsPanel = new JPanel();
        newsPanel.setLayout(null);
        newsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        newsPanel.add(newsLabel);
        newsPanel.add(announcement1Label);
        newsPanel.add(announcement2Label);
        newsPanel.add(announcement3Label);
        newsPanel.setBounds(50, 60, 300, 130);

        //add everything
        container = getContentPane();
        container.setLayout(null);
        container.add(welcomeLabel);
        container.add(newsPanel);
        container.add(searchLabel);
        container.add(searchField);
        container.add(searchButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //if movie exists in database:
        SelectShowtimeGUI showtimeGUI = new SelectShowtimeGUI();
        showtimeGUI.setBounds(10, 10, 400, 400);
        showtimeGUI.setVisible(true);
    }
}
