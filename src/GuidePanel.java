import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class GuidePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GuidePanel() {
		
		MigLayout layout = new MigLayout("fillx", "[c]rel[grow,fill]", "[]30[]");

		setBackground(Color.WHITE);

		setLayout(layout);

		Font font = new Font("Helvetica", Font.PLAIN, 22);

	    
	    JLabel label = new JLabel("<html> <center> For each task in this experiment, you will see an image of a 3D object on the left side of the screen. <br><br> "
	    		+ "There will be four different images on the left side, and you will choose the ones that are of <br><br>"
	    		+ "the same 3D object using the checkmarks below the images. This is a timed experiment, <br> <br>"
	    	    + "and the duration of each task will be recorded. You have 1 minute to choose the images <br><br>"
	    		+ " for each task, but we encourage you to make your choices as soon as you can. <br><br>"
	    	    + "Click the Next button to do 2 sample tasks. </center> </html>");

	    
	    label.setFont(font); 
	    
		add(label, "span");
		
		
	}

}
