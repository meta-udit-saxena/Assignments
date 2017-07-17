/**
 * FirstPyramid Class generates a diamond composed of one normal pyramid and one
 * inverted pyramid.
 *    1
 *   121
 *  12321
 * 1234321
 *  12321
 *   121
 *    1
 * @author Udit Saxena
 */
public class FirstPyramid {

	/**
	 * Prints the spaces corresponding to each row.
	 * 
	 * @param row
	 * @param n
	 * @return String containing spaces.
	 */
	public String spaces(int row, int n) {
		if(row<0||n<1||n>9||row>2*n) // Error handling 
		{
			return "Error";
		}
		String space = "";

		if (row < n) {
			// Spaces for top-down pyramid
			for (int i = 0; i < n - row - 1; i++) {
				space = space + " ";
			}
		} else if (row > n) {
			// Spaces for bottom-up pyramid
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
	 * @param n
	 * @return String containing numbers.
	 */
	public String numbers(int row, int n) {
		if(row<0||n<1||n>9||row>(2*n)) // Error handling 
		{
			return "Error";
		}
		String number = "";
		int increasingNumber = 0;
		int decreasingNumber;
		if (row < n) {
			// Numbers for top-down pyramid
			for (increasingNumber = 0; increasingNumber <= row; increasingNumber++) {
				number = number+(increasingNumber + 1);	// Numbers for increasing sequence
			}

			for (decreasingNumber = increasingNumber - 1; decreasingNumber > 0; decreasingNumber--) {
				number = number + decreasingNumber; 	// Numbers for decreasing sequence
			}
		} 
		else {
			// Numbers for bottom-up pyramid
			for (increasingNumber = 0; increasingNumber <= 2 * n - row; increasingNumber++) {
				number = number + (increasingNumber + 1);// Numbers for increasing sequence
			}

			for (decreasingNumber = increasingNumber - 1; decreasingNumber > 0; decreasingNumber--) {
				number = number + decreasingNumber;// Numbers for decreasing sequence
			}

		}
		return number;

	}

	/**
	 * Prints the whole pyramid composed of top-down and bottom-up pyramid.
	 * 
	 * @param n
	 * @return String array representing both pyramids.
	 */
	public String[] printPyramid(int n) {
		if(n>9||n<1)
		{
			return new String[]{"Enter number between 1 to 9"};
		}
		String[] result = new String[2 * n - 1];
		
	// Prints Top-down Pyramid
		for (int i = 0; i < n; i++) {

			result[i] = spaces(i, n) + numbers(i, n)+spaces(i,n);

		}

		// Prints Bottom-Up Pyramid
		for (int i = n; i < 2 * n - 1; i++) {
			result[i] = spaces(i + 1, n)+ numbers(i + 2, n) + spaces(i + 1, n);
		}

		return result;

	}
/*
 * 	public static void main(String[] args)
	{
		FirstPyramid obj=new FirstPyramid();
		String[] result= obj.printPyramid(5);
		for(int i=0;i<9;i++)
		{
			
		
			System.out.println(result[i]);
			
		}}

 */
}
