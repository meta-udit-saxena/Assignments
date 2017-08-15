package com.metacube.shoppingCart.Entity;

/**
 * CartProduct class extends Product class
 * 
 * @author Udit Saxena
 * 
 */
public class CartProduct extends Product {

	private int quantity;

	/**
	 * Call super constructor
	 * 
	 * @param productDetails
	 *            - string array of product details
	 */
	public CartProduct(String[] productDetails) {
		super(productDetails);
	}

	/**
	 * @return quantity of the product
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Set Quantity of Product
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
