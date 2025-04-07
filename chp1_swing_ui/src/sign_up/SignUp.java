package sign_up;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import authentication.Login;

public class SignUp extends JFrame {
	JLabel nameLabel, contactLabel, mobileLabel, passwordLabel, genderLabel, cityLabel, commentLabel, departmentLabel;
	JTextField nameField, contactField, mobileField, cityField;
	JPasswordField passwordField;
	JComboBox<String> departmentComboBox;
	JRadioButton maleRadio, femaleRadio, otherRadio;
	JTextArea commentArea;
	JButton submitButton, discardButton, resetButton;
	Font labelFont, fieldFont, buttonFont;
	ButtonGroup genderGroup;
	JScrollPane commentScroll;

	public SignUp() {
		setTitle("Sign Up Form");
		setLayout(null);
		getContentPane().setBackground(new Color(245, 245, 245)); // Light gray background
		
		labelFont = new Font("Arial", Font.BOLD, 12);
		fieldFont = new Font("Arial", Font.PLAIN, 12);
		buttonFont = new Font("Arial", Font.BOLD, 12);

		// Name
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(labelFont);
		nameLabel.setBounds(50, 50, 120, 30);
		add(nameLabel);

		nameField = new JTextField();
		nameField.setFont(fieldFont);
		nameField.setBounds(120, 50, 250, 30);
		add(nameField);

		// Contact
		contactLabel = new JLabel("Contact:");
		contactLabel.setFont(labelFont);
		contactLabel.setBounds(50, 100, 120, 30);
		add(contactLabel);

		contactField = new JTextField();
		contactField.setFont(fieldFont);
		contactField.setBounds(120, 100, 250, 30);
		add(contactField);

		// Mobile
		mobileLabel = new JLabel("Mobile:");
		mobileLabel.setFont(labelFont);
		mobileLabel.setBounds(50, 150, 120, 30);
		add(mobileLabel);

		mobileField = new JTextField();
		mobileField.setFont(fieldFont);
		mobileField.setBounds(120, 150, 250, 30);
		add(mobileField);

		// Password
		passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(labelFont);
		passwordLabel.setBounds(50, 200, 120, 30);
		add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setFont(fieldFont);
		passwordField.setBounds(120, 200, 250, 30);
		add(passwordField);

		// Gender
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

		// Department
		departmentLabel = new JLabel("Dept:");
		departmentLabel.setBounds(50, 300, 120, 30);
		departmentLabel.setFont(labelFont);
		add(departmentLabel);

		String[] departments = {"CSE", "IT", "ECE", "EEE", "MECH"};
		departmentComboBox = new JComboBox<String>(departments);
		departmentComboBox.setBounds(120, 300, 250, 30);
		departmentComboBox.setFont(fieldFont);
		add(departmentComboBox);

		// Comments
		commentLabel = new JLabel("Comments:");
		commentLabel.setBounds(50, 350, 120, 30);
		commentLabel.setFont(labelFont);
		add(commentLabel);

		commentArea = new JTextArea();
		commentArea.setFont(fieldFont);
		commentArea.setLineWrap(true);
		commentArea.setWrapStyleWord(true);
		commentScroll = new JScrollPane(commentArea);
		commentScroll.setBounds(120, 350, 250, 100);
		add(commentScroll);

		// Buttons
		submitButton = new JButton("Submit");
		submitButton.setBounds(50, 470, 100, 40);
		submitButton.setFont(buttonFont);
		submitButton.setBackground(new Color(76, 175, 80));  // Green
		submitButton.setForeground(Color.WHITE);
		add(submitButton);

		resetButton = new JButton("Reset");
		resetButton.setBounds(170, 470, 100, 40);
		resetButton.setFont(buttonFont);
		resetButton.setBackground(new Color(33, 150, 243));  // Blue
		resetButton.setForeground(Color.WHITE);
		add(resetButton);

		discardButton = new JButton("Discard");
		discardButton.setBounds(290, 470, 100, 40);
		discardButton.setFont(buttonFont);
		discardButton.setBackground(new Color(244, 67, 54));  // Red
		discardButton.setForeground(Color.WHITE);
		add(discardButton);

		// Submit Action
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String gender = "";
				if (maleRadio.isSelected()) gender = "Male";
				else if (femaleRadio.isSelected()) gender = "Female";
				else if (otherRadio.isSelected()) gender = "Other";

				String department = (String) departmentComboBox.getSelectedItem();
				String password = new String(passwordField.getPassword());

				String details = "Name: " + nameField.getText() + "\n"
						+ "Contact: " + contactField.getText() + "\n"
						+ "Mobile: " + mobileField.getText() + "\n"
						+ "Password: " + password + "\n"
						+ "Gender: " + gender + "\n"
						+ "Department: " + department + "\n"
						+ "Comments: " + commentArea.getText();

				JOptionPane.showMessageDialog(null, details, "Submitted Data", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				new Login();
			}
		});

		// Reset Action
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nameField.setText("");
				contactField.setText("");
				mobileField.setText("");
				passwordField.setText("");
				genderGroup.clearSelection();
				departmentComboBox.setSelectedIndex(0);
				commentArea.setText("");
			}
		});

		// Discard Action
		discardButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Final Frame Settings
		setSize(450, 580); // Increased height to accommodate password
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignUp();
	}
}
