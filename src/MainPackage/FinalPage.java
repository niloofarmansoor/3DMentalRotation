package MainPackage;
import java.awt.Color;
import java.awt.Font;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class FinalPage extends JPanel {
	
	public FinalPage() {
		
		MigLayout layout = new MigLayout("fillx", "[c]rel[grow,fill]", "[]30[]");

		setBackground(Color.WHITE);

		setLayout(layout);

		Font font = new Font("Helvetica", Font.PLAIN, 26);
	    
	    JLabel label = new JLabel("<html> <center> Thank you for participating!</center> </html>");

	    label.setFont(font); 
	    
		add(label, "span");
		
		
	}
	
	public Timestamp saveGenerateTime() {

		Date date = new Date();
		Timestamp startTimeStamp = new Timestamp(date.getTime());
		return startTimeStamp;
	}

}
