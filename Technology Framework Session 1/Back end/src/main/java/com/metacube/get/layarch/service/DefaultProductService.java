package com.metacube.get.layarch.service;

import com.metacube.get.layarch.dao.product.ProductDao;
import com.metacube.get.layarch.model.Product;

public class DefaultProductService implements ProductService {
	ProductDao productDao;

	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Iterable<Product> getAllProducts() {
		return productDao.findAll();
	}

	@Override
	public Product getProductById(int id) {
		return productDao.findOne(id);
	}
}
