package com.metacube.shoppingCart.controller;

import com.metacube.shoppingCart.Facade.BillGeneratorFacade;
import com.metacube.shoppingCart.Facade.CartFacade;
import com.metacube.shoppingCart.Facade.StoreFacade;
import com.metacube.shoppingCart.View.DisplayOutput;

/**
 * Cart Controller Class
 * 
 * @author Udit Saxena
 */
public class CartController {
	private static CartController cartController;

	/**
	 * Create a singelton Class
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
	 * Display the Product Available In Store
	 */
	public void displayProduct() {
		DisplayOutput.getInstance().displayOutput(StoreFacade.getInstance());
	}

	/**
	 * Display the details of Product present in Cart
	 */
	public void displayCart() {
		DisplayOutput.getInstance().displayOutput(CartFacade.getInstance());
	}

	/**
	 * @param productId
	 * @return true if product Id is valid else false;
	 */
	public boolean isValidProductId(int productId) {

		return StoreFacade.getInstance().isValidProductId(productId);
	}

	/**
	 * @param numberOfProduct
	 *            - Number of Product
	 * @return true if input number is Valid else false
	 */
	public boolean isValidNumberOfProduct(int numberOfProduct) {
		boolean flag = false;
		if (StoreFacade.getInstance().getTotalNoOfProductInStore() >= numberOfProduct) {
			flag = true;
		}

		return flag;
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
				BillGeneratorFacade.getInstance().display(name));
	}
}
