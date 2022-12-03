import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CancelTicketGUI extends JFrame implements ActionListener {
    private JLabel cancelLabel;
    private JLabel ticketNumLabel;
    private JTextField ticketNumField;
    private JButton cancelButton;
    private Container container;

    public CancelTicketGUI() {
        cancelLabel = new JLabel("Cancel Ticket");
        ticketNumLabel = new JLabel("Enter Ticket Number");
        ticketNumField = new JTextField(15);
        cancelButton = new JButton("Confirm");

        cancelLabel.setBounds(125,10,150,30);
        cancelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ticketNumLabel.setBounds(125, 60, 150, 30);
        ticketNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ticketNumField.setBounds(125, 90, 150, 30);
        cancelButton.setBounds(125, 130, 150, 30);

        container = getContentPane();
        container.setLayout(null);
        container.add(cancelLabel);
        container.add(ticketNumLabel);
        container.add(ticketNumField);
        container.add(cancelButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
