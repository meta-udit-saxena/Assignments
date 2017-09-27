package com.metacube.get.layarch.service;

import java.util.List;

import com.metacube.get.layarch.model.Product;

public interface ProductService {
	Iterable<Product> getAllProducts();

	Product getProductById(int id);
}
