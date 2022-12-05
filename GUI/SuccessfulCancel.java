package GUI;

import javax.swing.*;
import java.awt.*;

public class SuccessfulCancel extends JFrame{
    private Container container;
    private JLabel usernameLabel;
    
    public SuccessfulCancel() {
        usernameLabel = new JLabel("The ticket has been refunded");
        usernameLabel.setBounds(20,50,400,30);
        container = getContentPane();
        container.setLayout(null);
        container.add(usernameLabel);
    }
    
}
