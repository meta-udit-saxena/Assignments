/**
 * Join two sorted arrays and generate third sorted array
 * @author Udit Saxena
 * version 1.0
 */
public class MergeSortedArrays {
/**
 * this function merge two sorted array(assume both are in ascending order) 
 * and generate third sorted array
 * @param a
 * @param aSize
 * @param b
 * @param bSize
 * @param c
 * @return c third sorted array
 */
	int [] merge (int a[],int aSize,int b[],int bSize,int c[]){
	
		if(aSize==0&&bSize==0) //check for both empty error
		{ 
			int[] empty={};
			return empty;
		}
		else if(aSize==0&&bSize!=0) //check if first array is empty and return second array
		{
			return b;
		}
		else if(aSize!=0&&bSize==0)//check if second array is empty and return first array
		{
			return a;
		}
		int k=0;  //third array length 
		int i=0;  //first array length
		int j=0;  //second array length
		while(i< aSize && j< bSize){
			/*check  smallest elements in a and b array and
			 * insert smallest element into c array and increment k and i
			*/
			if(a[i]<b[j]) 
				c[k++]=a[i++]; 
			else
				c[k++]=b[j++];
		}
	//insert remaining elements of a into c
	while(i<aSize){
		c[k++]=a[i++];
	}
	//insert remaining elements of b into c
	while(j<bSize){
		c[k++]=b[j++];
	}
	
	
		return c; //return c array
	}
	

}
