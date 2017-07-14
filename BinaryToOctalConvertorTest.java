import static org.junit.Assert.assertEquals;


import org.junit.Test;
public class BinaryToOctalConvertorTest 
{
	//happy path
		@Test

		public void binaryToOctalConertorTest1() 
		{
		    BinaryToOctalConvertor calculator = new BinaryToOctalConvertor();
		    int ans= calculator.covertBinaryToOctal(100100);
		    assertEquals(44, ans);
		    //assertEquals(56, sum);

	     }


	    
	//Not a binary number
		@Test

		public void binaryToOctalConertorTest3() 
		{
		    BinaryToOctalConvertor calculator = new BinaryToOctalConvertor();
		    int ans= calculator.covertBinaryToOctal(210);
		    assertEquals(-1, ans);
		    //assertEquals(56, sum);

	     }
}
