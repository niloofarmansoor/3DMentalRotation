package MainPackage;
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

		Font font = new Font("Helvetica", Font.PLAIN, 24);

	    
	    JLabel label = new JLabel("<html> For each task in this experiment, you will see an image of a 3D object on the left side<br><br> "
	    		+ "of the screen that is labeled \"Original Image\". There will be four different images on <br><br>"
	    		+ "the right side, and you will choose the ones that are of the same 3D object by checking <br><br>"
	    	    + "the checkmarks below the images. The duration of each task that you do will be recorded. <br><br>"
	    		+ "For each task, but we encourage you to make your choices as quickly as you can. <br><br>"
	    	    + "Click the Next button to do 5 sample tasks.  </html>");

	    
	    label.setFont(font); 
	    
		add(label, "span");
		
		
	}

}
