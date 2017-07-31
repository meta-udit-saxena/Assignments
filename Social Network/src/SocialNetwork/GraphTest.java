/**
 * 
 */
package SocialNetwork;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author User27
 *
 */
public class GraphTest {

	Graph graph;

	@Before
	public void setUpObject() {
		graph = new Graph();
	}

	@Test
	public void GivenEntityIdIsValid_WhenIsValidNodeId_ThenTrue() {
		boolean actual = graph.isValidNodeId("123");
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	public void GivenEntityIdIsInvalid_WhenIsValidNodeId_ThenFalse() {
		boolean actual = graph.isValidNodeId("789");
		boolean expected = false;
		assertEquals(actual, expected);
	}

	@Test
	public void GivenEntityAdded_WhenIsValidNodeId_ThenTrue() {
		graph.addNode("290", new User("290", "xyz", "123", 1234567890, 23,
				"User"));
		boolean actual = graph.isValidNodeId("290");
		boolean expected = true;
		assertEquals(actual, expected);
	}

	@Test
	public void GivenEntityIdIsRemoved_WhenIsValidNodeId_ThenFalse() {
		graph.removeNodeById("290");
		boolean actual = graph.isValidNodeId("290");
		boolean expected = false;
		assertEquals(actual, expected);
	}
}
