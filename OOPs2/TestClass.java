import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class TestClass {
	Answers answer;
	Questions question;
	FileHandling fileOperations;

	@Before
	public void setUpObject() {
		answer = new Answers();
		question = new Questions();
		fileOperations = new FileHandling();
	}

	@Test
	public void answersClassHappyTestCases() {
		answer.setAnswer("Udit");
		answer.setAnswer("Saxena");
		String actual = answer.getAnswer();
		String expected = "UditSaxena";
		assertEquals(expected, actual);
	}

	//
	@Test
	public void quentionsClassIsValidOptionHappyTestCasesForSingleSelect() {
		boolean actual = question.isValidOption("1/2/3/4/5", "1");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void fileHandlingClassReadFilenHappyTestCasesForSingleSelect() {
		String[][] actual = fileOperations
				.read("C:/Users/User27/workspace/OOPs2/src/Questions.txt");
		String[][] expected = {
				{ "Q1. Enter your Name-", "Text" },
				{ "Q2. Enter your Contact No-", "Number" },
				{ "Q3. Overall Rating of Service-", "Single Select","1/2/3/4/5" },
				{ "Q4. Area of improvement ?", "Multi Select","Service Quality/Communication/Delivery Process" },
				{ "Q5. Feedback ?", "Text" }};
		assertArrayEquals(expected, actual);
	}

	// Counting number of questions available in Question.txt
	@Test
	public void fileHandlingClassCountLinesHappyTestCasesForSingleSelect() {
		int actual = fileOperations
				.countLines("C:/Users/User27/workspace/OOPs2/src/Questions.txt");
		int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	public void quentionsClassIsValidOptionHappyTestCasesForMultiSelect() {
		boolean actual = question.isValidOption(
				"Service Quality/Communication/Delivery Process",
				"Service Quality,Communication");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	/*
	 * Negative test Cases
	 */
	@Test
	public void quentionsClassIsValidOptionNegativeTestCasesWhenInvalidOptionEnteredForSingleSelect() {
		boolean actual = question.isValidOption("1/2/3/4/5", "7");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void quentionsClassIsValidOptionNegativeTestCasesWhenInvalidOptionEnteredForMultiSelect() {
		boolean actual = question.isValidOption(
				"Service Quality/Communication/Delivery Process", "ABC,XYZ");
		boolean expected = false;
		assertEquals(expected, actual);
	}
}
