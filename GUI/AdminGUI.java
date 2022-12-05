import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminGUI extends JFrame implements ActionListener {
    
    private JLabel titleLabel;
    private JButton movieButton;
    private JButton newsButton;
    private JButton showtimeButton;
    private Container container;

    public AdminGUI() {
        titleLabel = new JLabel("Admin");
        movieButton = new JButton("Add Movie");
        newsButton = new JButton("Add News");
        showtimeButton = new JButton("Add Showtime");

        titleLabel.setBounds(125,10,150,30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        movieButton.setBounds(125,70,150,50);
        newsButton.setBounds(125,160,150,50);
        showtimeButton.setBounds(125,250,150,50);

        movieButton.addActionListener(this);
        newsButton.addActionListener(this);
        showtimeButton.addActionListener(this);

        container = getContentPane();
        container.setLayout(null);
        container.add(titleLabel);
        container.add(movieButton);
        container.add(newsButton);
        container.add(showtimeButton);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == movieButton) {
            AdminMovieGUI frame = new AdminMovieGUI();
            frame.setTitle("Add Movie");
            frame.setVisible(true);
            frame.setBounds(10,10, 400,520);
            frame.setDefaultCloseOperation(ABORT);
            frame.setResizable(false);
        }

        else if(e.getSource() == newsButton) {
            AdminNewsGUI frame = new AdminNewsGUI();
            frame.setTitle("Add News");
            frame.setVisible(true);
            frame.setBounds(10,10, 400,400);
            frame.setDefaultCloseOperation(ABORT);
            frame.setResizable(false);
        }

        else if(e.getSource() == showtimeButton) {
            AdminShowtimeGUI frame = new AdminShowtimeGUI();
            frame.setTitle("Add Showtime");
            frame.setVisible(true);
            frame.setBounds(10,10, 400,420);
            frame.setDefaultCloseOperation(ABORT);
            frame.setResizable(false);
        }
    }

    public static void main(String[] args) {
        AdminGUI frame = new AdminGUI();
        frame.setTitle("Admin");
        frame.setVisible(true);
        frame.setBounds(10,10, 400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
