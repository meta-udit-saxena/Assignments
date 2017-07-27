package ShoppingStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the file read & Write Operations
 * 
 * @author Udit Saxena
 * 
 */
class FileHandling {


	/**
	 * Read file
	 * 
	 * @param filePath
	 *            - has the location of file from which we have to read data
	 * @return the List of strings which contains the content of the file
	 * 
	 */
	protected List<String> read(String filePath) {
		List<String> l = new ArrayList<String>();
		try {
			l = Files.readAllLines(Paths.get(filePath));
		} catch (IOException e) {
		}
		return l;

	}

	/**
	 * Write File on its location
	 * 
	 * @param surveyDetails
	 *            - is the content that need to be printed in file
	 * @param filePath
	 *            - is the location of file which we need to add content
	 * 
	 */
	protected void write(String surveyDetails, String filePath) {
		try {
			clearRecord(filePath+"'s bill.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					filePath+"'s bill.txt"), true));
				bw.write(surveyDetails);
			bw.close();
		} catch (Exception e) {
		}
	}
	protected void clearRecord(String filePath) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(filePath);
			writer.print("");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
