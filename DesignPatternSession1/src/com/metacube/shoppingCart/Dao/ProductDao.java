package com.metacube.shoppingCart.Dao;

import java.util.List;

import com.metacube.shoppingCart.Model.Product;

public interface ProductDao extends BaseDao{
		public List<Product> getAllProducts();
}
