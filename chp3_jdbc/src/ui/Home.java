package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JFrame {

    public Home() {
        setTitle("User Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Font buttonFont = new Font("Segoe UI", Font.BOLD, 16);

        // Welcome Label
        JLabel welcomeLabel = new JLabel("Welcome to User Management System", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        welcomeLabel.setForeground(new Color(40, 40, 40));
        welcomeLabel.setBounds(100, 50, 600, 50);
        add(welcomeLabel);

        int btnWidth = 250;
        int btnHeight = 50;
        int x = (800 - btnWidth) / 2;
        int yStart = 150;
        int spacing = 70;

        // Search User Button - Blue
        JButton searchBtn = new JButton("Search User");
        searchBtn.setBounds(x, yStart, btnWidth, btnHeight);
        searchBtn.setBackground(new Color(52, 152, 219));
        searchBtn.setForeground(Color.WHITE);
        searchBtn.setFont(buttonFont);
        searchBtn.setFocusPainted(false);
       
        add(searchBtn);

        // Get All Users Button - Green
        JButton allUsersBtn = new JButton("Get All Users");
        allUsersBtn.setBounds(x, yStart + spacing, btnWidth, btnHeight);
        allUsersBtn.setBackground(new Color(46, 204, 113));
        allUsersBtn.setForeground(Color.WHITE);
        allUsersBtn.setFont(buttonFont);
        allUsersBtn.setFocusPainted(false);
       allUsersBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new ViewUsers();
			
		}
	});
        add(allUsersBtn);

        // Insert User Button - Orange
        JButton insertBtn = new JButton("Insert User");
        insertBtn.setBounds(x, yStart + spacing * 2, btnWidth, btnHeight);
        insertBtn.setBackground(new Color(243, 156, 18));
        insertBtn.setForeground(Color.WHITE);
        insertBtn.setFont(buttonFont);
        insertBtn.setFocusPainted(false);
        insertBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InsertUser();
				
			}
		});
        add(insertBtn);

        // Exit Button - Red
        JButton exitBtn = new JButton("Exit");
        exitBtn.setBounds(x, yStart + spacing * 3, btnWidth, btnHeight);
        exitBtn.setBackground(new Color(231, 76, 60));
        exitBtn.setForeground(Color.WHITE);
        exitBtn.setFont(buttonFont);
        exitBtn.setFocusPainted(false);
        exitBtn.addActionListener(e -> System.exit(0));
        add(exitBtn);

        setVisible(true);
    }

   
    private void insertUser() {
        JOptionPane.showMessageDialog(this, "Insert User functionality not implemented yet.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Home::new);
    }
}
