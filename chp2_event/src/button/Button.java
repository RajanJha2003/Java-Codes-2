package button;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Button extends JFrame {
	int clickCount = 0;
	
	public Button() {
		setLayout(null);
		setTitle("Button Adapter");
		// TODO Auto-generated constructor stub
		
		JButton button = new JButton("Click Me");
        button.setBounds(50, 50, 120, 30);
		add(button);
		
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clickCount++;  // Increment the click count
                System.out.println("Button clicked " + clickCount + " times");
			}
			
		});
		
		
		setSize(320, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Button();
	}

}
