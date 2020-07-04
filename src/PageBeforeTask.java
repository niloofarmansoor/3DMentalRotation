import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class PageBeforeTask extends JPanel {

	public PageBeforeTask() {
		
		MigLayout layout = new MigLayout("fillx", "[c]rel[grow,fill]", "[]30[]");

		setBackground(Color.WHITE);

		setLayout(layout);

		Font font = new Font("Helvetica", Font.PLAIN, 22);
	    
	    JLabel label = new JLabel("<html> <center> Now that you are familiar with the task, you can start the experiment whenever you are ready <br> <br>"
	    		+ "by clicking the Start Experiment button. </center> </html>");

	    label.setFont(font); 
	    
		add(label, "span");
		
		
	}

}
