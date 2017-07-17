import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SecondPyramidTest {
 // happy case
	@Test
	public void secondPyramidTestCase1() {
		SecondPyramid object = new SecondPyramid();
		String[] expected = { "12345", " 1234", "  123", "   12", "    1" };
		String[] output = object.printPyramid(5);
		assertArrayEquals(expected, output);
	}
	
	@Test
	public void spaceTestCase1() {
		SecondPyramid object = new SecondPyramid();
		String expected = "    ";
		String output = object.spaces(5);
		assertEquals(expected, output);
	}
	
	@Test
	public void numberTestCase1() {
		SecondPyramid object = new SecondPyramid();
		String expected = "12345";
		String output = object.printNumber(1,5);
		assertEquals(expected, output);
	} 
	
	
	//boundary case
		@Test
		public void secondPyramidTestCase2() {
			SecondPyramid object = new SecondPyramid();
			String[] expected = { "Enter number between 1 to 9" };
			String[] output = object.printPyramid(-5);
			assertArrayEquals(expected, output);

		}
		
		@Test
		public void secondPyramidTestCase3() {
			SecondPyramid object = new SecondPyramid();
			String[] expected = { "Enter number between 1 to 9" };
			String[] output = object.printPyramid(0);
			assertArrayEquals(expected, output);

		}
		@Test
		public void spaceTestCase2() {
			SecondPyramid object = new SecondPyramid();
			String expected = "Error";
			String output = object.spaces(-5);
			assertEquals(expected, output);
		}
		
		@Test
		public void numberTestCase2() {
			SecondPyramid object = new SecondPyramid();
			String expected = "Error";
			String output = object.printNumber(6,5);
			assertEquals(expected, output);
		} 
		
		
}
