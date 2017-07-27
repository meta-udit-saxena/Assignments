import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;

public class QuickSortAlgorithmTest {
	static QuickSortAlgorithm obj;

	@BeforeClass
	public static void setUpObject() {
		obj = new QuickSortAlgorithm();
	}

	/*
	 * Happy test cases
	 */
	@Test
	public void quickSortHappyTestCase() {
		int[] array = { 2, 5, 8, 9, 10, 77, 55, 11 };
		int[] expected = { 2, 5, 8, 9, 10, 11, 55, 77 };
		obj.quickSort(array, 0, array.length - 1);
		assertArrayEquals(expected, array);
	}

	@Test
	public void swapHappyTestCase() {
		int[] array = { 1, 2, 3, 9, 0, 7, 6 };
		int[] expected = { 6, 2, 3, 9, 0, 7, 1 };
		obj.swap(array, 0, array.length - 1);
		assertArrayEquals(expected, array);
	}

	@Test
	public void returnPartitionIndexHappyTestCase() {
		int[] array = { 1, 2, 3, 9, 0, 7, 6 };
		int expected = 5;
		int actual = obj.returnPartitionIndex(array, 0, array.length - 1);
		assertEquals(expected, actual);
	}

	/*
	 * Boundary cases when array is NULL
	 */

	@Test
	public void quickSortBoundaryTestCaseWhenArrayIsNull() {
		obj.quickSort(null, 0, 10);
	}

	@Test
	public void swapBoundaryTestCaseWhenArrayIsNull() {
		obj.swap(null, 0, 11);
	}

	@Test
	public void returnPartitionIndexBoundaryTestCaseWhenArrayIsNull() {
		obj.returnPartitionIndex(null, 0, 6);
	}

	/*
	 * Boundary cases when array is Empty
	 */

	@Test
	public void quickSortBoundaryTestCaseWhenArrayIsEmpty() {
		obj.quickSort(new int[] {}, 0, 10);
	}

	@Test
	public void swapBoundaryTestCaseWhenArrayIsEmpty() {
		obj.swap(new int[] {}, 0, 11);
	}

	@Test
	public void returnPartitionIndexBoundaryTestCaseWhenArrayIsEmpty() {
		obj.returnPartitionIndex(new int[] {}, 0, 6);
	}

}
