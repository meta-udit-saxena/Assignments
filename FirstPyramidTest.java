
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class FirstPyramidTest {
//happy case
	@Test
	public void firstPyramidTestCase1() {
		String[] expected = { "    1    ", "   121   ", "  12321  ",
				" 1234321 ", "123454321", " 1234321 ", "  12321  ",
				"   121   ", "    1    " };

		FirstPyramid object = new FirstPyramid();
		String[] output = object.printPyramid(5);
		assertArrayEquals(expected, output);
	}
		@Test
		public void printNumberCase1() {
			String expected = "121";

			FirstPyramid object = new FirstPyramid();
			String output = object.numbers(1, 5);
			assertEquals(expected, output);
		
	}
		@Test
		public void printSpaceCase1() {
			String expected = "    " ;

			FirstPyramid object = new FirstPyramid();
			String output = object.spaces(0, 5);
			assertEquals(expected, output);
		}
	//boundary case
		@Test
		public void firstPyramidTestCase2() {
			String[] expected = { "Enter number between 1 to 9" };

			FirstPyramid object = new FirstPyramid();
			String[] output = object.printPyramid(-5);
			assertArrayEquals(expected, output);

		}
		
		@Test
		public void firstPyramidTestCase3() {
			String[] expected = { "Enter number between 1 to 9" };

			FirstPyramid object = new FirstPyramid();
			String[] output = object.printPyramid(50);
			assertArrayEquals(expected, output);

		}
		@Test
		public void printNumberCase2() {
			String expected = "Error";

			FirstPyramid object = new FirstPyramid();
			String output = object.numbers(11, 5);
			assertEquals(expected, output);
		
	}
		
		@Test
		public void printSpaceCase3() {
			String expected = "Error" ;

			FirstPyramid object = new FirstPyramid();
			String output = object.spaces(-1, 5);
			assertEquals(expected, output);
		}
		
}
