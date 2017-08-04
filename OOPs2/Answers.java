/**
 * This class handles data given by User
 * 
 * @author Udit Saxena
 * 
 */
public class Answers {
	private String answer = "";

	/**
	 * Save the data entered by user
	 * 
	 * @param enteredData
	 *            - data entered by user
	 */
	protected void setAnswer(String enteredData) {
		answer += enteredData;
	}

	/**
	 * Returns the data entered by user
	 * 
	 * @return answer - contains data 
	 */
	protected String getAnswer() {

		return answer;
	}

	/**
	 * Reset the answer field to empty
	 */
	protected void reset() {
		answer = "";
	}

}
