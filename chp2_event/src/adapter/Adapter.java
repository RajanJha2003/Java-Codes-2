package adapter;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;

public class Adapter extends JFrame {

	public Adapter() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		setTitle("Login Form");

		JLabel nameLabel = new JLabel("Enter your name:");
		nameLabel.setBounds(50, 50, 100, 30);
		JTextField textField = new JTextField();
		textField.setBounds(150, 50, 200, 30);
		textField.setName("Name");
		
		textField.addKeyListener(new KeyAdapter() {
		  @Override
		public void keyTyped(KeyEvent e) {
              System.out.println(textField.getName() + " - Typed: '" + e.getKeyChar() + "'");

			
		}
		
		});

		JLabel countryLabel = new JLabel("Select your country:");
		countryLabel.setBounds(50, 100, 150, 30);
		String[] countries = { "USA", "India", "Germany", "Australia" };
		JComboBox<String> comboBox = new JComboBox<String>(countries);
		comboBox.setBounds(160, 100, 200, 30);
		comboBox.setName("Country");
		comboBox.addMouseListener(new MouseInputAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(comboBox.getName()+"Selected"+comboBox.getSelectedItem());
			}
		});
		

		JLabel genderlabel = new JLabel("Select  gender:");
		genderlabel.setBounds(50, 150, 150, 30);

		JRadioButton maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setBounds(150, 150, 80, 30);
        
        maleRadioButton.setName("MaleRadioButton");

		maleRadioButton.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseEntered(MouseEvent e) {
		        	// TODO Auto-generated method stub
		        	System.out.println(maleRadioButton.getName()+" mouse entered");
		        }     
		
		});
		
		JRadioButton femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setBounds(240, 150, 80, 30);

		
		femaleRadioButton.setName("Female radio Button");
		femaleRadioButton.addMouseMotionListener(new MouseMotionAdapter() {
		
		  public void mouseMoved(MouseEvent e) {
			  System.out.println(femaleRadioButton.getName()+" moved");
		  };
		
		}
		);
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(maleRadioButton);
		buttonGroup.add(femaleRadioButton);

		JCheckBox termsCheckBox = new JCheckBox("Accept Terms");
		termsCheckBox.setBounds(150, 180, 150, 30);
        
		termsCheckBox.setName("Check Box");
		termsCheckBox.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				System.out.println(termsCheckBox.getName()+" focus gained");
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				System.out.println(termsCheckBox.getName()+" focus lost");

			}
		});
		
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(150, 200, 100, 30);
		
		submitButton.setName("SubmitButton");

	
		submitButton.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        System.out.println(submitButton.getName() + " - Mouse Clicked");
		    }
		});

		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");

		fileMenu.add(exitItem);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		add(nameLabel);
		add(textField);

		add(countryLabel);
		add(comboBox);

		add(genderlabel);
		add(maleRadioButton);
		add(femaleRadioButton);

		add(termsCheckBox);

		add(submitButton);

		setSize(400, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Adapter();
	}

}
