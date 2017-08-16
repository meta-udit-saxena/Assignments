package com.metacube.shoppingCart.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.shoppingCart.controller.StoreController;

public class StoreControllerTest {

	@Test
	public void GivenInputNumberOfProductDonotExceededLimit_WhenIsValidNumberOfProduct_ThenTrue() {
		boolean actual = StoreController.getInstance()
				.isValidNumberOfProduct(3);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenInputNumberOfProductExceededLimit_WhenIsValidNumberOfProduct_ThenFalse() {
		boolean actual = StoreController.getInstance().isValidNumberOfProduct(
				10);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductIdIsValid_WhenIsValidProductId_ThenTrue() {
		boolean actual = StoreController.getInstance().isValidProductId(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductIdIsInValid_WhenIsValidProductId_ThenFalse() {
		boolean actual = StoreController.getInstance().isValidProductId(1004);
		boolean expected = false;
		assertEquals(expected, actual);
	}

}
