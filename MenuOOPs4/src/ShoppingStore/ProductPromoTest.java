package ShoppingStore;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ProductPromoTest {
	Cart cart;
	Store store;
	ProductPromo productPromo;
	CartProducts cartProduct;

	@Before
	public void setUpObject() {
		store = new Store();
		cart = new Cart();
		productPromo = new ProductPromo();
	}

	@Test
	public void GivenProductIdIsValid_WhenIsApplicable_ThenTrue() {
		boolean actual = productPromo.isApplicable(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductIdIsInvalid_WhenIsApplicable_ThenFalse() {
		boolean actual = productPromo.isApplicable(4011);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenIdIs1001AndQuantityIs50_WhenSetDiscount_Then3245() {
		cart.addProductToCartByProductId(store, 1001, 50);
		productPromo.setDiscount(cart);
		cartProduct = cart.getCartItems().get(0);
		double actual = cartProduct.getProductPrice();
		double expected = 749.0;
		assertEquals(expected, actual, 0.0);
	}

	@Test
	public void GivenIdIs4011AndQuantityIs1_WhenSetDiscount_Then0() {
		cart.addProductToCartByProductId(store, 4011, 1);
		productPromo.setDiscount(cart);
		cartProduct = cart.getCartItems().get(0);
		double actual = cart.getOrderLevelDiscount();
		double expected = 0.0;
		assertEquals(expected, actual, 0.0);
	}
}
