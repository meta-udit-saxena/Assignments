import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SecondPyramidTest {
	SecondPyramid object = new SecondPyramid();

	// happy case
	@Test
	public void printPyramidHappyTestCase() {
		String[] expected = { "12345", " 1234", "  123", "   12", "    1" };
		String[] output = object.printPyramid(5);
		assertArrayEquals(expected, output);
	}

	@Test
	public void printSpaceHappyTestCase() {
		String expected = "    ";
		String output = object.printSpaces(5);
		assertEquals(expected, output);
	}

	@Test
	public void printNumberHappyTestCase() {
		String expected = "12345";
		String output = object.printNumber(1, 5);
		assertEquals(expected, output);
	}

	// boundary case
	@Test
	public void printPyramidBoundaryTestCase1() {
		String[] expected = { "Enter number between 1 to 9" };
		String[] output = object.printPyramid(-5);
		assertArrayEquals(expected, output);
	}

	@Test
	public void printPyramidBoundaryTestCase2() {
		String[] expected = { "Enter number between 1 to 9" };
		String[] output = object.printPyramid(0);
		assertArrayEquals(expected, output);

	}

	@Test
	public void printSpaceBoundaryTestCase() {
		String expected = "Error";
		String output = object.printSpaces(-5);
		assertEquals(expected, output);
	}

	@Test
	public void printNumberBoundaryTestCase() {
		String expected = "Error";
		String output = object.printNumber(6, 5);
		assertEquals(expected, output);
	}

}
