package com.metacube.shoppingCart.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.shoppingCart.controller.CartController;

public class CartControllerTest {

	@Test
	public void GivenProductAddedInCart_WhenIsCartEmpty_ThenFalse() {
		CartController.getInstance().addProductToCart(1001, 2);
		boolean actual = CartController.getInstance().isCartEmpty();
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductPresentInCart_WhenIsProductPresentInCart_ThenTrue() {
		boolean actual = CartController.getInstance().isProductPresentInCart(
				1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductNotPresentInCart_WhenIsProductPresentInCart_ThenFalse() {
		boolean actual = CartController.getInstance().isProductPresentInCart(
				1002);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenLastProductRemovedFromCart_WhenIsCartEmpty_ThenTrue() {
		CartController.getInstance().removeProductFromCart(1001);
		boolean actual = CartController.getInstance().isCartEmpty();
		boolean expected = true;
		assertEquals(expected, actual);
	}
}
