import javax.swing.JFrame;

import GUI.LoginGUI;

public class MainRunner {
    public static void main(String[] args){
        LoginGUI frame = new LoginGUI();
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setBounds(10,10, 400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
}
