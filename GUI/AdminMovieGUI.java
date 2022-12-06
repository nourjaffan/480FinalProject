package GUI;

import javax.swing.*;

import Database.DatabaseSingleton;

import java.awt.*;
import java.awt.event.*;

public class AdminMovieGUI extends JFrame implements ActionListener {
    private JLabel movieLabel;
    private JLabel movieTitleLabel;
    private JLabel movieGenreLabel;
    private JLabel movieLengthLabel;
    private JLabel movieReleaseTimeLabel;
    private JLabel movieDayLabel;
    private JLabel movieMonthLabel;
    private JLabel movieYearLabel;
    
    private JTextField movieTitleField;
    private JTextField movieGenreField;
    private JTextField movieLengthField;
    private JTextField movieReleaseTimeField;
    private JTextField movieDayField;
    private JTextField movieMonthField;
    private JTextField movieYearField;

    private JButton confirmButton;
    private DatabaseSingleton database = DatabaseSingleton.getOnlyInstance();
    private Container container;
    
    public AdminMovieGUI() {
        movieLabel = new JLabel("Add Movie");
        movieTitleLabel = new JLabel("Title");
        movieGenreLabel = new JLabel("Genre");
        movieLengthLabel = new JLabel("Length");
        movieReleaseTimeLabel = new JLabel("Release Time");
        movieDayLabel = new JLabel("Day");
        movieMonthLabel = new JLabel("Month");
        movieYearLabel = new JLabel("Year");

        movieTitleField = new JTextField(15);
        movieGenreField = new JTextField(15);
        movieLengthField = new JTextField(15);
        movieReleaseTimeField = new JTextField(15);
        movieDayField = new JTextField(15);
        movieMonthField = new JTextField(15);
        movieYearField = new JTextField(15);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(this);

        movieLabel.setBounds(125,10,150,30);
        movieLabel.setHorizontalAlignment(SwingConstants.CENTER);
        movieTitleLabel.setBounds(50,60,100,30);
        movieGenreLabel.setBounds(50,110,100,30);
        movieLengthLabel.setBounds(50,160,100,30);
        movieReleaseTimeLabel.setBounds(50, 210,100,30);
        movieDayLabel.setBounds(50,260,100,30);
        movieMonthLabel.setBounds(50,310,100,30);
        movieYearLabel.setBounds(50,360,100,30);

        movieTitleField.setBounds(150,60,100,30);
        movieGenreField.setBounds(150,110,100,30);
        movieLengthField.setBounds(150,160,100,30);
        movieReleaseTimeField.setBounds(150,210,100,30);
        movieDayField.setBounds(150,260,100,30);
        movieMonthField.setBounds(150,310,100,30);
        movieYearField.setBounds(150,360,100,30);

        confirmButton.setBounds(125,410,150,50);

        container = getContentPane();
        container.setLayout(null);
        container.add(movieLabel);
        container.add(movieTitleLabel);
        container.add(movieTitleField);
        container.add(movieGenreLabel);
        container.add(movieGenreField);
        container.add(movieLengthLabel);
        container.add(movieLengthField);
        container.add(movieReleaseTimeLabel);
        container.add(movieReleaseTimeField);
        container.add(movieDayLabel);
        container.add(movieDayField);
        container.add(movieMonthLabel);
        container.add(movieMonthField);
        container.add(movieYearLabel);
        container.add(movieYearField);
        container.add(confirmButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(movieTitleField.getText().isEmpty() || movieGenreField.getText().isEmpty() || movieLengthField.getText().isEmpty() || movieReleaseTimeField.getText().isEmpty() ||
            movieDayField.getText().isEmpty() || movieMonthField.getText().isEmpty() || movieYearField.getText().isEmpty()){

                JOptionPane.showMessageDialog(null, "Please enter all info");
                
            }else{
                database.addNewMovie(movieTitleField.getText(), movieGenreField.getText(), movieLengthField.getText(), movieReleaseTimeField.getText(),
                            Integer.parseInt(movieDayField.getText()), Integer.parseInt(movieMonthField.getText()), Integer.parseInt(movieYearField.getText()));
                JOptionPane.showMessageDialog(null, "The movie has been added to the database");
            }
        
        // TODO Auto-generated method stub
        
    }
}
