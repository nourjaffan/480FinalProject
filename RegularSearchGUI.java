import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegularSearchGUI extends JFrame implements ActionListener {
    private JLabel welcomeLabel;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton searchButton;
    private Container container;

    public RegularSearchGUI() {
        welcomeLabel = new JLabel("Welcome");
        searchLabel = new JLabel("Search for Movies");
        searchField = new JTextField(15);
        searchButton = new JButton("Search");

        welcomeLabel.setBounds(125,10,150,30);
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchLabel.setBounds(125, 60, 150, 30);
        searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setBounds(125, 90, 150, 30);
        searchButton.setBounds(125, 130, 150, 30);

        searchButton.addActionListener(this);

        container = getContentPane();
        container.setLayout(null);
        container.add(welcomeLabel);
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
