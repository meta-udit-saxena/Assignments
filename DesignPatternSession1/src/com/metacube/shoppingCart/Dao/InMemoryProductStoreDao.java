package com.metacube.shoppingCart.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Constants;
import util.FileHandling;

import com.metacube.shoppingCart.Entity.BaseEntity;
import com.metacube.shoppingCart.Entity.Product;

/**
 * Responsible for all the in memory operations of Store
 * 
 * @author Udit Saxena
 */
public class InMemoryProductStoreDao implements ProductStoreDao {
	private static Map<Integer, BaseEntity> productList;
	private static InMemoryProductStoreDao productDao;

	/**
	 * private constructor call the Product List initializer
	 */
	private InMemoryProductStoreDao() {
		initProductList();
	}

	/**
	 * Creating InMemoryProductStoreDao sigleton class
	 * 
	 * @return the Instance of InMemoryProductStoreDao
	 */
	public static InMemoryProductStoreDao getInstance() {
		if (productDao == null) {
			synchronized (InMemoryProductStoreDao.class) {
				if (productDao == null) {
					productDao = new InMemoryProductStoreDao();
				}
			}
		}

		return productDao;
	}

	/**
	 * Initializing the product List from file
	 */
	public void initProductList() {
		productList = new HashMap<Integer, BaseEntity>();
		List<String> productsDetails = FileHandling.getInstance().read(
				Constants.PRODUCT_LIST_PATH);
		for (String str : productsDetails) {
			String[] details = str.split(",");
			productList.put(Integer.parseInt(details[0]), new Product(details));
		}
	}

	/**
	 * Add product to the list
	 * 
	 * @param entityId
	 * @param entity
	 *            - BaseEntity Object
	 */
	public void add(int productId, BaseEntity product) {
		productList.put(productId, product);
	}

	/**
	 * Remove product from the list
	 * 
	 * @param productId
	 */
	public void remove(int productId) {
		productList.remove(productId);
	}

	/**
	 * @return the Map of productList
	 */
	public Map<Integer, BaseEntity> getList() {
		return productList;
	}
}
