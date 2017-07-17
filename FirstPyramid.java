/**
 * FirstPyramid Class generates a diamond composed of one normal pyramid and one
 * inverted pyramid. 
 *     1
 *    121
 *   12321 
 *  1234321
 * 	 12321
 * 	  121
 * 	   1
 * 
 * @author Udit Saxena
 */
public class FirstPyramid {

	/**
	 * Prints the spaces corresponding to each row.
	 * 
	 * @param row
	 *            - row number starting from 0
	 * @param n
	 *            - maximum number upto pyramid print
	 * @return space - String containing spaces.
	 */
	public String returnSpaces(int row, int n) {
		// error handling
		if (row < 0 || n < 1 || n > 9 || row > 2 * n) // Error handling
		{
			return "Error";
		}
		String space = "";
		// Spaces for top-down pyramid
		if (row < n) {

			for (int i = 0; i < n - row - 1; i++) {
				space = space + " ";
			}
		}
		// Spaces for bottom-up pyramid
		else if (row > n) {

			for (int i = row; i > n; i--) {
				space = space + " ";
			}
		}
		return space;
	}

	/**
	 * Prints the numbers corresponding to each row.
	 * 
	 * @param row
	 *            - row number starting from 0
	 * @param n
	 *            - maximum number upto pyramid print
	 * @return number - String containing numbers.
	 */
	public String returnNumbers(int row, int n) {
		// error handling
		if (row < 0 || n < 1 || n > 9 || row > (2 * n)) // Error handling
		{
			return "Error";
		}
		String number = "";
		int increasingNumber = 0;
		int decreasingNumber;
		// Numbers for top-down pyramid
		if (row < n) {
			// increasing sequence
			for (increasingNumber = 0; increasingNumber <= row; increasingNumber++) {
				number = number + (increasingNumber + 1);
			}
			// decreasing sequence
			for (decreasingNumber = increasingNumber - 1; decreasingNumber > 0; decreasingNumber--) {
				number = number + decreasingNumber;
			}
			// Numbers for bottom-up pyramid
		} else {
			// increasing sequence
			for (increasingNumber = 0; increasingNumber <= 2 * n - row; increasingNumber++) {
				number = number + (increasingNumber + 1);
			}
			// decreasing sequence
			for (decreasingNumber = increasingNumber - 1; decreasingNumber > 0; decreasingNumber--) {
				number = number + decreasingNumber;
			}
		}
		return number;
	}

	/**
	 * Prints the whole pyramid composed of top-down and bottom-up pyramid.
	 * 
	 * @param n
	 *            - maximum number upto pyramid print
	 * @return String array representing both pyramids.
	 */
	public String[] printPyramid(int n) {
		// error handling
		if (n > 9 || n < 1) {
			return new String[] { "Enter number between 1 to 9" };
		}
		String[] result = new String[2 * n - 1];

		// Prints Top-down Pyramid
		for (int i = 0; i < n; i++) {
			result[i] = returnSpaces(i, n) + returnNumbers(i, n)
					+ returnSpaces(i, n);
		}

		// Prints Bottom-Up Pyramid
		for (int i = n; i < 2 * n - 1; i++) {
			result[i] = returnSpaces(i + 1, n) + returnNumbers(i + 2, n)
					+ returnSpaces(i + 1, n);
		}
		return result;
	}

}
