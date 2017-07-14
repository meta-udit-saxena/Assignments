/**
 * To find longest increasing sequence from an array of n integer values
 * @author Udit Saxena
 * version 1.0
 */
public class LongestIncreasingSequence {
	/**
	 * int[] longestSequence(int[] input) function find the longest 
	 * sequence in input array
	 * @param input
	 * @return longest sequence array
	 */
	 int[] longestSequence(int[] input){
		 if(input==null)
		 {
			return null;
		 }
		 else
		 {
		int startIndex=0; //starting index
		int endIndex=0;   //ending index
		int length=1;     //store length of sequence
		int maxlength=1;  //store length of longest sequence
		int startLocation=0; //store starting index of longest sequence
		int endLocation=0;  // store ending index of longest sequence
		
		//find longest sequence and store its attributes
		for(int i=0;i<input.length-1;i++){
			if(input[i]<input[i+1]){
				endIndex++;
				length++;
			}
			else{
			 
				if(length>maxlength){
					startLocation=startIndex;
					endLocation=endIndex;
				}
			startIndex=i+1;
			endIndex=startIndex;
			length=0;
			}
			
		}
		// check for finding longest sequence if its present at end 
		if(length>maxlength){
			startLocation=startIndex;
			endLocation=endIndex;
		}
		
		int[] output=new int[endLocation-startLocation+1];// array for storing longest sequence
		//copy longest sequence into output array
		for(int i=startLocation,k=0;i<=endLocation;i++)
			output[k++]=input[i];
		
		
		return output; // return longest sequence
	}

	 }
}

