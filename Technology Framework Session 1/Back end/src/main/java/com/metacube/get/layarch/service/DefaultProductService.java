package com.metacube.get.layarch.service;

import com.metacube.get.layarch.dao.product.ProductDao;
import com.metacube.get.layarch.enums.Status;
import com.metacube.get.layarch.model.Product;

/**
 * The Class DefaultProductService.
 */
public class DefaultProductService implements ProductService {

	/** The product dao. */
	ProductDao productDao;

	/**
	 * Instantiates a new default product service.
	 *
	 * @param productDao
	 *            the product dao
	 */
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/**
	 * Gets the all products.
	 *
	 * @return the all products
	 */
	@Override
	public Iterable<Product> getAllProducts() {
		return productDao.findAll();
	}

	/**
	 * Gets the dashboard products.
	 *
	 * @return the all products
	 */
	@Override
	public Iterable<Product> getDashboardProducts() {
		return productDao.findDashboard();
	}

	/**
	 * Gets the product by id.
	 *
	 * @param id
	 *            the id
	 * @return the product by id
	 */
	@Override
	public Product getProductById(int id) {
		return productDao.findOne(id);
	}

	/**
	 * Delete product by id.
	 *
	 * @param id
	 *            the id
	 * @return the status
	 */
	@Override
	public Status deleteProductById(int id) {
		return productDao.delete(id);
	}

	/**
	 * Adds the product.
	 *
	 * @param entity
	 *            the entity
	 * @return the status
	 */
	@Override
	public Status addProduct(Product entity) {
		return productDao.add(entity);
	}

	/**
	 * Update product.
	 *
	 * @param entity
	 *            the entity
	 * @param id
	 *            the id
	 * @return the status
	 */
	@Override
	public Status updateProduct(Product entity, int id) {
		return productDao.updateProduct(entity, id);
	}
}
