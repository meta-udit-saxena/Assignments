
 /**
  * Check given array is in sorted order or not
  * @author Udit saxena
  * version 1.0
  */
public class CheckSortedOrNot {
	/**
	 * Function check array is sorted or not and return 1 if array is in ascending order, 
	 * 2 if array is in descending order and 0 if array is not in sorted
	 * @param input
	 * @return 0 or 1 or 2
	 */
     public int checkSortedOrNot(int[] input)
    {
    	if(input.length==0)
    	{
    		return -1;
    	}
          if(input[0]<input[input.length-1]) //check for array is ascending or desending
          {
        	  
        for(int i=0;i<input.length-1;i++) //for ascending order
        {
            if(input[i]>input[i+1]) //unsorted array condition
            {
                
               return 0;   //unsorted array
            }
        }
        	return 1;   //sorted array in ascending order
          }
          else if (input[0]>input[input.length-1])
          { 
        	  
         for(int i=0;i<input.length-1;i++)//for descending order
            {
            if(input[i]<input[i+1])//unsorted array condition
              {
              return 0;  //unsorted array
              }
            }
               return 2;   //sorted array in descending order
              }
          else
          {
        	  return 3; //constant
          }
           
}
/**
 * display appropriate message based on return value of above function.
 * @param input
 * @return message
 */
    public String messageDisplay(int[] input)
    {
    	String msg=""; //contain message
        int returnValue = checkSortedOrNot(input); //contain return Value from above function
        //condition and set message according to return value
        if(returnValue==1)
        {
            msg= "Ascending Order";
        }
        else if(returnValue==2)
        {
            msg= "Descending Order";
        }
        else if(returnValue==0)
        {
            msg= "Unsorted Array";
        }
        else if(returnValue==3)
        {
        	msg="Constant";
        }
        else
        {
        	msg="enter some value";
        }
        return msg;  //return appropriate message
    }   
}
