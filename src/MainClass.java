import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainClass {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				
				//process all the pictures
				StimuliObject[] listOfObjects = ProcessPictures();
				
				try {
					ResultsFileMethods rfm = new ResultsFileMethods();
					rfm.CreateResultsFile();
					
					JFrame frame = new FirstPage("Task Main Window", listOfObjects);
					
					//make full screen
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
					
				} catch (IOException e) {
					e.printStackTrace();
				}

				
			}

			private StimuliObject[] ProcessPictures() {
				
				StimuliObject[] listOfObjects = new StimuliObject[48];
								
				for (int i = 1; i < 49; i++) {
					
					try {
						StimuliObject current = new StimuliObject(i);
						listOfObjects[i-1] = current;
					} catch (IOException e) {
						System.out.println("No file");
						//e.printStackTrace();
					}
					
				}
				
				return listOfObjects;
				
			}
			
			
			
		});

	}

}
