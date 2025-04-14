package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import crud_with_swing.OperationsImp;
import crud_with_swing.User;





public class InsertUser extends JFrame {
	JLabel nameLabel,emailLabel,  phoneLabel, passwordLabel, genderLabel, cityLabel;
	JTextField nameField, emailField, phoneField, cityField;
	JPasswordField passwordField;
	
	JRadioButton maleRadio, femaleRadio, otherRadio;
	
	JButton submitButton, discardButton, resetButton;
	Font labelFont, fieldFont, buttonFont;
	ButtonGroup genderGroup;
	

	public InsertUser() {
		setTitle("Sign Up Form");
		setLayout(null);
		getContentPane().setBackground(new Color(245, 245, 245));
		
		labelFont = new Font("Arial", Font.BOLD, 12);
		fieldFont = new Font("Arial", Font.PLAIN, 12);
		buttonFont = new Font("Arial", Font.BOLD, 12);

		nameLabel = new JLabel("Name:");
		nameLabel.setFont(labelFont);
		nameLabel.setBounds(50, 50, 120, 30);
		add(nameLabel);

		nameField = new JTextField();
		nameField.setFont(fieldFont);
		nameField.setBounds(120, 50, 250, 30);
		add(nameField);

		
		emailLabel = new JLabel("Email:");
		emailLabel.setFont(labelFont);
		emailLabel.setBounds(50, 100, 120, 30);
		add(emailLabel);

		emailField = new JTextField();
		emailField.setFont(fieldFont);
		emailField.setBounds(120, 100, 250, 30);
		add(emailField);

		
		phoneLabel = new JLabel("Phone:");
		phoneLabel.setFont(labelFont);
		phoneLabel.setBounds(50, 150, 120, 30);
		add(phoneLabel);

		phoneField = new JTextField();
		phoneField.setFont(fieldFont);
		phoneField.setBounds(120, 150, 250, 30);
		add(phoneField);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(labelFont);
		passwordLabel.setBounds(50, 200, 120, 30);
		add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setFont(fieldFont);
		passwordField.setBounds(120, 200, 250, 30);
		add(passwordField);

		genderLabel = new JLabel("Gender:");
		genderLabel.setBounds(50, 250, 120, 30);
		genderLabel.setFont(labelFont);
		add(genderLabel);
		
		maleRadio = new JRadioButton("Male");
		maleRadio.setBounds(120, 250, 80, 30);
		maleRadio.setFont(fieldFont);
		maleRadio.setBackground(new Color(245, 245, 245));

		femaleRadio = new JRadioButton("Female");
		femaleRadio.setBounds(200, 250, 90, 30);
		femaleRadio.setFont(fieldFont);
		femaleRadio.setBackground(new Color(245, 245, 245));

		otherRadio = new JRadioButton("Other");
		otherRadio.setBounds(290, 250, 80, 30);
		otherRadio.setFont(fieldFont);
		otherRadio.setBackground(new Color(245, 245, 245));

		genderGroup = new ButtonGroup();
		genderGroup.add(maleRadio);
		genderGroup.add(femaleRadio);
		genderGroup.add(otherRadio);
		add(maleRadio); 
		add(femaleRadio); 
		add(otherRadio);

		
		cityLabel = new JLabel("City");
		cityLabel.setBounds(50, 300, 120, 30);
		cityLabel.setFont(labelFont);
		add(cityLabel);

		
		cityField = new JTextField();
		cityField.setBounds(120, 300, 250, 30);
		cityField.setFont(fieldFont);
		add(cityField);

		


		submitButton = new JButton("Submit");
		submitButton.setBounds(50, 350, 100, 40);
		submitButton.setFont(buttonFont);
		submitButton.setBackground(new Color(76, 175, 80));  
		submitButton.setForeground(Color.WHITE);
		add(submitButton);

		resetButton = new JButton("Reset");
		resetButton.setBounds(170, 350, 100, 40);
		resetButton.setFont(buttonFont);
		resetButton.setBackground(new Color(33, 150, 243));  
		resetButton.setForeground(Color.WHITE);
		add(resetButton);

		discardButton = new JButton("Discard");
		discardButton.setBounds(290, 350, 100, 40);
		discardButton.setFont(buttonFont);
		discardButton.setBackground(new Color(244, 67, 54));  
		discardButton.setForeground(Color.WHITE);
		add(discardButton);

		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name = nameField.getText();
		        String email = emailField.getText();
		        String phone = phoneField.getText();
		        String password = new String(passwordField.getPassword());
		        String city = cityField.getText();
		        String gender = "";

		        if (maleRadio.isSelected()) {
		            gender = "Male";
		        } else if (femaleRadio.isSelected()) {
		            gender = "Female";
		        } else if (otherRadio.isSelected()) {
		            gender = "Other";
		        }
		        
		        User user=new User();
		        user.setUsername(name);
		        user.setEmail(email);
		        user.setPhone(phone);
		        user.setPassword(password);
		        user.setCity(city);
		        user.setGender(gender);
		        
		        OperationsImp imp=new OperationsImp();
		        boolean success=imp.addUser(user);
		        
		        if (success) {
		            JOptionPane.showMessageDialog(null, "User registered successfully!");
		            // Optionally clear the form here
		        } else {
		            JOptionPane.showMessageDialog(null, "Failed to register user", "Database Error", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});

		// Final Frame Settings
		setSize(450, 450); // Increased height to accommodate password
		setLocationRelativeTo(null);
		setResizable(false);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new InsertUser();
	}
}