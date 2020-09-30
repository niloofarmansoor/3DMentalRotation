package MainPackage;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StimuliObject {

	protected FilenameFilter filter = new FilenameFilter() { 
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(".jpg");
		} 
	};
	
	protected int stimuliID;
	private BufferedImage originalImage;
	private BufferedImage[] incorrect = new BufferedImage[4]; //initialized as the # of incorrect rotations
	private BufferedImage[] correct = new BufferedImage[3];; //initialized as the # of correct rotations
	
	public StimuliObject(int stimuliID) throws IOException {
		this.stimuliID = stimuliID;
		setOriginalImage(originalImage, stimuliID);
		setIncorrect(incorrect, stimuliID);
		setCorrect(correct, stimuliID);
	}

	public void setOriginalImage(BufferedImage originalImage, int ID) throws IOException {
		
		//Original image
		String file_address = String.format(
				"/stimuli/" + "%d/" + "%d" + "_original.jpg", ID, ID);
		try {
		
		this.originalImage = ImageIO.read(StimuliObject.class.getResource(file_address));}
		
		catch (Exception e){
			System.out.println("unable to locate: "+ file_address);
		}
		
		
	}
	
	public void setIncorrect(BufferedImage[] incorrect, int ID) throws IOException {
	
		//Directory of the incorrect stimuli
/*		final File dirIncorrect = new File(String.format("stimuli/%d/incorrect", ID));

		if (dirIncorrect.isDirectory()) {
			int i = 0;
			for (final File file: dirIncorrect.listFiles(filter)) {
				incorrect[i] = ImageIO.read(getClass().getResourceAsStream(file));
				i++;
			}
		}
*/
		
		String file_address = String.format(
				"/stimuli/" + "%d/" + "incorrect/", ID);
	
		
		try {
			
			incorrect[0] = ImageIO.read(StimuliObject.class.getResource(file_address + ID + "_0_R.jpg"));
			incorrect[1] = ImageIO.read(StimuliObject.class.getResource(file_address + ID + "_50_R.jpg"));
			incorrect[2] = ImageIO.read(StimuliObject.class.getResource(file_address + ID + "_100_R.jpg"));
			incorrect[3] = ImageIO.read(StimuliObject.class.getResource(file_address + ID + "_150_R.jpg"));
			
		}
		catch (Exception e){
				System.out.println("unable to locate: "+ file_address);
		}

		
	}
	
	public void setCorrect(BufferedImage[] correct, int ID) throws IOException {
		
//		//Directory of the correct stimuli
//		final File dirCorrect = new File(String.format("stimuli/%d/correct", ID));
//
//		if (dirCorrect.isDirectory()) {
//			int j = 0;
//			for (final File file: dirCorrect.listFiles(filter)) {
//				correct[j] = ImageIO.read(file);
//				j++;
//			}
//		}

		String file_address = String.format(
				"/stimuli/" + "%d/" + "correct/", ID);
				
		try {
			
		correct[0] = ImageIO.read(StimuliObject.class.getResource(file_address + ID + "_50.jpg"));
		correct[1] = ImageIO.read(StimuliObject.class.getResource(file_address + ID + "_100.jpg"));
		correct[2] = ImageIO.read(StimuliObject.class.getResource(file_address + ID + "_150.jpg"));
		}
		catch (Exception e){
			System.out.println("unable to locate files in "+ file_address);
		}
		
	}

	public BufferedImage getOriginalImage() {
		return originalImage;
	}

	public BufferedImage[] getIncorrect() {
		return incorrect;
	}

	public BufferedImage[] getCorrect() {
		return correct;
	}


}