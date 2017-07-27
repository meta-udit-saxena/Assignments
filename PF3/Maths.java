/**
 * Write recursive functions for the following:
 * 1- to compute the remainder of x divided by y.
 * 2- to compute the greatest common divisor of x and y.
 * 3- to find out the largest digit in the number x
 * 
 * @author User27
 *
 */
public class Maths {
	/**
	 * to compute the remainder of x divided by y.
	 * 
	 * @param x
	 *            - first number where x>=0
	 * @param y
	 *            - second number where y>0
	 * @return - remainder of (x,y)
	 */
	int rem(int x, int y) {
		if (y <= 0) {
			return -1;
		}
		if (x >= y) {
			x = rem(x - y, y);
		}
		return x;
	}

	/**
	 * to compute the greatest common divisor of x and y.
	 * 
	 * @param x
	 *            first number where x>0
	 * @param y
	 *            second number where y>0
	 * @return greatest common divisor of x,y
	 */
	int gcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		int result = gcd(y, x % y);

		return result;
	}

	/**
	 * to find out the largest digit in the number x
	 * 
	 * @param x
	 *            - given number where x>=0
	 * @return max - largest digit present in that number
	 */
	int largestDigit(int x) {
		// if given number is negative
		x = Math.abs(x);
		if (x == 0) {
			return 0;
		}
		int max = x % 10;
		int checkMax = largestDigit(x / 10);
		if (max < checkMax) {
			max = checkMax;
		}

		return max;
	}
}
