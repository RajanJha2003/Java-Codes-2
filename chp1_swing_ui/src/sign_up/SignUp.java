package sign_up;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SignUp extends JFrame {
	JLabel nameLabel, contactLabel, mobileLabel, genderLabel, cityLabel, commentLabel, departmentLabel;
	JTextField nameField, contactField, mobileField, cityField;
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
		
		// Simplified font choices
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

		contactLabel = new JLabel("Contact:");
		contactLabel.setFont(labelFont);
		contactLabel.setBounds(50, 100, 120, 30);
		add(contactLabel);

		contactField = new JTextField();
		contactField.setFont(fieldFont);
		contactField.setBounds(120, 100, 250, 30);
		add(contactField);

		mobileLabel = new JLabel("Mobile:");
		mobileLabel.setFont(labelFont);
		mobileLabel.setBounds(50, 150, 120, 30);
		add(mobileLabel);

		mobileField = new JTextField();
		mobileField.setFont(fieldFont);
		mobileField.setBounds(120, 150, 250, 30);
		add(mobileField);

		genderLabel = new JLabel("Gender:");
		genderLabel.setBounds(50, 200, 120, 30);
		genderLabel.setFont(labelFont);
		add(genderLabel);
		
		maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(120, 200, 80, 30);
        maleRadio.setFont(fieldFont);
        maleRadio.setBackground(new Color(245, 245, 245));

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(200, 200, 90, 30);
        femaleRadio.setFont(fieldFont);
        femaleRadio.setBackground(new Color(245, 245, 245));

        otherRadio = new JRadioButton("Other");
        otherRadio.setBounds(290, 200, 80, 30);
        otherRadio.setFont(fieldFont);
        otherRadio.setBackground(new Color(245, 245, 245));
        
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);
        add(maleRadio); 
        add(femaleRadio); 
        add(otherRadio);
        
        departmentLabel = new JLabel("Dept:");
        departmentLabel.setBounds(50, 250, 120, 30);
        departmentLabel.setFont(labelFont);
        add(departmentLabel);
        
        String[] departments = {"CSE", "IT", "ECE", "EEE", "MECH"};
        departmentComboBox = new JComboBox<String>(departments);
        departmentComboBox.setBounds(120, 250, 250, 30);
        departmentComboBox.setFont(fieldFont);
        add(departmentComboBox);
        
        commentLabel = new JLabel("Comments:");
        commentLabel.setBounds(50, 300, 120, 30);
        commentLabel.setFont(labelFont);
        add(commentLabel);

        commentArea = new JTextArea();
        commentArea.setFont(fieldFont);
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        commentScroll = new JScrollPane(commentArea);
        commentScroll.setBounds(120, 300, 250, 100);
        add(commentScroll);
        
        // Use direct colors for each button
        submitButton = new JButton("Submit");
        submitButton.setBounds(50, 420, 100, 40);
        submitButton.setFont(buttonFont);
        submitButton.setBackground(new Color(76, 175, 80));  // Green
        submitButton.setForeground(Color.WHITE);
        add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.setBounds(170, 420, 100, 40);
        resetButton.setFont(buttonFont);
        resetButton.setBackground(new Color(33, 150, 243));  // Blue
        resetButton.setForeground(Color.WHITE);
        add(resetButton);

        discardButton = new JButton("Discard");
        discardButton.setBounds(290, 420, 100, 40);
        discardButton.setFont(buttonFont);
        discardButton.setBackground(new Color(244, 67, 54));  // Red
        discardButton.setForeground(Color.WHITE);
        add(discardButton);
		
		setSize(450, 530);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignUp();
	}
}