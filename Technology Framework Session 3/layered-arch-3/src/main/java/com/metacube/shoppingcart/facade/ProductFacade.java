package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Interface ProductFacade.
 */
public interface ProductFacade {
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	Iterable<ProductDto> getAllProducts();

	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	Iterable<ProductDto> getDashboardProducts();

	/**
	 * Gets the product by id.
	 *
	 * @param id
	 *            the id
	 * @return the product by id
	 */
	ProductDto getProductById(int id);

	/**
	 * Delete product by id.
	 *
	 * @param id
	 *            the id
	 * @return the status
	 */
	Status deleteProductById(int id);

	/**
	 * Adds the product.
	 *
	 * @param entity
	 *            the entity
	 * @return the status
	 */
	Status addProduct(Product entity);

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
