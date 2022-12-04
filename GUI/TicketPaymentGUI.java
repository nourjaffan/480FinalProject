import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicketPaymentGUI extends JFrame implements ActionListener {
    
    private JLabel titleLabel;
    private JLabel info;

    private String movie = "Movie";
    private String theatre = "Theatre";
    private String showtime = "Showtime";
    private String seat = "Seat Num";
    private JButton confirmButton;
    private Container container;

    //should be given a size of 400, 250
    public TicketPaymentGUI() {
        titleLabel = new JLabel("Confirm Ticket Purchase");
        info = new JLabel(movie + " in " + seat + " at " + theatre + " on " + showtime);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

    public static void main(String[] args) {
        TicketPaymentGUI frame = new TicketPaymentGUI();
        frame.setTitle("Payment");
        frame.setVisible(true);
        frame.setBounds(10,10, 400,250);
    }
}
