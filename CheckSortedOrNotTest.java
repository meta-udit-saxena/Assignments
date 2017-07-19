/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author goku
 */
import static org.junit.Assert.assertEquals;


import org.junit.Test;
public class CheckSortedOrNotTest {
	//happy path
	@Test
	  public void checkSortedOrNotTest1() {
	  CheckSortedOrNot check = new CheckSortedOrNot();
        int[] input={1,1,2,3,3,4,5};
          String result = check.messageDisplay(input);
        assertEquals("Ascending Order", result);
}

	
  @Test
	  public void checkSortedOrNotTest2() {
	  CheckSortedOrNot check = new CheckSortedOrNot();
      int[] input={100,100,100,20,13,4,0};
      String result = check.messageDisplay(input);
      assertEquals("Descending Order", result);
}
	@Test
	  public void checkSortedOrNotTest3() {
	  CheckSortedOrNot check = new CheckSortedOrNot();
	  int[] input={1,21,32,14,50};
     String result = check.messageDisplay(input);
     assertEquals("Unsorted Array", result);
}
	 //handle constant
   @Test
	  public void checkSortedOrNotTest4() {
	  CheckSortedOrNot check = new CheckSortedOrNot();
       int[] input={1,1,1,1,1,1};
         String result = check.messageDisplay(input);
        
       assertEquals("Constant", result);
}
// boundary case not value given
   
   public void checkSortedOrNotTest5() {
		  CheckSortedOrNot check = new CheckSortedOrNot();
	       int[] input={};
	         String result = check.messageDisplay(input);
	        
	       assertEquals("enter some value", result);
	}
}
