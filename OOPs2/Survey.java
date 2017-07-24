import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * main class which drive all the function
 * 
 * @author Udit Saxena
 * 
 **/
public class Survey {
	/**
	 * 
	 * @param args
	 *            -arguments of type string
	 */
	public static void main(String args[]) {
		Questions ques = new Questions();
		Answers ans = new Answers();
		Report print = new Report();
		FileHandling reader = new FileHandling();
		Scanner in = new Scanner(System.in);
		String question[][] = {};
		String questionFilePath = "C:/Users/User27/workspace/OOPs2/src/Questions.txt";
		String reportAPath = "C:/Users/User27/workspace/OOPs2/src/Report-A.txt";
		String reportBPath = "C:/Users/User27/workspace/OOPs2/src/Report-B.txt";
		System.out
				.println("Enter number of users to participate in survey :- ");
		int noOfUsers = in.nextInt();
		int noOfQuestions = reader.countLines(questionFilePath);
		// read all the question from Text file
		question = ques.getQuestionDetails(questionFilePath);
		in.nextLine();
		// store user's input
		String enteredValue;
		// will take inputs from all user
		for (int participant = 1; participant <= noOfUsers; participant++) {
			ans.setAnswer("Participant " + participant + ",");
			for (int index = 0; index < noOfQuestions; index++) {
				// print question
				System.out.println(ques.getQuestion(question, index));
				// print question type
				System.out.println("Hint:Type -"
						+ ques.getType(question, index));
				// print options if question is of single select or multi select
				if (question[index].length > 2) {
					System.out.println("\n" + "Options:"
							+ ques.getOption(question, index));
				}
				// condition for single select type questions
				if ("Single Select".equals(ques.getType(question, index))) {
					enteredValue = in.nextLine();
					// checking entered option is valid or not
					while (ques.isValidOption(
							ques.getOption(question, index), enteredValue) == false) {
						System.out.println("Please enter the correct option");
						enteredValue = in.nextLine();
					}
					ans.setAnswer(enteredValue + ",");
				}
				// condition for multi select type questions
				else if ("Multi Select".equals(ques.getType(question, index))) {
					System.out
							.println("Enter option in following pattern: option1,Option2,so on...");
					enteredValue = in.nextLine();
					// checking entered value is valid or not
					while (ques.isValidOption(
							ques.getOption(question, index), enteredValue) == false) {
						System.out.println("Please enter the correct option");
						enteredValue = in.nextLine();
					}
					String[] choices = enteredValue.split(",");
					for (int i = 0; i < choices.length; i++) {
						ans.setAnswer(choices[i]);
						if (i != choices.length - 1) {
							ans.setAnswer("/");
						} else {
							ans.setAnswer(",");
						}
					}
				}
				// condition for (10 digit Number) type question
				// ex-Contacts,phone no.
				else if ("Number".equals(ques.getType(question, index))) {
					long number = 0;
					do {
						System.out.println("Enter 10 digit number");
						try {
							number = in.nextLong();
						} catch (InputMismatchException e) {
						}
						in.nextLine();
					} while (String.valueOf(number).length() != 10);
					ans.setAnswer(number + ",");
				}
				//text type questions
				else {
					enteredValue=in.nextLine();
					while(enteredValue.length()==0){
						System.out.println("Enter data This field is mandantory");
						enteredValue=in.nextLine();
					}
					ans.setAnswer(enteredValue);
					if (index != 4) {
						ans.setAnswer(",");
					}
				}
			}
			// print report B
			print.printReportB(ans.getAnswer(), reportBPath);
			String[][] reportB = reader.read(reportBPath);
			// print report A
			print.printReportA(reportB, reportB.length, reportAPath,
					reportBPath);
			// reseting the ans data of answer class
			ans.reset();
			// "-1" for next line
			print.printReportB("-1", reportBPath);
			
		}
		/**
		 * for part B problem in which we have to sort the given question
		 * 
		 */
		question = reader.read(questionFilePath);
		List<Questions> list = new ArrayList<Questions>();
		for (int index = 0; index < question.length; index++) {
			list.add(new Questions(question[index][0]));
		}
		Collections.sort(list);
		Iterator<Questions> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().str);
		}
		in.close();
	}
}