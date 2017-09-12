import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TowerOfHanoiTest {
	static TowerOfHanoi object;
	List<String> expected;
	
	@Before
	public void setUpListBeforeTest() {
		object = new TowerOfHanoi();
		expected = new ArrayList<String>();
	}

	@After
	public void setUpListAfterTest() {
		expected.clear();
	}

	@Test
	public void towerOfHanoiHappyTestCaseWhenDiskSizeIs1() {
		object = new TowerOfHanoi();
		expected.add("Move Disk 1 from A to B");
		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 1);
		assertEquals(expected, actual);
	}

	@Test
	public void towerOfHanoiHappyTestCaseWhenDiskSizeIs2() {
		expected.add("Move Disk 2 from A to C");
		expected.add("Move Disk 1 from A to B");
		expected.add("Move Disk 2 from C to B");
		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 2);
		assertEquals(expected, actual);
	}

	@Test
	public void towerOfHanoiHappyTestCaseWhenDiskSizeIs3() {
		expected.add("Move Disk 3 from A to B");
		expected.add("Move Disk 2 from A to C");
		expected.add("Move Disk 3 from B to C");
		expected.add("Move Disk 1 from A to B");
		expected.add("Move Disk 3 from C to A");
		expected.add("Move Disk 2 from C to B");
		expected.add("Move Disk 3 from A to B");
		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 3);
		assertEquals(expected, actual);
	}

	@Test
	public void towerOfHanoiBoundaryTestCaseWhenDiskSizeIsZero() {
		TowerOfHanoi object = new TowerOfHanoi();
		expected.add("No Disk");
		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 0);
		assertEquals(expected, actual);
	}

	@Test
	public void towerOfHanoiBoundaryTestCaseWhenDiskSizeIsNegative() {
		expected.add("No Disk");
		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", -1);
		assertEquals(expected, actual);
	}
}
