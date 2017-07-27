import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NQueenProblemTest {
	static NQueenProblem obj = new NQueenProblem();;
	List<String> expected;

	@Before
	public void setUpListBeforeTest() {
		obj = new NQueenProblem();
		expected = new ArrayList<String>();
	}

	// this test will check NQueen for num >= 4
	@Test
	public void nQueenHappyTestWhenDimensionIsEqualTo4() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
				{ 0, 0, 0, 0 } };
		Boolean expected = obj.nQueen(board, 0, 4);
		assertEquals(true, expected);
	}

	@Test
	public void nQueenHappyTestWhenDimensionIsGreaterThan4() {
		int board[][] = { { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
		Boolean expected = obj.nQueen(board, 0, 5);
		assertEquals(true, expected);
	}

	@Test
	// this test will check NQueen for num <4
	public void nQueenBoundaryTestWhenDimensionIsLessThan4() {
		int board[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		Boolean expected = obj.nQueen(board, 0, 3);
		assertEquals(false, expected);
	}

}
