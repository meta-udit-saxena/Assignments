package com.metacube.shoppingCart.Entity;

/**
 * Product class
 * @author Udit Saxena
 *
 */
public class Product implements BaseEntity {
	private int productId;
	private String productName;
	private double productPrice;

	public Product(String[] details) {
		productId = Integer.parseInt(details[0]);
		productName = details[1];
		productPrice = Double.parseDouble(details[2]);
	}

	/**
	 * @return the productId
	 */
	public int getId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
