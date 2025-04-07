package toolbar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JToolBar;

public class Home extends JFrame {
	JMenuBar menuBar;
	JMenu homeMenu,doctorMenu,patientMenu,accountsMenu,billingMenu;
	JMenuItem aboutUs, services, location, exit, doctorInfo, doctorRegistration, payment, 
    patient_details, registration, payment_details;
	
	public Home() {
		// TODO Auto-generated constructor stub
		setTitle("Home");
		setLayout(null);
		
		menuBar=new JMenuBar();
		
		homeMenu=new JMenu("Home");
		aboutUs = new JMenuItem("About Us");
        services = new JMenuItem("Services");
        location = new JMenuItem("Location");
        exit = new JMenuItem("Exit");
        exit.addActionListener(e->System.exit(0));
        homeMenu.add(aboutUs);
        homeMenu.add(new JSeparator());
        homeMenu.add(services);
        homeMenu.add(new JSeparator());
        homeMenu.add(location);
        homeMenu.add(new JSeparator());
        homeMenu.add(exit);
        
        doctorMenu = new JMenu("Doctor");
        doctorInfo = new JMenuItem("Doctor Info");
        doctorRegistration = new JMenuItem("Doctor Registration");
        payment = new JMenuItem("Payment");
        doctorMenu.add(doctorInfo);
        doctorMenu.add(doctorRegistration);
        doctorMenu.add(payment);
        
        patientMenu = new JMenu("Patient");
        patient_details = new JMenuItem("Patient Details");
        registration = new JMenuItem("Registration");
        
        billingMenu=new JMenu("Billing");
        JMenuItem withGst=new JMenuItem("With GST");
        JMenuItem ngo=new JMenuItem("NGO");
        
        billingMenu.add(withGst);
        billingMenu.add(ngo);
        
        
        patientMenu.add(patient_details);
        patientMenu.add(billingMenu); 
        patientMenu.add(new JSeparator());
        patientMenu.add(registration);
        
        accountsMenu = new JMenu("Accounts");
        payment_details = new JMenuItem("Payment Details");
        accountsMenu.add(payment_details);
        
        menuBar.add(homeMenu);
        menuBar.add(doctorMenu);
        menuBar.add(patientMenu);
        menuBar.add(accountsMenu);
        
        setJMenuBar(menuBar);
        
        JToolBar toolBar=new JToolBar();
        
        
        JButton homeButton = new JButton("🏠 Home");
        JButton doctorButton = new JButton("👨‍⚕️ Doctor");
        JButton patientButton = new JButton("🧑‍🤝‍🧑 Patient");
        JButton exitButton = new JButton("❌ Exit");

        homeButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Home clicked"));
        doctorButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Doctor clicked"));
        patientButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Patient clicked"));
        exitButton.addActionListener(e -> System.exit(0));

        
        toolBar.add(homeButton);
        toolBar.add(doctorButton);
        toolBar.add(patientButton);
        toolBar.add(exitButton);
        toolBar.setBounds(0, 0, 450, 40);

        add(toolBar);
		
        
        

		
		setSize(450, 530);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Home();

	}

}
