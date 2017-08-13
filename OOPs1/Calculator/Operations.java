/**
 *  perform the various operations of calculator
 * @author User27
 *
 */
public class Operations {

	/**
	 * Calculate according to operator
	 * @param firstNum - first Number
	 * @param secondNum - second Number
	 * @param operator - operation to be performed
	 * @return result for further calculation if any
	 */
	public int evaluate(int firstNum, int secondNum, char operator)
	{
		switch(operator)
		{
			case '+':
				return firstNum + secondNum;
			case '-':
				return firstNum - secondNum;
			case '*':
				return firstNum * secondNum;
			case '/':
				return firstNum / secondNum;
			/*
			 *  other operators 
			 *  logarithmic 
			 *  percentage etc. 
			 *  other functionalities can be extended
			 */
			default:	
				return firstNum;
		}
	}
}
