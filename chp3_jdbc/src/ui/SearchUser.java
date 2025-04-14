package ui;

import javax.swing.*;
import crud_with_swing.OperationsImp;
import crud_with_swing.User;
import java.awt.*;
import java.awt.event.*;

public class SearchUser extends JFrame {
    private JTextField usernameField;
    private JButton searchButton, resetButton, backButton;
    private JTextArea resultArea;
    private Font labelFont, fieldFont, buttonFont;

    public SearchUser() {
        // Set up the frame
        setTitle("Search User");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Better than EXIT_ON_CLOSE for a sub-window
        setLayout(null); // Using absolute positioning
        getContentPane().setBackground(new Color(245, 245, 245)); // Light gray background like SignUp
        
        // Define fonts for consistency
        labelFont = new Font("Arial", Font.BOLD, 12);
        fieldFont = new Font("Arial", Font.PLAIN, 12);
        buttonFont = new Font("Arial", Font.BOLD, 12);

        // Create and position components
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(labelFont);
        usernameLabel.setBounds(50, 50, 120, 30);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(fieldFont);
        usernameField.setBounds(150, 50, 250, 30);
        add(usernameField);

        searchButton = new JButton("Search");
        searchButton.setFont(buttonFont);
        searchButton.setBounds(50, 100, 100, 40);
        searchButton.setBackground(new Color(76, 175, 80)); // Green
        searchButton.setForeground(Color.WHITE);
        add(searchButton);

        resetButton = new JButton("Reset");
        resetButton.setFont(buttonFont);
        resetButton.setBounds(175, 100, 100, 40);
        resetButton.setBackground(new Color(33, 150, 243)); // Blue
        resetButton.setForeground(Color.WHITE);
        add(resetButton);

        backButton = new JButton("Back");
        backButton.setFont(buttonFont);
        backButton.setBounds(300, 100, 100, 40);
        backButton.setBackground(new Color(244, 67, 54)); // Red
        backButton.setForeground(Color.WHITE);
        add(backButton);

        JLabel resultLabel = new JLabel("Search Results:");
        resultLabel.setFont(labelFont);
        resultLabel.setBounds(50, 160, 120, 30);
        add(resultLabel);

        resultArea = new JTextArea();
        resultArea.setFont(fieldFont);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBounds(50, 190, 350, 150);
        add(scrollPane);

        // Add action listeners
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                if (!username.isEmpty()) {
                    OperationsImp imp = new OperationsImp();
                    User user = imp.searchUser(username);
                    if (user != null) {
                        resultArea.setText("User found:\n\n" +
                                "ID: " + user.getId() + "\n" +
                                "Username: " + user.getUsername() + "\n" +
                                "Email: " + user.getEmail() + "\n" +
                                "Phone: " + user.getPhone() + "\n" +
                                "Gender: " + user.getGender() + "\n" +
                                "City: " + user.getCity());
                    } else {
                        resultArea.setText("User not found.");
                        JOptionPane.showMessageDialog(null, "No user found with username: " + username, 
                                "Search Result", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a username.", 
                            "Input Required", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                resultArea.setText("");
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close this window instead of exiting the application
                // Optionally navigate back to main menu or previous screen
                // new MainMenu(); // Uncomment if you have a MainMenu class
            }
        });

        setLocationRelativeTo(null); // Center on screen
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SearchUser();
            }
        });
    }
}