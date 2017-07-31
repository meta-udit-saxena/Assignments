package SocialNetwork;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConnectionTest {
	Connection connection;

	@Before
	public void setUpObject() {
		connection = new Connection();
	}

	@Test
	public void GivenIdPresentInList_WhenIsEntityIdIsPresentInList_ThenTrue() {
		boolean actual = connection.isEntityIdIsPresentInList("123", "125");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenIdNotPresentInList_WhenIsEntityIdIsPresentInList_ThenFalse() {
		boolean actual = connection.isEntityIdIsPresentInList("123", "124");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenEntityIdAddedInList_WhenIsEntityIdIsPresentInList_ThenTrue() {
		connection.addConnection("123", "124");
		boolean actual = connection.isEntityIdIsPresentInList("123", "124");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenEntityIdRemovedFromList_WhenIsEntityIdIsPresentInList_ThenFalse() {
		connection.removeConnection("123", "124");
		boolean actual = connection.isEntityIdIsPresentInList("123", "124");
		boolean expected = false;
		assertEquals(expected, actual);
	}

}
