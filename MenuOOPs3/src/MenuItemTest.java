import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Udit Saxena
 *
 */
public class MenuItemTest {
	MenuItem menuItem;

	@Before
	public void setUpObject() {
		menuItem = new Menu();
	}

	@Test
	public void GivenString_WhenGetSelection_ThenReturnSameString() {
		menuItem.setDisplayName("1.Display");
		String actual = menuItem.getDisplayName();
		String expected = "1.Display";
		assertEquals(expected, actual);

	}

	@Test
	public void GivenNULL_WhenGetSelection_ThenReturnSameString() {
		menuItem.setDisplayName(null);
		String actual = menuItem.getDisplayName();
		String expected = null;
		assertEquals(expected, actual);

	}
}
