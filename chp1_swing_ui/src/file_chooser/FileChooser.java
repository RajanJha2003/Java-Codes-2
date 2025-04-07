package file_chooser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileChooser extends JFrame {
	JButton fileButton;
	
	public FileChooser() {
		setTitle("File");
		
		setSize(400,300);
		setLayout(null);
		
		fileButton=new JButton("Open file");
		fileButton.setBounds(130,70,120,30);
		
		
		add(fileButton);
		
		
		fileButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
               JFileChooser fileChooser=new JFileChooser();
               int i=fileChooser.showOpenDialog(FileChooser.this);
			
			if(i==JFileChooser.APPROVE_OPTION) {
				File selectedFile=fileChooser.getSelectedFile();
				JOptionPane.showMessageDialog(FileChooser.this, "Selected File"+selectedFile.getAbsolutePath());
			}
			}
		});
		
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		
        new FileChooser();
	}

}
