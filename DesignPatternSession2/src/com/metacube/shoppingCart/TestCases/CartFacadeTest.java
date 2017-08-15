package com.metacube.shoppingCart.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.shoppingCart.Facade.CartFacade;

public class CartFacadeTest {

	@Test
	public void GivenCartReset_WhenIsCartEmpty_ThenTrue() {
		CartFacade.getInstance().resetCart();
		boolean actual = CartFacade.getInstance().isCartEmpty();
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductAddedInCart_WhenIsCartEmpty_ThenFalse() {
		CartFacade.getInstance().addProductToCartByProductId(1001, 2);
		boolean actual = CartFacade.getInstance().isCartEmpty();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductPresentInCart_WhenIsProductPresentInCart_ThenTrue() {
		boolean actual = CartFacade.getInstance().isProductPresentInCart(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductNotPresentInCart_WhenIsProductPresentInCart_ThenFalse() {
		boolean actual = CartFacade.getInstance().isProductPresentInCart(1002);
		boolean expected = false;
		assertEquals(expected, actual);
	}
}
