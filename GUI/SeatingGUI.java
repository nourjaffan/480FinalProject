import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SeatingGUI extends JFrame implements ActionListener {
    
    private JLabel titleLabel;
    private JButton confirmButton;
    private Container container;
    private JButton[] buttons = new JButton[40];
    private int selected = -1;
    private Color defaultColor;

    public SeatingGUI() {
        titleLabel = new JLabel("Select Seat");
        titleLabel.setBounds(0,10,650,30);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(250, 300, 150, 30);
        confirmButton.addActionListener(this);

        defaultColor = confirmButton.getBackground();

        container = getContentPane();
        container.setLayout(null);
        container.add(titleLabel);
        container.add(confirmButton);

        int x = 30;
        int y = 30;
        for(int i = 0; i < 40; i++) {
            
            //NEED CHECK FOR SELECTED SEAT AVAILABLE

            JButton seatButton = new JButton("S " + (i + 1));
            buttons[i] = seatButton;
            seatButton.addActionListener(this);
            if(i % 8 == 0) {
                x = 30;
                y += 40;
            }

            if((i - 2) % 4 == 0) {
                x += 30;
            }

            seatButton.setBounds(x, y, 60, 30);
            container.add(seatButton);
            x += 70;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == confirmButton) {
            if(selected == -1) {
                //do nothing
            } else {    //NEED CHECK FOR REGISTERED USER AND WHETHER SELECTED SEAT IS AVAILABLE
                System.out.println("here");
                RegularTicketPaymentGUI frame = new RegularTicketPaymentGUI();
                frame.setTitle("Payment");
                frame.setVisible(true);
                frame.setBounds(10,10, 400,500);
            }
        }
        else {
            for(JButton b : buttons) {
                if(b.getBackground() == Color.GREEN) {
                    b.setBackground(defaultColor);
                }
                if(b == e.getSource()) {
                    b.setBackground(Color.GREEN);
                    selected = Integer.parseInt(b.getText().substring(2));
                    System.out.println(selected);
                }
            }
        }
    }

    public static void main(String[] args) {
        SeatingGUI frame = new SeatingGUI();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setBounds(10,10, 680,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
