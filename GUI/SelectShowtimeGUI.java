import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectShowtimeGUI extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel selectLabel;
    private JComboBox<String> choices;
    private JButton selectButton;
    private Container container;

    private String movieName = "Movie";
    private String availableTimes[] = {"Time 1", "Time 2", "Time 3", "Time 4"};

    public SelectShowtimeGUI() {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
