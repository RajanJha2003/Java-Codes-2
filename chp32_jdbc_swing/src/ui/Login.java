package ui;

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

import operationsImp.OperationsImp;



public class Login extends JFrame {
	JLabel emailLabel, passwordLabel;
	JTextField emailText;
	JPasswordField passwordText;
	JButton submitButton, resetButton;

	public Login() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setTitle("Login Form");

		emailLabel = new JLabel("Email");
		emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		emailLabel.setBounds(30, 20, 80, 25);
		add(emailLabel);

		emailText = new JTextField();
		emailText.setBounds(120, 20, 150, 25);
		add(emailText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		passwordLabel.setBounds(30, 60, 80, 25);
		add(passwordLabel);

		passwordText = new JPasswordField();
		passwordText.setBounds(120, 60, 150, 25);
	
		add(passwordText);

		submitButton = new JButton("Submit");
		
		submitButton.setBounds(50, 110, 90, 30);
		submitButton.setBackground(new Color(76, 175, 80));  
		submitButton.setForeground(Color.WHITE);
		add(submitButton);
		
		resetButton = new JButton("Reset");
		
		resetButton.setBounds(160, 110, 90, 30);
		resetButton.setBackground(new Color(33, 150, 243));  
		resetButton.setForeground(Color.WHITE);
		add(resetButton);
		
		
		resetButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				emailText.setText("");
				passwordText.setText("");
				
			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = emailText.getText();
				String password = new String(passwordText.getPassword());
				
				OperationsImp imp=new OperationsImp();
				boolean loggedIn=imp.loginUser(email, password);

				if (loggedIn) {
					JOptionPane.showMessageDialog(Login.this, "Login Successful!");

					
					
				} else {
					JOptionPane.showMessageDialog(Login.this, "Invalid credentials", "Login Error", JOptionPane.ERROR_MESSAGE);
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



