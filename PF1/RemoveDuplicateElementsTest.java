

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
public class RemoveDuplicateElementsTest {
//happy case
	@Test
public void removeDuplicateElementsTestCase1(){
	RemoveDuplicateElements array = new RemoveDuplicateElements();
	int[] input = {1,2,3,4,5,2,3,4,2,3,6,7,8};
	int[] expected = {1,2,3,4,5,6,7,8};
	int[] result = array.duplicateArrayElements(input);
	assertArrayEquals(expected, result);
}
//boundary case
@Test
public void removeDuplicateElementsTestCase2(){
	RemoveDuplicateElements array = new RemoveDuplicateElements();
	int[] input = {};
	int[] expected = {};
	int[] result = array.duplicateArrayElements(input);
	assertArrayEquals(expected, result);
}
}
