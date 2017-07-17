/**
 * SecondPyramid Class generates a top-down pyramid. 
 * 12345
 *  1234
 *   123
 *    12
 *     1
 * 
 * @author Udit Saxena
 * 
 */

public class SecondPyramid {
	/**
	 * Prints space corresponding to each row.
	 * 
	 * @param row
	 *            - row number starting from 0
	 * @return space - String containing spaces.
	 */
	String printSpaces(int row) {
		// Error handling
		if (row < 1 || row > 9) {
			return "Error";
		}
		String space = "";
		for (int i = 1; i < row; i++) {
			space += " ";
		}
		return space; // return space in String format
	}

	/**
	 * Prints numbers corresponding to each row.
	 * 
	 ** @param row
	 *            - row number starting from 1
	 * @param n
	 *            - maximum number upto pyramid print
	 * @return number - String containing numbers.
	 */
	String printNumber(int row, int n) {
		// Error handling
		if (row < 1 || n < 1 || n > 9 || row > n) {
			return "Error";
		}
		String num = "";
		for (int j = 1; j <= n - row + 1; j++) {
			num += j;
		}
		return num; // return number in string format
	}

	/**
	 * Prints the whole pyramid.
	 * 
	 * @param n
	 * @return String array representing the pyramid.
	 */

	String[] printPyramid(int n) {
		// error handling
		if (n < 1 || n > 9) {
			return new String[] { "Enter number between 1 to 9" };
		}
		// output array
		String result[] = new String[n];
		for (int row = 0; row < n; row++) {
			result[row] = printSpaces(row + 1) + printNumber(row + 1, n);
		}
		return result; // return string array contains pyramid
	}

}
