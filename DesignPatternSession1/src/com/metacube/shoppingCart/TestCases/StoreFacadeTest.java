package com.metacube.shoppingCart.TestCases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.metacube.shoppingCart.Facade.StoreFacade;

public class StoreFacadeTest {

	@Test
	public void GivenProductIdIsValid_WhenIsValidProductId_ThenTrue() {
		boolean actual = StoreFacade.getInstance().isValidProductId(1001);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenProductIdIsInValid_WhenIsValidProductId_ThenFalse() {
		boolean actual = StoreFacade.getInstance().isValidProductId(1004);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void Given3ProductPresentInStore_WhenGetTotalNoOfProductInStore_Then3() {
		int actual = StoreFacade.getInstance().getTotalNoOfProductInStore();
		int expected = 3;
		assertEquals(expected, actual);
	}

}
