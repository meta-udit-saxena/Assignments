package com.metacube.shoppingCart.controller;

import com.metacube.shoppingCart.Facade.BillGeneratorFacade;
import com.metacube.shoppingCart.Facade.CartFacade;
import com.metacube.shoppingCart.View.DisplayOutput;

/**
 * Cart Controller Class
 * 
 * @author Udit Saxena
 */
public class CartController {
	private static CartController cartController;

	/**
	 * Create a singleton Class
	 * 
	 * @return cartController instance of CartController
	 */
	public static CartController getInstance() {
		if (cartController == null) {
			synchronized (CartController.class) {
				if (cartController == null) {
					cartController = new CartController();
				}
			}
		}

		return cartController;
	}

	/**
	 * Display the details of Product present in Cart
	 */
	public void displayCart() {
		DisplayOutput.getInstance().displayOutput(CartFacade.getInstance());
	}

	/**
	 * 
	 * @param productId
	 * @return true if product present in cart else false
	 */
	public boolean isProductPresentInCart(int productId) {
		return CartFacade.getInstance().isProductPresentInCart(productId);
	}

	/**
	 * 
	 * @return true if Cart is Empty else false
	 */
	public boolean isCartEmpty() {
		return CartFacade.getInstance().isCartEmpty();
	}

	/**
	 * Add product to cart
	 * 
	 * @param productId
	 * @param quantity
	 *            - quantity of Product
	 */
	public void addProductToCart(int productId, int quantity) {
		DisplayOutput.getInstance().displayOutput(
				CartFacade.getInstance().addProductToCartByProductId(productId,
						quantity));
	}

	/**
	 * Remove product from cart bby product Id
	 * 
	 * @param productId
	 */
	public void removeProductFromCart(int productId) {
		DisplayOutput.getInstance().displayOutput(
				CartFacade.getInstance().removeProductFromCartByProductId(
						productId));
	}

	/**
	 * Edit product quantity of product present in cart
	 * 
	 * @param productId
	 * @param quantity
	 *            - product quantity
	 */
	public void editProductFromCart(int productId, int quantity) {
		DisplayOutput.getInstance().displayOutput(
				CartFacade.getInstance().editCartProduct(productId, quantity));
	}

	/**
	 * Generate final bill
	 * 
	 * @param name
	 *            - Billing name
	 */
	public void generateBill(String name) {
		DisplayOutput.getInstance().displayOutput(
				BillGeneratorFacade.getInstance().getBill(name));
	}
}
