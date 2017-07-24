import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Questions implements Comparable<Questions> {
	String str;

	// default constructor
	public Questions() {

	}

	/**
	 * Initializing str 
	 * @param str - String containing question
	 */
	public Questions(String str) {
		this.str = str;
	}

	// Implements Comparable.compareTo
	// Compares the questions from question object
	public int compareTo(Questions o) {

		return str.compareTo(o.str);
	}

	/**
	 * Read the questions file and return its details
	 * 
	 * @param filePath
	 *            - location of Questions text file
	 * @return questions details
	 */
	protected String[][] getQuestionDetails(String filePath) {

		return new FileHandling().read(filePath);
	}

	/**
	 * Returns Question
	 * 
	 * @param question
	 *            - question details
	 * @param index
	 *            - index of question
	 * @return String - contains question
	 */
	protected String getQuestion(String[][] question, int index) {

		return question[index][0];
	}

	/**
	 * Returns which type of question is
	 * 
	 * @param question
	 *            - question details
	 * @param index
	 *            - index of question
	 * @return String - question's type
	 */
	protected String getType(String[][] question, int index) {

		return question[index][1];
	}

	/**
	 * Return options of that Question
	 * 
	 * @param question
	 *            - question details
	 * @param index
	 *            - index of question
	 * @return String - Options of that question
	 */
	protected String getOption(String[][] question, int index) {

		return question[index][2];
	}

	/**
	 * CHecking whether the option entered by user is valid or not
	 * 
	 * @param givenOptions
	 *            - Option available for user
	 * @param enteredOption
	 *            - Option or Options entered by user
	 * @return boolean - true if valid else false
	 */
	protected boolean isValidOption(String givenOptions, String enteredOption) {
		String[] enteredValue = enteredOption.split(",");
		List<String> checkList = new ArrayList<String>();
		String[] option = givenOptions.split("/");
		List<String> n = Arrays.asList(option);
		checkList.addAll(n);
		if (checkList.size() < enteredValue.length) {
			return false;
		}
		for (int i = 0; i < enteredValue.length; i++) {
			if (!checkList.contains(enteredValue[i])) {
				return false;
			}
		}

		return true;
	}
}
