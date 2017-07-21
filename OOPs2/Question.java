import java.io.*;
import java.util.*;

/**
 * @author Udit Saxena
 *	
 */
public class Question implements Comparable<Question> {
	String str;

	public Question() {

	}

	public Question(String str) {
		this.str = str;
	}

	Scanner scan = new Scanner(System.in);

	/**
	 * @param filePath has the file from which we have to read data
	 * @return the 2D array of strings which contains the content of the file
	 * 
	 */
	public String[][] read(String filePath) {
		String questions[][] = new String[5][];
		int index = 0;
		try {
			FileInputStream fstream = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String str = "";
			// Read File Line By Line
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
	 * @param participant will give the index of the participant
	 * @param question will take the 2D array of question
	 */
	public void getInput(int participant, String question[][]) {

		for (int index = 0; index < question.length; index++) {
			for (int jindex = 0; jindex < question[index].length; jindex++) {
				System.out.println(question[index][jindex]);
			}
			if ("(Type) Single Select".equals(question[index][1])) {
				int answer = scan.nextInt();
				while (answer != 1 && answer != 2 && answer != 3 && answer != 4
						&& answer != 5) {
					System.out.print("Enter correct option from 1 to 5");
					answer = scan.nextInt();
				}
				write("Participant" + " " + participant + "," + answer,
						"C:/Users/User7/Desktop/Report-B.txt");
			} else if ("(Type) Multi Select".equals(question[index][1])) {
				String answer = scan.next();
				write("," + answer, "C:/Users/User7/Desktop/Report-B.txt");
			} else if ("(Type)Text".equals(question[index][1])) {
				String answer = scan.next();
				write("," + answer, "C:/Users/User7/Desktop/Report-B.txt");
			} else if ("(Type) Number".equals(question[index][1])) {
				long answer = scan.nextLong();
				while (String.valueOf(answer).length() != 10) {
					System.out.print("Enter 10 digit number");
					answer = scan.nextLong();
				}
				write("," + answer, "C:/Users/User7/Desktop/Report-B.txt");
			}
		}
		write("-1", "C:/Users/User7/Desktop/Report-B.txt");
	}

	/**
	 * @param text is the content that need to be printed in file 
	 * @param filePath is the file which we need to add content
	 * 
	 */
	public void write(String text, String filePath) {
		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
					filePath), true));
			if (text.equals("-1")) {
				bw.newLine();
			} else {
				bw.write(text);
			}
			bw.close();
		} catch (Exception e) {
		}
	}

	public int compareTo(Question o) {

		return str.compareTo(o.str);
	}

}