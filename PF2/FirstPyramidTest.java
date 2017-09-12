import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstPyramidTest {

	FirstPyramid object = new FirstPyramid();

	// happy case
	@Test
	public void printPyramidHappyCase() {
		String[] expected = { "    1    ", "   121   ", "  12321  ",
				" 1234321 ", "123454321", " 1234321 ", "  12321  ",
				"   121   ", "    1    " };
		String[] output = object.printPyramid(5);
		assertArrayEquals(expected, output);
	}

	@Test
	public void printNumberHappyCase() {
		String expected = "121";
		String output = object.returnNumbers(1, 5);
		assertEquals(expected, output);
	}

	@Test
	public void printSpaceHappyCase() {
		String expected = "    ";
		String output = object.returnSpaces(0, 5);
		assertEquals(expected, output);
	}

	// boundary case
	@Test
	public void printPyramidBoundaryCase1() {
		String[] expected = { "Enter number between 1 to 9" };
		String[] output = object.printPyramid(-5);
		assertArrayEquals(expected, output);
	}

	@Test
	public void printPyramidBoundaryCase2() {
		String[] expected = { "Enter number between 1 to 9" };
		String[] output = object.printPyramid(50);
		assertArrayEquals(expected, output);
	}

	@Test
	public void printNumberBoundaryCase() {
		String expected = "Error";
		String output = object.returnNumbers(11, 5);
		assertEquals(expected, output);
	}

	@Test
	public void printSpaceBoundaryCase() {
		String expected = "Error";
		String output = object.returnSpaces(-1, 5);
		assertEquals(expected, output);
	}

}
