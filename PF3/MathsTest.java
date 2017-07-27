import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;
public class MathsTest {
	static Maths obj;
	@BeforeClass
	public static void setUpObject(){
		obj = new Maths();
	}
	
	/*
	 * Happy Test cases
	 */
	@Test
	public void gcdHappyTestCase(){
		int expected = 1;
		int actual = obj.gcd(100, 3);
		assertEquals(expected, actual);
	}
	@Test
	public void remainderHappyTestCase(){
		int expected = 1;
		int actual = obj.rem(100, 3);
		assertEquals(expected, actual);
	}
	@Test
	public void largestNumberHappyTestCase(){
		int expected = 9;
		int actual = obj.largestDigit(1257369);
		assertEquals(expected, actual);
	}
	
	/*
	 * Boundary Cases
	 */
	@Test
	public void gcdBoundaryTestCaseWhenOneNumberIsZero(){
		int expected = 100;
		int actual = obj.gcd(100, 0);
		assertEquals(expected, actual);
	}
	@Test
	public void remainderBoundaryTestCaseWhenTryToDivideByZero(){
		int expected = -1;
		int actual = obj.rem(100, 0);
		assertEquals(expected, actual);
	}
	@Test
	public void largestNumberBoundaryTestCaseWhenNumberIsNegative(){
		int expected = 9;
		int actual = obj.largestDigit(-1257369);
		assertEquals(expected, actual);
	}
	@Test
	public void largestNumberBoundaryTestCaseWhenNumberIsZero(){
		int expected = 0;
		int actual = obj.largestDigit(0000);
		assertEquals(expected, actual);
	}
}
