package ShoppingStore;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
public class StoreTest {
	Cart cart;
	Store store;
	ProductPromo productPromo;
	CartProducts cartProduct;
	@Before
	public void setUpObject(){
		store = new Store();
		cart = new Cart();
		productPromo=new ProductPromo();
		cartProduct=new CartProducts();
	}
	@Test
	public void Given_ProductIdIs1001_When_isIdValid_Then_True(){
		boolean actual = store.isIdValid(1001);
		boolean expected=true;
		assertEquals(expected, actual);
	}
	@Test
	public void Given_ProductIdIs4101_When_isIdValid_Then_False(){
		boolean actual = store.isIdValid(4101);
		boolean expected=false;
		assertEquals(expected, actual);
	}

}