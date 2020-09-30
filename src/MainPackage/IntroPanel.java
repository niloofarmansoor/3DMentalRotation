package MainPackage;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


public class IntroPanel extends JPanel {
	
	public IntroPanel() {
		
		
		MigLayout layout = new MigLayout("fillx", "[c]rel[grow,fill]", "[]30[]");

		setBackground(Color.WHITE);

		setLayout(layout);

		Font font = new Font("Helvetica", Font.PLAIN, 24);

		JLabel welcomeMessage = new JLabel("Welcome");
	    JLabel welcomeMessage2 = new JLabel("This experiment will take at most 15 minutes.");
	    JLabel welcomeMessage3 = new JLabel("Click the start button to start the experiment.");
	    
	    welcomeMessage.setFont(font);
	    welcomeMessage2.setFont(font);
	    welcomeMessage3.setFont(font);
	    
	    
		add(welcomeMessage, "span");
		add(welcomeMessage2, "span");
		add(welcomeMessage3, "span");
		
		
		setFont(new java.awt.Font("Helvetica", 2, 50));

		
	
	}
	
}
