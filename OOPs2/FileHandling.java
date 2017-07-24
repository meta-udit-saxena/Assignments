import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 * Handles the file read ,Write and count Lines Operations
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
	 * @return the 2D array of strings which contains the content of the file
	 * 
	 */
	protected String[][] read(String filePath) {
		int count = countLines(filePath);
		String[][] questions = new String[count][];
		int index = 0;
		try {
			FileInputStream fStream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					fStream));
			String str = "";
			while ((str = br.readLine()) != null) {
				questions[index++] = str.split(",");
			}
			br.close();
			return questions;
		} catch (Exception e) {
			return questions;
		}
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
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					filePath), true));
			if (surveyDetails.equals("-1")) {
				bw.newLine();
			} else {
				bw.write(surveyDetails);
			}
			bw.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Counts the number of lines from the file
	 * 
	 * @param filePath
	 *            - has the location of file
	 * @return count has total number of lines
	 */
	protected int countLines(String filePath) {
		LineNumberReader reader;
		try {
			reader = new LineNumberReader(new FileReader(filePath));
			int count = 0;
			while ((reader.readLine()) != null) {
			}
			count = reader.getLineNumber();
			reader.close();
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
