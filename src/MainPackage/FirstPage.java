package MainPackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FirstPage extends JFrame {
	
	//private TestTask testTask;
	
	//for test tasks
	int countTest = 5;
	int count = 0;
	
	//for taks
	int stimuliNumber = 0;
	int order = 0;
	int numberOfTasksToDo = 20;

	TaskPage taskPage = null;
    Timestamp startTimeStamp = null;
    Timestamp endTimeStamp = null;
    Date date = new Date();
    ArrayList<Integer> stimuli = new ArrayList<Integer>();
	
	int proceedToNextTask = 2;
    
	public FirstPage(String title, StimuliObject[] listOfObjects) throws IOException {
		
		super(title);
		
		//set layout manage
		//how to arrange
		setLayout(new BorderLayout());
		
		ResultsFileMethods rfm = new ResultsFileMethods();
		
		rfm.writeTheColumnNames();
		
		//show intro panel
		
		IntroPanel introPanel = new IntroPanel();
		
		JButton startButton = new JButton("Start");
		
		//create swing component
		//add swing component to its content pane
		
	    JPanel empty = new JPanel();
	    empty.setPreferredSize(new Dimension(500, 300));
	    empty.setBackground(Color.WHITE);

		Container c = getContentPane();
		c.add(empty,BorderLayout.PAGE_START);
		c.add(introPanel, BorderLayout.CENTER);
		c.add(startButton, BorderLayout.SOUTH);
		
		//Show guide panel

		GuidePanel guidePanel = new GuidePanel();
		
		JButton nextButton = new JButton("Next");
		
		
		//Show guide
		
		PageBeforeTask pageBeforeTask = new PageBeforeTask();
		
		JButton nextButton2 = new JButton("Start Experiment");
		
		//Generate a new task
		JButton EXIT = new JButton("Exit");
		
		//Show correct answers button
		
		//populate stimuli number list
		for (int k = 0; k < 43; k++) {
			stimuli.add(k+5);
		}
			
		//add behavior
		startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				introPanel.setVisible(false);
				startButton.setVisible(false);
				
				c.add(guidePanel, BorderLayout.CENTER);
				c.add(nextButton, BorderLayout.SOUTH);
			}	
		});
		

		
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				empty.setVisible(false);
				guidePanel.setVisible(false);
				
				//at the start of each task starting from second task,
				//see how many checkboxes were selected in the previous task
				if (count > 0) {
					proceedToNextTask = TaskPage.countCheckedCheckboxes(taskPage);
				}
				
				//if 2 were selected, generate new tasks.
				if (proceedToNextTask == 2) {
					
					if (taskPage != null) {
						taskPage.saveCheckBoxStates();
						taskPage.saveTimeStamps(startTimeStamp);
					}
				
					if (countTest == 0) {
						
						empty.setVisible(true);
						
						taskPage.setVisible(false);
						taskPage = null;
	
						nextButton.setVisible(false);
						
						c.add(pageBeforeTask, BorderLayout.CENTER);
						c.add(nextButton2, BorderLayout.SOUTH);
						
					}else {
						
						if (taskPage != null) {
							taskPage.setVisible(false);
						}
							
						taskPage = new TaskPage(listOfObjects, count, "TestTask", count+1);		
						startTimeStamp = taskPage.saveGenerateTime();
						
						c.add(taskPage, BorderLayout.CENTER);
												
						count++;
							
						countTest--;
						
					}
				} else { //if anything other than two was selected, don't go to next page.
					
					JOptionPane.showMessageDialog(null,
						    "You must select two checkboxes that correspond with the two correct images.",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					
				}

					
				}
				
		});
		
		proceedToNextTask = 2;
		
		nextButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				empty.setVisible(false);
				pageBeforeTask.setVisible(false);
				nextButton2.setText("Next");
				
				if (order > 0) {
					proceedToNextTask = TaskPage.countCheckedCheckboxes(taskPage);
				}
				
				if (proceedToNextTask == 2) {
					
					if (taskPage != null) {
						
						taskPage.saveCheckBoxStates();
						taskPage.saveTimeStamps(startTimeStamp);
						
					}
					
					if (numberOfTasksToDo == 0) {
	
						empty.setVisible(true);
						
						taskPage.setVisible(false);
	
						FinalPage finalPage = new FinalPage();
						
						endTimeStamp = finalPage.saveGenerateTime();
						
						
						ResultsFileMethods rfm = new ResultsFileMethods();
						try {
							rfm.saveFinalTime(endTimeStamp);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						c.add(finalPage, BorderLayout.CENTER);
						c.add(EXIT, BorderLayout.SOUTH);
	
						nextButton2.setVisible(false);
	
						
					}else {
						
						if (taskPage != null) {
							taskPage.setVisible(false);
						}
						
						stimuliNumber = PickARandomTask(stimuli);
						
						taskPage = new TaskPage(listOfObjects, stimuliNumber, "Task", order+1);		
						startTimeStamp = taskPage.saveGenerateTime();
							
						c.add(taskPage, BorderLayout.CENTER);
						order++;;
						numberOfTasksToDo--;
					}
				} else { //if anything other than two was selected, don't go to next page.
					
					JOptionPane.showMessageDialog(null,
						    "You must select two checkboxes that correspond with the two correct images.",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
					
				}
				
				
				}
			
		});
		
		EXIT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		
		
	}
	
	public int PickARandomTask(ArrayList<Integer> stimuli) {
		
		Collections.shuffle(stimuli);
		
		int randomPicked = stimuli.get(0);
		
		stimuli.remove(0);
		
		return randomPicked;
		
	}
}






