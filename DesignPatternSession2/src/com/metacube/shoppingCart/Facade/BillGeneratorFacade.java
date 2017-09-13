package com.metacube.shoppingCart.Facade;

import java.util.HashMap;
import java.util.Set;

import util.FileHandling;

import com.metacube.shoppingCart.Entity.BaseEntity;
import com.metacube.shoppingCart.Entity.CartProduct;
import com.metacube.shoppingCart.Enum.DBType;
import com.metacube.shoppingCart.Enum.Entity;
import com.metacube.shoppingCart.Factory.DaoFactory;

/**
 * Responsible for Generating the Bill
 * 
 * @author Udit Saxena
 * 
 */
public class BillGeneratorFacade {
	private static BillGeneratorFacade billGeneratorFacade;
	private static HashMap<Integer, BaseEntity> cartList;

	/**
	 * Private Constructor Initializing the cartListMap
	 */
	private BillGeneratorFacade() {
		cartList = (HashMap<Integer, BaseEntity>) DaoFactory
				.getBaseDaoForEntity(Entity.Cart, DBType.Inmemory).getList();
	}

	/**
	 * Creating BillGeneratorFacade a singleton
	 * 
	 * @return Instance of BillGeneratorFacade
	 */
	public static BillGeneratorFacade getInstance() {
		if (billGeneratorFacade == null) {
			synchronized (BillGeneratorFacade.class) {
				if (billGeneratorFacade == null) {
					billGeneratorFacade = new BillGeneratorFacade();
				}
			}
		}

		return billGeneratorFacade;
	}

	/**
	 * @return String containing purchase details
	 */
	private String purchaseProductDetails() {
		String output = "";
		CartProduct product;
		Set<Integer> productId = cartList.keySet();
		for (int id : productId) {
			product = (CartProduct) DaoFactory
					.getBaseDaoForEntity(Entity.Cart, DBType.Inmemory)
					.getList().get(id);
			output += "\nProduct : " + product.getId() + " - "
					+ product.getProductName() + "(" + product.getType()
					+ ")\n";
			output += "Cost : Rs "
					+ (product.getProductPrice() * product.getQuantity()) + "("
					+ product.getQuantity() + " X " + product.getProductPrice()
					+ ")\n";
		}

		return output;
	}

	/**
	 * 
	 * @return String containing final bill
	 */
	private String subTotalValue() {
		String output = "";
		output += "\n\nSubTotal : " + CartFacade.getInstance().getSubTotal()
				+ "\n";

		return output;
	}

	/**
	 * 
	 * @return String containing details of bill
	 */
	public String getBill(String name) {
		String display = "";
		String hashtag = "\n##########################################################################################\n";
		display += hashtag + "\n  Your Order " + name + " \n" + hashtag;
		display += "\nPURCHASE PRODUCTS :\n";
		display += purchaseProductDetails();
		display += subTotalValue();
		display += hashtag + "  THANK YOU " + hashtag;
		FileHandling.getInstance().write(display, name);
		CartFacade.resetCart();

		return display;
	}
}
