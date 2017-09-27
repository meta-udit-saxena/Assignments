package com.metacube.get.layarch.facade;

import com.metacube.get.layarch.dao.product.ProductDao;
import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.model.Product;


public interface ProductFacade {
	Iterable<ProductDto> getAllProducts();

	ProductDto getProductById(int id);
}
