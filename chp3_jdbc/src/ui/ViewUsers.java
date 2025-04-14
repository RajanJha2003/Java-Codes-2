package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import crud_with_swing.OperationsImp;
import crud_with_swing.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ViewUsers extends JFrame {

    public ViewUsers() {
        setTitle("All Registered Users");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));

        // Title label
        JLabel titleLabel = new JLabel("User Management System");
        titleLabel.setBounds(200, 20, 300, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(titleLabel);

        // Table setup
        String[] columns = { "ID", "Username", "Email", "Phone", "Gender", "City" };
        DefaultTableModel defaultTableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JTable table = new JTable(defaultTableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 12));
        table.setRowHeight(25);
        table.setGridColor(new Color(230, 230, 230));
        table.setSelectionBackground(new Color(210, 230, 210));
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 12));
        header.setBackground(new Color(220, 220, 220));

        // Populate table
        OperationsImp imp = new OperationsImp();
        List<User> list = imp.getAllUsers();
        for (User user : list) {
            Object[] row = {
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPhone(),
                    user.getGender(),
                    user.getCity()
            };
            defaultTableModel.addRow(row);
        }

        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 70, 600, 300);
        add(scrollPane);

        // Instruction label
        JLabel instructionLabel = new JLabel("Double-click on a row to edit user");
        instructionLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        instructionLabel.setBounds(50, 380, 300, 20);
        add(instructionLabel);

        // Add action buttons
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(50, 410, 100, 40);
        refreshButton.setFont(new Font("Arial", Font.BOLD, 12));
        refreshButton.setBackground(new Color(33, 150, 243));
        refreshButton.setForeground(Color.WHITE);
        refreshButton.addActionListener(e -> refreshTable());
        add(refreshButton);

        JButton addNewButton = new JButton("Add New");
        addNewButton.setBounds(170, 410, 100, 40);
        addNewButton.setFont(new Font("Arial", Font.BOLD, 12));
        addNewButton.setBackground(new Color(76, 175, 80));
        addNewButton.setForeground(Color.WHITE);
        addNewButton.addActionListener(e -> openInsertUserForm());
        add(addNewButton);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(290, 410, 100, 40);
        closeButton.setFont(new Font("Arial", Font.BOLD, 12));
        closeButton.setBackground(new Color(244, 67, 54));
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(e -> dispose());
        add(closeButton);

       table.addMouseListener(new MouseAdapter() {
    	   public void mouseClicked(MouseEvent e) {
    		   if(e.getClickCount()==2) {
    			   int row = table.rowAtPoint(e.getPoint());
    			   if(row>=0) {
    				   int userId = (int) table.getValueAt(row, 0);
                       OperationsImp imp=new OperationsImp();
                       User user=imp.getUserById(userId);
                       if(user!=null) {
                    	   new EditUserForm(user);
                       }
                       
                       

    			   }

    		   }
    	   };
	});

        setResizable(false);
        setVisible(true);
    }

    private void refreshTable() {
        dispose();
        new ViewUsers();
    }

    private void openInsertUserForm() {
        new InsertUser();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewUsers());
    }
}

class EditUserForm extends JFrame {
	
	private JTextField usernameField, emailField, phoneField, cityField;
    private JPasswordField passwordField;
    private JRadioButton maleRadio, femaleRadio, otherRadio;
    private ButtonGroup genderGroup;
    private int userId;
    private Font labelFont, fieldFont, buttonFont;

