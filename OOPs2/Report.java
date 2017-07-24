import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * This class Handles Report printing
 * 
 * @author Udit Saxena
 * 
 */
public class Report extends FileHandling {

	/**
	 * Print the Report A using report B
	 * 
	 * @param reportB
	 *            - details of report B
	 * @param noOfUsers
	 *            - total number of user participate in Survey
	 * @param filePathOfA
	 *            - location of Report A
	 * @param filePathOfB
	 *            - location of Report B
	 */
	protected void printReportA(String[][] reportB, int noOfUsers,
			String filePathOfA, String filePathOfB) {
		clearRecord(filePathOfA);
		int percentage[] = new int[6];
		for (int index = 0; index < noOfUsers; index++) {
			percentage[Integer.parseInt(reportB[index][3])] += 1;
		}
		int percent;
		// will find the percentage of the result
		for (int index = 1; index < 6; index++) {
			if (percentage[index] != 0) {
				percent = (int) ((percentage[index] / (float) noOfUsers) * 100);
				write(index + " - " + percent + "%", filePathOfA);
				write("-1", filePathOfA);
			} else {
				write(index + " - " + percentage[index] + "%", filePathOfA);
				write("-1", filePathOfA);
			}
		}
	}

	/**
	 * Print the details into report B
	 * 
	 * @param details
	 *            - details to be printed
	 * @param filePath
	 *            - location of Report B
	 */
	protected void printReportB(String details, String filePath) {
		write(details, filePath);
	}

	/**
	 * Clears the Reports Data
	 * 
	 * @param filePath
	 *            - location of Report
	 */
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