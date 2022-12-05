import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminShowtimeGUI extends JFrame implements ActionListener {
    
    private JLabel showtimeLabel;
    private JLabel titleLabel;
    private JLabel dayLabel;
    private JLabel monthLabel;
    private JLabel yearLabel;
    private JLabel timeLabel;

    private JTextField titleField;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;
    private JTextField timeField;

    private JButton confirmButton;
    private Container container;

    public AdminShowtimeGUI() {
        showtimeLabel = new JLabel("Add Showtime");
        titleLabel = new JLabel("Title");
        dayLabel = new JLabel("Day");
        monthLabel = new JLabel("Month");
        yearLabel = new JLabel("Year");
        timeLabel = new JLabel("Showtime");

        titleField = new JTextField(15);
        dayField = new JTextField(15);
        monthField = new JTextField(15);
        yearField = new JTextField(15);
        timeField = new JTextField(15);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);

        showtimeLabel.setBounds(125,10,150,30);
        showtimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(50,60,100,30);
        dayLabel.setBounds(50,110,100,30);
        monthLabel.setBounds(50,160,100,30);
        yearLabel.setBounds(50,210,100,30);
        titleField.setBounds(150,60,100,30);
        dayField.setBounds(150,110,100,30);
        monthField.setBounds(150,160,100,30);
        yearField.setBounds(150,210,100,30);
        timeLabel.setBounds(50,260,100,30);
        timeField.setBounds(150,260,100,30);
        confirmButton.setBounds(125,310,150,50);

        container = getContentPane();
        container.setLayout(null);
        container.add(showtimeLabel);
        container.add(titleLabel);
        container.add(titleField);
        container.add(dayLabel);
        container.add(dayField);
        container.add(monthLabel);
        container.add(monthField);
        container.add(yearLabel);
        container.add(yearField);
        container.add(timeLabel);
        container.add(timeField);
        container.add(confirmButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
