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
				"stimuli/" + "%d/" + "%d" + "_original.jpg", ID, ID);
		
		this.originalImage = ImageIO.read(
			new File(file_address));
	}
	
	public void setIncorrect(BufferedImage[] incorrect, int ID) throws IOException {
	
		//Directory of the incorrect stimuli
		final File dirIncorrect = new File(String.format("stimuli/%d/incorrect", ID));

		if (dirIncorrect.isDirectory()) {
			int i = 0;
			for (final File file: dirIncorrect.listFiles(filter)) {
				incorrect[i] = ImageIO.read(file);
				i++;
			}
		}
	}
	
	public void setCorrect(BufferedImage[] correct, int ID) throws IOException {
		
		//Directory of the correct stimuli
		final File dirCorrect = new File(String.format("stimuli/%d/correct", ID));

		if (dirCorrect.isDirectory()) {
			int j = 0;
			for (final File file: dirCorrect.listFiles(filter)) {
				correct[j] = ImageIO.read(file);
				j++;
			}
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