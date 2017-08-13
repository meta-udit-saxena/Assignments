import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class MatrixTest {

	/*
	 * happy test cases
	 */
	@Test
	public void addElementsHappyTestCase() {
		Matrix object = new Matrix(2, 2);
		object.addElements(0, 0, 1);
		object.addElements(0, 1, 2);
		object.addElements(1, 0, 3);
		object.addElements(1, 1, 0);
		int[][] expected = {{1,2},{3,0}};
		assertArrayEquals(expected,object.getData());
}

	@Test
	public void showHappyTestCase() {
		Matrix object = new Matrix(2, 2);
		object.addElements(0, 0, 1);
		object.addElements(0, 1, 2);
		object.addElements(1, 0, 3);
		object.addElements(1, 1, 4);
		String actual = object.show();
		String expected = "1 2 \n" + "3 4 \n";
		assertEquals(actual, expected);
}

	@Test
	public void transpposeHappyTestCase() {
		Matrix object = new Matrix(2, 2);
		object.addElements(0, 0, 1);
		object.addElements(0, 1, 2);
		object.addElements(1, 0, 3);
		object.addElements(1, 1, 4);
		object = object.transpose();
		int[][] expected = {{1,3},{2,4}};
		assertArrayEquals(expected,object.getData());
}

	@Test
	public void multiplicationHappyTestCase() {
		Matrix firstMatrix = new Matrix(2, 2);
		firstMatrix.addElements(0, 0, 1);
		firstMatrix.addElements(0, 1, 3);
		firstMatrix.addElements(1, 0, 5);
		firstMatrix.addElements(1, 1, 6);
		Matrix secondMatrix = new Matrix(2, 2);
		secondMatrix.addElements(0, 0, 2);
		secondMatrix.addElements(0, 1, 4);
		secondMatrix.addElements(1, 0, 7);
		secondMatrix.addElements(1, 1, 8);
		Matrix result = firstMatrix.multiplication(secondMatrix);
		int[][] expected = {{23,28},{52,68}};
		assertArrayEquals(expected,result.getData());
}

	/*
	 * Boundary Test Case
	 */
	@Test
	public void multiplicationBoundaryTestCaseWhenMatrixRowsColsAreMismatch() {
		Matrix firstMatrix = new Matrix(2, 2);
		firstMatrix.addElements(0, 0, 1);
		firstMatrix.addElements(0, 1, 3);
		firstMatrix.addElements(1, 0, 5);
		firstMatrix.addElements(1, 1, 6);
		Matrix secondMatrix = new Matrix(3, 2);
		secondMatrix.addElements(0, 0, 2);
		secondMatrix.addElements(0, 1, 4);
		secondMatrix.addElements(1, 0, 7);
		secondMatrix.addElements(1, 1, 8);
		secondMatrix.addElements(0, 0, 2);
		secondMatrix.addElements(0, 1, 4);		
		Matrix result = firstMatrix.multiplication(secondMatrix);
		assertNull(result);
	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void addElementsBoundaryTestCase() {
		Matrix object = new Matrix(2, 2);
		object.addElements(0, 0, 1);
		object.addElements(0, 1, 2);
		object.addElements(1, 0, 3);
		object.addElements(1, -1, 0);
		int[][] expected = {{1,2},{3,0}};
		assertArrayEquals(expected,object.getData());

	}
	
}
