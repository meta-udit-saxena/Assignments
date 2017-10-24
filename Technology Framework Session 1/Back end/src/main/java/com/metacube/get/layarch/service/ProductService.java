package com.metacube.get.layarch.service;

import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * The Interface ProductService.
 */
public interface ProductService {

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	Iterable<Product> getAllProducts();
	
	/**
	 * Gets the dashboard products.
	 *
	 * @return the dashboard products
	 */
	Iterable<Product> getDashboardProducts();

	/**
	 * Gets the product by id.
	 *
	 * @param id
	 *            the id
	 * @return the product by id
	 */
	Product getProductById(int id);

	/**
	 * Adds the product.
	 *
	 * @param entity
	 *            the entity
	 * @return the status
	 */
	Status addProduct(Product entity);

	/**
	 * Delete product by id.
	 *
	 * @param id
	 *            the id
	 * @return the status
	 */
	Status deleteProductById(int id);

	/**
	 * Update product.
	 *
	 * @param entity
	 *            the entity
	 * @param id
	 *            the id
	 * @return the status
	 */
	Status updateProduct(Product entity, int id);
}