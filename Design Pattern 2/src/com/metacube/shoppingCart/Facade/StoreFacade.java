package com.metacube.shoppingCart.Facade;

import java.util.Set;
import com.metacube.shoppingCart.Dao.BaseDao;
import com.metacube.shoppingCart.Entity.Product;
import com.metacube.shoppingCart.Enum.DBType;
import com.metacube.shoppingCart.Enum.Entity;
import com.metacube.shoppingCart.Factory.DaoFactory;

/**
 * responsible for all operation of Store
 * 
 * @author Udit Saxena
 * 
 */
public class StoreFacade {

	private BaseDao productList;
	private static StoreFacade storeFacade;

	/**
	 * private constructor of StoreFacade class initializing the productList
	 */
	private StoreFacade() {
		productList = DaoFactory.getBaseDaoForEntity(Entity.Product,
				DBType.Inmemory);
	}

	/**
	 * Creating Store Facade a singleton
	 * 
	 * @return the Instance of Store Facade
	 */
	public static StoreFacade getInstance() {
		if (storeFacade == null) {
			synchronized (StoreFacade.class) {
				if (storeFacade == null) {
					storeFacade = new StoreFacade();
				}
			}
		}

		return storeFacade;
	}

	/**
	 * @return the total number of Product Present in Cart
	 */
	public int getTotalNoOfProductInStore() {
		return productList.getList().size();
	}

	/**
	 * Check whether given id is valid or not
	 * 
	 * @param productId
	 *            - ProductId
	 * @return true if product available in store having given id else false
	 */
	public boolean isValidProductId(int productId) {
		boolean flag = false;
		if (productList.getList().containsKey(productId)) {
			flag = true;
		}

		return flag;
	}

	/**
	 * Overriding toString method of String class
	 * 
	 * @return String containing details of all product available in store
	 */
	@Override
	public String toString() {
		String result = "";
		Product product;
		Set<Integer> productId = productList.getList().keySet();
		for (int id : productId) {
			product = (Product) productList.getList().get(id);
			result += "Product Id : " + product.getId() + "  -->  "
					+ product.getProductName() + "  -->  Rs "
					+ product.getProductPrice() + "\n";

		}

		return result;
	}
}