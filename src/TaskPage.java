import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class TaskPage extends JPanel {
	
	JCheckBox checkbox1 = new JCheckBox("");
    JCheckBox checkbox2 = new JCheckBox(""); 
    JCheckBox checkbox3 = new JCheckBox(""); 
    JCheckBox checkbox4 = new JCheckBox("");

	public TaskPage(StimuliObject[] listOfObjects, int stimuliNumber, String taskType, int rowNumber) {
		
		MigLayout layout = new MigLayout("fillx", "[center]rel[grow,fill]", "[]30[]");

		setBackground(Color.BLACK);

		setLayout(layout);
		
		JPanel empty = new JPanel();
		empty.setPreferredSize(new Dimension(1000, 200));
		empty.setBackground(Color.BLACK);
		
		//define images and checkboxes
		ImageIcon originalImage;
		ImageIcon incorrectImage1;
		ImageIcon incorrectImage2;
		ImageIcon correctImage1;
		ImageIcon correctImage2;
		
		JLabel ogImageLabel = new JLabel("<html><center>Original Image</center></html>");
		JLabel text = new JLabel("<html><center>Check the check boxes under the images that match the original image.</center></html>");
		    
        checkbox1.setBounds(50,50,50,50);   
        checkbox2.setBounds(50,50,50,50);  
        checkbox3.setBounds(50,50,50,50);    
        checkbox4.setBounds(50,50,50,50);
        
        //listOfObjects.
      	//getOriginalImage()
      	//getIncorrect()
      	//getCorrect()
        
        int[] correctIndices = getTwoRandomNumbersForCorrect();
        int[] incorrectIndices = getTwoRandomNumbersForIncorrect();
      		
        originalImage = new ImageIcon(listOfObjects[stimuliNumber].getOriginalImage().getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH));
        incorrectImage1 = new ImageIcon(listOfObjects[stimuliNumber].getIncorrect()[incorrectIndices[0]].getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH));
        incorrectImage2 = new ImageIcon(listOfObjects[stimuliNumber].getIncorrect()[incorrectIndices[1]].getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH));
        correctImage1 = new ImageIcon(listOfObjects[stimuliNumber].getCorrect()[correctIndices[0]].getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH));
        correctImage2 = new ImageIcon(listOfObjects[stimuliNumber].getCorrect()[correctIndices[1]].getScaledInstance(250, 250, java.awt.Image.SCALE_SMOOTH));

        Font font = new Font("Helvetica", Font.PLAIN, 20);
        
        //shuffle the images!
        
		HashMap<String, ImageIcon> images = new HashMap<String, ImageIcon>();
		images.put("Incorrect1", incorrectImage1);
		images.put("Incorrect2", incorrectImage2);
		images.put("Correct1", correctImage1);
		images.put("Correct2", correctImage2);
		

		List<Map.Entry<String, ImageIcon>> imagesAsList = new ArrayList<Map.Entry<String, ImageIcon>>(images.entrySet());
		Collections.shuffle(imagesAsList);
        
        writeTheOrdertoFile(stimuliNumber, imagesAsList, taskType, rowNumber);
        
        JLabel originalImageLabel = new JLabel(originalImage);
        JLabel imageLabel1 = new JLabel(imagesAsList.get(0).getValue());
        JLabel imageLabel2 = new JLabel(imagesAsList.get(1).getValue());
        JLabel imageLabel3 = new JLabel(imagesAsList.get(2).getValue());
        JLabel imageLabel4 = new JLabel(imagesAsList.get(3).getValue());
        
        
        add(empty, "span");
        add(text, "span");
        add(originalImageLabel);
        add(imageLabel1);
        add(imageLabel2);
        add(imageLabel3);
        add(imageLabel4, "wrap");
        add(ogImageLabel);
        add(checkbox1 , "gapleft 125");
        add(checkbox2, "gapleft 125");
        add(checkbox3, "gapleft 125");
        add(checkbox4, "wrap, gapleft 125");
        

        ogImageLabel.setFont(font); 
        ogImageLabel.setForeground(Color.WHITE);
        text.setFont(font); 
        text.setForeground(Color.WHITE);
        
	}


	private int[] getTwoRandomNumbersForCorrect() {
		
		int[] correctIndices = new int[2];
		
		ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i = 0; i < 3 ; i++) {
	            list.add(i);
	        }
	        Collections.shuffle(list);
	        for (int i = 0; i < 2; i++) {
	            correctIndices[i] = list.get(i);
	        }
	        
		return correctIndices;
		
	}

	private int[] getTwoRandomNumbersForIncorrect() {
		
		int[] incorrectIndices = new int[2];
		

		ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i = 0; i < 4 ; i++) {
	            list.add(i);
	        }
	        Collections.shuffle(list);
	        for (int i = 0; i < 2; i++) {
	        	incorrectIndices[i] = list.get(i);
	        }
		
		return incorrectIndices;
		
	}
	
	private void writeTheOrdertoFile(int stimuliNumber, List<Entry<String, ImageIcon>> imagesAsList, String taskType, int rowNumber) {

	      try {
	         File f1 = new File("result.csv");
	         if(f1.exists()) {
	        	 FileWriter fileWriter = new FileWriter("result.csv", true);
		         BufferedWriter bw = new BufferedWriter(fileWriter);
		         
		         bw.write(taskType);
		         bw.write(",");
		         bw.write(String.valueOf(rowNumber));
		         bw.write(",");
		         bw.write(String.valueOf(stimuliNumber+1));
		         bw.write(",");
		         
		         for (Map.Entry<String, ImageIcon> image: imagesAsList) {
		        	 
			         bw.write(image.getKey());
			         bw.write(",");
		         }
		         
		         
		         bw.close();
		         
	         }
	      } catch(IOException e){
	         e.printStackTrace();
	      }
		
	}

	public void saveCheckBoxStates() {
		
		boolean[] checkBoxStates = new boolean[4];
		
		checkBoxStates[0] = checkbox1.isSelected();
		checkBoxStates[1] = checkbox2.isSelected();
		checkBoxStates[2] = checkbox3.isSelected();
		checkBoxStates[3] = checkbox4.isSelected();
		
		 try {
	         File f1 = new File("result.csv");
	         if(f1.exists()) {
	        	 FileWriter fileWriter = new FileWriter("result.csv", true);
		         BufferedWriter bw = new BufferedWriter(fileWriter);
		         
		         for (int j = 0; j < 4; j++) {
		        	 bw.write(Boolean.toString(checkBoxStates[j]));
			         bw.write(",");
		         }
		         
		         bw.close();
		         
	         }
	      } catch(IOException e){
	         e.printStackTrace();
	      }
		
	}
     
	
	public void saveTimeStamps(Timestamp startTime) {
		
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");
		
		 try {
	         File f1 = new File("result.csv");
	         if(f1.exists()) {
	        	 FileWriter fileWriter = new FileWriter("result.csv", true);
		         BufferedWriter bw = new BufferedWriter(fileWriter);
		         
		         bw.write(sdf.format(startTime));
		         bw.write("\n");
		         
		         bw.close();
		         
	         }
	      } catch(IOException e){
	         e.printStackTrace();
	      }
		
	}

	public Timestamp saveGenerateTime() {

		Date date = new Date();
		Timestamp startTimeStamp = new Timestamp(date.getTime());
		return startTimeStamp;
	}
}
