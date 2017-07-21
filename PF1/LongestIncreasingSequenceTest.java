import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class LongestIncreasingSequenceTest {
	
	//happy case
	@Test
	public void longestIncreasingSequenceTestTestCase1(){
		LongestIncreasingSequence obj=new LongestIncreasingSequence();
		int[] input={1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		int[] ans={1,2,4,5,6,7,8,9};
		int[] result = obj.longestSequence(input);
		assertArrayEquals(ans,result);
	
		}
	//boundary case when user enter nothing
		@Test
		public void LongestIncreasingSequenceTestTestCase2(){
			LongestIncreasingSequence obj=new LongestIncreasingSequence();
			int[] input=null;
			int[] ans=null;
			int[] result = obj.longestSequence(input);
			
			
			assertArrayEquals(ans,result);
		
			}

	
}
