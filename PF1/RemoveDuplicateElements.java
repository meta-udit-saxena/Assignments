/**
 * Remove duplicate elements from an unsorted Array
 * 
 * @author Udit Saxena
 *
 */
public class RemoveDuplicateElements {
	/**
	 * duplicateArrayElements(int[] input) function remove duplicate elements from an Array
	 * 
	 * @param input
	 * @return result array
	 */
 int[] duplicateArrayElements(int[] input)
    {
	 if(input.length==0)
	 {
		 int[] a={};
		 return a;
	 }
        int[] output=new int[input.length]; //array for storing dissimilar elements
        int size=1; //length for result array
        int flag=0; //check for duplicate element (flag=1 for duplicate elements)
        output[0]=input[0]; //copy first element from input array to output array 
        
        // insert dissimilar elements from input array to output array
        for(int i=1;i<input.length;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(input[i]==output[j]) //checking duplicate elements
                {
                	flag=1;
                 break;
                }
            }
            if(flag==0)
            {
                output[size]=input[i];   //copying dissimilar elements into output array
               
                size++;
            }
             flag=0;
                    
                    
        
        }
        
        int[] result = new int[size]; //array for storing final array of length =size
        //copy output array to result array 
        for(int i=0;i<size;i++)
            {
            	result[i]=output[i];
            }
            output=null; //free output array
            return result; //return result array
    
}
   
}
