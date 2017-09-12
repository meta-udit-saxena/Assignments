import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
public class MergeSortedArraysTest {
	//happy path
	@Test
	public void mergeSortedArraysTest1(){
		
		MergeSortedArrays obj=new MergeSortedArrays();
		int[] a={1,2,3,3,4,5,5};
		int[] b={0,1,1,4,4,6,7};
		int[] c=new int[a.length+b.length];
		int[] expec= {0,1,1,1,2,3,3,4,4,4,5,5,6,7};
		int[] ans=obj.merge(a, a.length, b, b.length, c);
		
		assertArrayEquals(expec,ans);
		
	}
	//boundary case when user enter null value
		@Test
		public void mergeSortedArraysTestCase2(){
			
			MergeSortedArrays obj=new MergeSortedArrays();
			int[] a={};
			int[] b={};
			int[] c=new int[a.length+b.length];
			int[] expec= {};
			int[] ans=obj.merge(a, a.length, b, b.length, c);
			
			assertArrayEquals(expec,ans);
			
		}
		//boundary case when user gives one array and second is empty
				@Test
				public void mergeSortedArraysTestCase3(){
					
					MergeSortedArrays obj=new MergeSortedArrays();
					int[] a={};
					int[] b={1,2,3,4};
					int[] c=new int[a.length+b.length];
					int[] expec= {1,2,3,4};
					int[] ans=obj.merge(a, a.length, b, b.length, c);
					
					assertArrayEquals(expec,ans);
					
				}

}
