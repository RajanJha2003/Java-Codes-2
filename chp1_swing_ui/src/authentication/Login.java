package authentication;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import toolbar.Home;

public class Login extends JFrame {
	JLabel userLabel, passwordLabel;
	JTextField userText;
	JPasswordField passwordText;
	JButton submitButton, resetButton;

	public Login() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setTitle("Login Form");

		userLabel = new JLabel("Username");
		userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		userLabel.setBounds(30, 20, 80, 25);
		add(userLabel);

		userText = new JTextField();
		userText.setBounds(120, 20, 150, 25);
		add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		passwordLabel.setBounds(30, 60, 80, 25);
		add(passwordLabel);

		passwordText = new JPasswordField();
		passwordText.setBounds(120, 60, 150, 25);
	
		add(passwordText);

		submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(220, 220, 220));
		submitButton.setBounds(50, 110, 90, 30);
		add(submitButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBackground(new Color(220, 220, 220));
		resetButton.setBounds(160, 110, 90, 30);
		add(resetButton);
		
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passwordText.setText("");
				
			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(userText.getText().equals("SDAC") && new String(passwordText.getPassword()).equals("SDAC")) {
					JOptionPane.showMessageDialog(Login.this,"SDAC Login Successful!");
					dispose();
					new Home();
				}else if(userText.getText().equals("admin") && new String(passwordText.getPassword()).equals("admin")) {
					JOptionPane.showMessageDialog(Login.this, "Admin Login Successful!");
				    dispose();
				    new Home();
				}
				
			}
		});

		setSize(320, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Login();
	}

}

class UserDashboard extends JFrame {
    public UserDashboard() {
        setTitle("User Dashboard");
        setSize(300, 200);
        setLayout(null);

        JLabel welcome = new JLabel("Welcome, User!");
        welcome.setBounds(100, 30, 150, 25);
        add(welcome);

        JButton homeButton = new JButton("Home");
        homeButton.setBounds(100, 80, 100, 30);
        add(homeButton);
     

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class AdminDashboard extends JFrame {
    public AdminDashboard() {
        setTitle("Admin Dashboard");
        setSize(300, 200);
        setLayout(null);

        JLabel welcome = new JLabel("Welcome, Admin!");
        welcome.setBounds(100, 30, 150, 25);
        add(welcome);

        JButton homeButton = new JButton("Home");
        homeButton.setBounds(100, 80, 100, 30);
        add(homeButton);
     

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
