package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class DefaultProductService.
 */
@Service("productService")
@Transactional
public class DefaultProductService implements ProductService {

	/** The product dao. */
	@Resource(name = "hibernateProductDao")
	ProductDao productDao;

	public DefaultProductService(){
		
	}
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
	 * Gets the product dao.
	 *
	 * @return the product dao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * Sets the product dao.
	 *
	 * @param productDao
	 *            the new product dao
	 */
	public void setProductDao(ProductDao productDao) {
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