    public EditUserForm(User user) {
        
        
        setTitle("Edit User");
        setLayout(null);
        getContentPane().setBackground(new Color(245, 245, 245));
        
        labelFont = new Font("Arial", Font.BOLD, 12);
        fieldFont = new Font("Arial", Font.PLAIN, 12);
        buttonFont = new Font("Arial", Font.BOLD, 12);

        // Username field
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(labelFont);
        nameLabel.setBounds(50, 50, 120, 30);
        add(nameLabel);

        usernameField = new JTextField(user.getUsername());
        usernameField.setFont(fieldFont);
        usernameField.setBounds(120, 50, 250, 30);
        add(usernameField);

        // Email field
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        emailLabel.setBounds(50, 100, 120, 30);
        add(emailLabel);

        emailField = new JTextField(user.getEmail());
        emailField.setFont(fieldFont);
        emailField.setBounds(120, 100, 250, 30);
        add(emailField);

        // Phone field
        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(labelFont);
        phoneLabel.setBounds(50, 150, 120, 30);
        add(phoneLabel);

        phoneField = new JTextField(user.getPhone());
        phoneField.setFont(fieldFont);
        phoneField.setBounds(120, 150, 250, 30);
        add(phoneField);

        // Gender selection
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(50, 200, 120, 30);
        genderLabel.setFont(labelFont);
        add(genderLabel);
        
        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(120, 200, 80, 30);
        maleRadio.setFont(fieldFont);
        maleRadio.setBackground(new Color(245, 245, 245));
        maleRadio.setSelected(user.getGender().equals("Male"));

        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(200, 200, 90, 30);
        femaleRadio.setFont(fieldFont);
        femaleRadio.setBackground(new Color(245, 245, 245));
        femaleRadio.setSelected(user.getGender().equals("Female"));

        otherRadio = new JRadioButton("Other");
        otherRadio.setBounds(290, 200, 80, 30);
        otherRadio.setFont(fieldFont);
        otherRadio.setBackground(new Color(245, 245, 245));
        otherRadio.setSelected(user.getGender().equals("Other"));

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);
        add(maleRadio); 
        add(femaleRadio); 
        add(otherRadio);
        
        // City field
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(50, 250, 120, 30);
        cityLabel.setFont(labelFont);
        add(cityLabel);

        cityField = new JTextField(user.getCity());
        cityField.setBounds(120, 250, 250, 30);
        cityField.setFont(fieldFont);
        add(cityField);

        
        JLabel passwordlabel = new JLabel("Password:");
        passwordlabel.setBounds(50, 300, 120, 30);
        passwordlabel.setFont(labelFont);
        add(passwordlabel);

        JPasswordField passwordField = new JPasswordField(user.getPassword());
        passwordField.setBounds(120, 300, 250, 30);
        passwordField.setFont(fieldFont);
        add(passwordField);
        // Buttons
        JButton updateButton = new JButton("Update");
        updateButton.setBounds(50, 350, 100, 40);
        updateButton.setFont(buttonFont);
        updateButton.setBackground(new Color(76, 175, 80));
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String username = usernameField.getText();
		        String email = emailField.getText();
		        String phone = phoneField.getText();
		        String city = cityField.getText();
		        String gender = "";
		        String password=new String(passwordField.getPassword());
		
		        if (maleRadio.isSelected()) {
		            gender = "Male";
		        } else if (femaleRadio.isSelected()) {
		            gender = "Female";
		        } else if (otherRadio.isSelected()) {
		            gender = "Other";
		        }
		        
		        User user1=new User();
		        user1.setUsername(username);
		        user1.setEmail(email);
		        user1.setPassword(password);
		        user1.setPhone(phone);
		        user1.setCity(city);
		        user1.setGender(gender);
		        user1.setId(user.getId());
		        
		        
		        OperationsImp imp = new OperationsImp();
		        
		       boolean success=imp.updateUser(user1);
		       
		       if(success) {
		    	   JOptionPane.showMessageDialog(EditUserForm.this, "User updated successfully");
		    	   dispose();
		       }else {
		    	   JOptionPane.showMessageDialog(EditUserForm.this, "Failed to update");
		       }
		        
		     
		        
		        
				
			}
		});
        add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(170, 350, 100, 40);
        deleteButton.setFont(buttonFont);
        deleteButton.setBackground(new Color(244, 67, 54));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 int confirm = JOptionPane.showConfirmDialog(
				            EditUserForm.this, 
				            "Are you sure you want to delete this user?", 
				            "Confirm Delete", 
				            JOptionPane.YES_NO_OPTION
				        );
				        
				        if (confirm == JOptionPane.YES_OPTION) {
				            OperationsImp imp = new OperationsImp();
				            imp.deleteUser(user.getId());
				            JOptionPane.showMessageDialog(EditUserForm.this, "User deleted successfully!");
				            dispose();
				        }
				
			}
		});
        add(deleteButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(290, 350, 100, 40);
        cancelButton.setFont(buttonFont);
        cancelButton.setBackground(new Color(33, 150, 243));
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(e -> dispose());
        add(cancelButton);

        setSize(450, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }



    
}