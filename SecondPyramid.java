/**
 * SecondPyramid Class generates a top-down pyramid. 12345 1234 123 12 1
 * 
 * @author Udit Saxena
 * 
 */

public class SecondPyramid {
	/**
	 * Prints space corresponding to each row.
	 * 
	 * @param row
	 * @param n
	 * @return String containing spaces.
	 */
	String spaces(int row) {
		if(row<1||row>9) //Error handling
		{
			return "Error";
		}
			String space = "";
			// contain spaces
		for (int i = 1; i < row; i++) {
			space += " ";
		}
		return space; //return space in String format
	}

	
	
	/**
	 * Prints numbers corresponding to each row.
	 * 
	 * @param row
	 * @param n
	 * @return String containing numbers.
	 */
	
	String printNumber(int row, int n) {
		if(row<1||n<1||n>9||row>n) // Error handling 
		{
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
	
	String[] printPyramid(int n) 
	{
		if(n<1||n>9)//error handling
		{
			return new String[]{"Enter number between 1 to 9"};
		}
		
		String result[] = new String[n]; // output array
		for (int row = 0; row < n; row++) {
			result[row] = spaces(row+1) + printNumber(row+1, n);
		}
		return result; // return string array contains pyramid
	}

}
