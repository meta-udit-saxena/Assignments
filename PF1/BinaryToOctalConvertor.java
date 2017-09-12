/**
 *  To convert binary numbers to octal
 *  
 *  version 1.0
 *  @author Udit Saxena
 *
 */

public class BinaryToOctalConvertor {
	/** 
	 * * This function convert binary to octal
	 * first it convert binary to decimal then decimal to octal
	 
	 * @param n
	 * @return octal value
	 */
	
	
 public int covertBinaryToOctal(int n) 
 {
	 
	int checkBinary = n; //binary value
	int digit=0;  //store digit value
	while(checkBinary!=0)
	{
		digit=checkBinary%10; //for fetching single digit(last) from binary
		if(digit!=0&&digit!=1) //check digit either 0 or 1
		{
			return -1;
		}
		checkBinary =checkBinary/10; //remove the use digit
	}
	
	// Binary to decimal
	
	int binary=n; 
	 double decimal=0; //contain decimal value
	 double power=0; 
	 while(binary!=0) //convert binary to decimal
	 {
		 decimal+=((binary%10)*(Math.pow(2, power)));
		 binary=binary/10;
		 power++;
	 }
	 
	 //decimal to octal
	int octal=0; //store octal value
	int count =1; 
	int rem=0; //store remainder
	while(decimal!=0) //convert decimal to octal
	{
		rem = (int)decimal%8; //type casting double to int
		octal=(rem*count)+octal;
		decimal=decimal/8;
		count*=10;
	}
 return octal;  //return octal value
 }
}
