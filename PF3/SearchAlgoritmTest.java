import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
public class SearchAlgoritmTest {
	static SearchAlgoritm obj;
	@BeforeClass
	public static void setUpObject(){
		obj=new SearchAlgoritm();
	}
	
	/*
	 * Happy test cases
	 */
	@Test
	public void linearSearchHappyTestCase(){
		int[] array ={2,5,8,9,10,77,55};
		int expected = 6;
		int actual = obj.linearSearch(array,77,0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void binarySearchHappyTestCase(){
		int[] array ={2,5,8,9,10,77,55};
		int expected = 6;
		int actual = obj.linearSearch(array,77,0);
		assertEquals(expected, actual);
	}
	
	/*
	 * Boundary cases when element not present in array
	 */
	@Test
	public void linearSearchBoundaryTestCaseWhenElementIsNotPresent(){
		int[] array ={2,5,8,9,10,77,55};
		int expected = -1;
		int actual = obj.linearSearch(array,776,0);
		assertEquals(expected, actual);
	}
	
	@Test
	public void binarySearchBoundaryTestCaseWhenElementIsNotPresent(){
		int[] array ={2,5,8,9,10,77,55};
		int expected = -1;
		int actual = obj.linearSearch(array,7,0);
		assertEquals(expected, actual);
	}
	
	/*
	 * Boundary cases when array is null
	 */
	@Test
	public void linearSearchBoundaryTestCaseWhenArrayIsNull(){
		int[] array =null;
		obj.linearSearch(array,776,0);
	}
	
	@Test
	public void binarySearchBoundaryTestCaseWhenArrayIsNull(){
		int[] array =null;
		obj.linearSearch(array,7,0);
	}
	/*
	 * Boundary cases when array is empty
	 */
	@Test
	public void linearSearchBoundaryTestCaseWhenArrayIsEmpty(){
		int[] array ={ };
		obj.linearSearch(array,776,0);
	}
	
	@Test
	public void binarySearchBoundaryTestCaseWhenArrayIsEmpty(){
		int[] array ={ };
		obj.linearSearch(array,7,0);
	}
	
}
