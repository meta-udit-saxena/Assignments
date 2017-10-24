package com.metacube.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Product.
 */
@Entity
@Table(name = "product")
public class Product {

	/** The id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The name. */
	@Column(name = "name")
	private String name;

	/** The description. */
	@Column(name = "description")
	private String description;

	/** The image path. */
	@Column(name = "imagePath")
	private String imagePath;

	/** The currency. */
	@Column(name = "currency")
	private String currency;

	/** The price. */
	@Column(name = "price")
	private double price;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the image path.
	 *
	 * @return the image path
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Sets the image path.
	 *
	 * @param string
	 *            the new image path
	 */
	public void setImagePath(String string) {
		this.imagePath = string;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency
	 *            the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price
	 *            the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

}
