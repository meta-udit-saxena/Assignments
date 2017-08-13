package ShoppingStore;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StoreTest {
	Cart cart;
	Store store;
	ProductPromo productPromo;

	@Before
	public void setUpObject() {
		store = new Store();
		cart = new Cart();
		productPromo = new ProductPromo();
	}

	@Test
	public void GivenProductIdIsValid_WhenisIdValid_ThenTrue() {
		boolean actual = store.isValidProductId(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductIdIsInValid_WhenisIdValid_ThenFalse() {
		boolean actual = store.isValidProductId(4101);
		boolean expected = false;
		assertEquals(expected, actual);
	}

}