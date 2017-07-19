import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringPermutationTest {

	static StringPermutation obj;
	List<String> expected;

	@Before
	public void setUpListBeforeTest() {
		obj = new StringPermutation();
		expected = new ArrayList<String>();
	}

	// this test will check all the permutations of given string
	@Test
	public void HappyTestCaseWhenStringIsABC() {
		List<String> actual = obj.generatePermutations("ABC");
		expected.add("ABC");
		expected.add("ACB");
		expected.add("BAC");
		expected.add("BCA");
		expected.add("CBA");
		expected.add("CAB");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void HappyTestCaseWhenStringIsABCD() {
		List<String> actual = obj.generatePermutations("ABCD");
		expected.add("ABCD");
		expected.add("ABDC");
		expected.add("ACBD");
		expected.add("ACDB");
		expected.add("ADCB");
		expected.add("ADBC");
		expected.add("BACD");
		expected.add("BADC");
		expected.add("BCAD");
		expected.add("BCDA");
		expected.add("BDCA");
		expected.add("BDAC");
		expected.add("CBAD");
		expected.add("CBDA");
		expected.add("CABD");
		expected.add("CADB");
		expected.add("CDAB");
		expected.add("CDBA");
		expected.add("DBCA");
		expected.add("DBAC");
		expected.add("DCBA");
		expected.add("DCAB");
		expected.add("DACB");
		expected.add("DABC");
		Assert.assertEquals(expected, actual);
	}

	// this test will check all the permutations of given string with same
	// letters
	@Test
	public void BoundaryTestCaseWhenSomeCharacterInStringAreSame() {
		List<String> actual = obj.generatePermutations("ABA");
		expected.add("ABA");
		expected.add("AAB");
		expected.add("BAA");
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void BoundaryTestCaseWhenAllCharacterInStringAreSame() {
		List<String> actual = obj.generatePermutations("AAAA");
		expected.add("AAAA");
		Assert.assertEquals(expected, actual);
	}
}