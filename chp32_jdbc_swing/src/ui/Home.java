package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    public Home() {
        // Set up the frame
        setTitle("User Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Using absolute positioning

        // Add a welcome label
        JLabel welcomeLabel = new JLabel("Welcome to User Management System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setBounds(150, 30, 500, 40);
        add(welcomeLabel);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create menus
        JMenu searchUserMenu = new JMenu("Search User");
        JMenu getAllUsersMenu = new JMenu("Get All Users");
        JMenu insertUserMenu = new JMenu("Insert User");
        JMenu exitMenu = new JMenu("Exit");

        // Add menu items
        menuBar.add(searchUserMenu);
        menuBar.add(getAllUsersMenu);
        menuBar.add(insertUserMenu);
        menuBar.add(exitMenu);

       

        // Create toolbar
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.setBounds(250, 100, 300, 40); // Adjust position to be a little higher and centered

        // Create toolbar buttons
        JButton searchButton = new JButton("Search User");
        JButton getAllUsersButton = new JButton("Get All Users");
        JButton insertUserButton = new JButton("Insert User");
        JButton exitButton = new JButton("Exit");

        // Add action listeners
        searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				
			}
		});
        getAllUsersButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
        insertUserButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
                new SignUp();
				
			}
		});
        exitButton.addActionListener(e -> System.exit(0));

        // Add buttons to toolbar
        toolBar.add(searchButton);
        toolBar.add(getAllUsersButton);
        toolBar.add(insertUserButton);
        toolBar.add(exitButton);

        // Add toolbar to frame
        add(toolBar);

        // Display the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        // Use SwingUtilities.invokeLater for thread safety
        SwingUtilities.invokeLater(Home::new);
    }
}