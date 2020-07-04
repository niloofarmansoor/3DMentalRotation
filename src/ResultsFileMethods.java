import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ResultsFileMethods {
	
	public void CreateResultsFile() throws IOException {

		FileWriter csvWriter = new FileWriter("result.csv");
		
		String data = "Stimuli Order File \n";
		
		BufferedWriter bw = new BufferedWriter(csvWriter);
        bw.write(data);
        bw.close();
		
	}
	
	public void writeTheColumnNames() throws IOException{

			try {
		         File f1 = new File("result.csv");
		         if(f1.exists()) {
		        	 
		        	 FileWriter fileWriter = new FileWriter("result.csv", true);
			         BufferedWriter bw = new BufferedWriter(fileWriter);
			         
			         fileWriter.append("The order of stimuli shown\n");
			         fileWriter.append("Task Type");
			         fileWriter.append(",");
			         fileWriter.append("#");
			         fileWriter.append(",");
			         fileWriter.append("Stimuli Number");
			         fileWriter.append(",");
			         fileWriter.append("Image1");
			         fileWriter.append(",");
			         fileWriter.append("Image2");
			         fileWriter.append(",");
			         fileWriter.append("Image3");
			         fileWriter.append(",");
			         fileWriter.append("Image4");
			         fileWriter.append(",");
			         fileWriter.append("Checkbox1");
			         fileWriter.append(",");
			         fileWriter.append("Checkbox2");
			         fileWriter.append(",");
			         fileWriter.append("Checkbox3");
			         fileWriter.append(",");
			         fileWriter.append("Checkbox4");
			         fileWriter.append(",");
			         fileWriter.append("StartTime");
			         fileWriter.append("\n");
			         
			         
			         bw.flush();
			         bw.close();
		         }
		      } catch(IOException e){
		    	  
		         e.printStackTrace();
		         
		      }
			
		}
	
		public void saveFinalTime(Timestamp finalTime) throws IOException {

		    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss.SSS");
			
			 try {
		         File f1 = new File("result.csv");
		         if(f1.exists()) {
		        	 FileWriter fileWriter = new FileWriter("result.csv", true);
			         BufferedWriter bw = new BufferedWriter(fileWriter);
			         
			         bw.write("End time:");
			         bw.write(",");
			         bw.write(sdf.format(finalTime));
			         bw.write("\n");
			         
			         bw.close();
			         
		         }
		      } catch(IOException e){
		         e.printStackTrace();
		      }
			
		}
		
}

