package ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.List;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.User;
import operationsImp.OperationsImp;

public class AllUsers extends JFrame {
	
	DefaultTableModel tableModel;
	JTable resultTable;
	
	public AllUsers() {
        setTitle("All Users");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); // Using absolute positioning
        
        String[] columnNames = {"ID", "Username", "Email", "Phone", "Gender", "City", "Edit", "Delete"};
        tableModel=new DefaultTableModel(columnNames,0);
        resultTable=new JTable(tableModel);
        
        JScrollPane tableScrollPane = new JScrollPane(resultTable);
        tableScrollPane.setBounds(20, 70, 450, 250);
        add(tableScrollPane);
        
        laodData();
        
        
       resultTable.addMouseListener(new MouseAdapter() {
    	   @Override
    	public void mouseClicked(MouseEvent e) {
    		   int row = resultTable.rowAtPoint(e.getPoint());
               int col = resultTable.columnAtPoint(e.getPoint());

               if (col == 7) { // Delete column
                   int id = (int) tableModel.getValueAt(row, 0);
                   int confirm = JOptionPane.showConfirmDialog(
                           AllUsers.this,
                           "Are you sure you want to delete this user?",
                           "Confirm Deletion",
                           JOptionPane.YES_NO_OPTION
                   );

                   if (confirm == JOptionPane.YES_OPTION) {
                       OperationsImp imp = new OperationsImp();
                       boolean success = imp.deleteUser(id);
                       if (success) {
                           tableModel.removeRow(row); // Remove row from table
                           JOptionPane.showMessageDialog(AllUsers.this, "User deleted successfully.");
                       } else {
                           JOptionPane.showMessageDialog(AllUsers.this, "Failed to delete user.");
                       }
                   }
               }else if (col == 6) { // Edit column
                   int id = (int) tableModel.getValueAt(row, 0);
                   OperationsImp imp = new OperationsImp();
                   User user = imp.getUserById(id);
                   new UpdateUserForm(user, AllUsers.this, row);
               }
    	}
	});
        setVisible(true);
	}
	
	public void laodData() {
		OperationsImp imp=new OperationsImp();
		List<User> list=imp.getAllUsers();
		
		
		for(User user:list) {
			
            Object[] rawData = {
            	    user.getId(),
            	    user.getUsername(),
            	    user.getEmail(),
            	    user.getPhone(),
            	    user.getGender(),
            	    user.getCity(),
            	    "✍️",  
            	    "❌"   
            	};

			tableModel.addRow(rawData);
		}
		
	}
   public static void main(String[] args) {
	new AllUsers();
}
}