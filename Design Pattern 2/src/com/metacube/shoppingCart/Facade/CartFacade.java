package com.metacube.shoppingCart.Facade;

import java.util.Set;

import com.metacube.shoppingCart.Dao.InMemoryCartDao;
import com.metacube.shoppingCart.Entity.CartProduct;
import com.metacube.shoppingCart.Entity.Product;
import com.metacube.shoppingCart.Enum.DBType;
import com.metacube.shoppingCart.Enum.Entity;
import com.metacube.shoppingCart.Enum.Status;
import com.metacube.shoppingCart.Factory.DaoFactory;

public class CartFacade {
	private static InMemoryCartDao cartItems = (InMemoryCartDao) DaoFactory
			.getBaseDaoForEntity(Entity.Cart, DBType.Inmemory);;
	private Status status;
	private static CartFacade cartFacade;

	private CartFacade() {
	}

	/**
	 * Creating the Cart Facade a Singleton class
	 * 
	 * @return the Instance of CartFacade
	 */
	public static CartFacade getInstance() {
		if (cartFacade == null) {
			synchronized (CartFacade.class) {
				if (cartFacade == null) {
					cartFacade = new CartFacade();
				}
			}
		}

		return cartFacade;
	}

	/**
	 * Reset the cart
	 */
	public static void resetCart() {
		cartItems.resetCartList();
	}

	/**
	 * Adding product to cart by its product ID
	 * 
	 * @param productId
	 *            - product ID
	 * @param quantity
	 *            - quantity of product
	 */
	public Status addProductToCartByProductId(int productId, int quantity) {
		cartItems = (InMemoryCartDao) DaoFactory.getBaseDaoForEntity(
				Entity.Cart, DBType.Inmemory);
		// if product already present in cart
		if (isProductPresentInCart(productId)) {
			CartProduct product = (CartProduct) cartItems.getList().get(
					productId);
			product.setQuantity(product.getQuantity() + quantity);
			status = Status.Updated;
		} else {
			Product productDetails = (Product) DaoFactory
					.getBaseDaoForEntity(Entity.Product, DBType.Inmemory)
					.getList().get(productId);
			String[] details = { String.valueOf(productDetails.getId()),
					productDetails.getProductName(),
					String.valueOf(productDetails.getProductPrice()) };
			CartProduct cartProduct = new CartProduct(details);
			cartProduct.setQuantity(quantity);
			cartItems.getList().put(productId, cartProduct);
			status = Status.Added;
		}

		return status;
	}

	/**
	 * getter for sub total amount
	 * 
	 * @return subTotal
	 */

	public double getSubTotal() {
		double subTotal = 0;
		CartProduct product;
		Set<Integer> productId = cartItems.getList().keySet();
		for (int id : productId) {
			product = (CartProduct) cartItems.getList().get(id);
			subTotal += product.getProductPrice() * product.getQuantity();
		}

		return subTotal;
	}

	/**
	 * remove product from cart By product Id
	 * 
	 * @return String
	 */
	public Status removeProductFromCartByProductId(int productId) {
		cartItems.getList().remove(productId);

		return Status.Removed;
	}

	/**
	 * Change the product quantity
	 * 
	 * @param id
	 *            - product Id
	 * @param quantity
	 *            Product quantity
	 */
	public Status editCartProduct(int productId, int quantity) {
		cartItems.editProductQuantity(productId, quantity);

		return Status.Updated;
	}

	/**
	 * Check is Cart Empty or not
	 * 
	 * @return true if cart is empty else false
	 */
	public boolean isCartEmpty() {
		boolean flag = true;
		if (cartItems.getList().size() > 0) {
			flag = false;
		}

		return flag;
	}

	/**
	 * Check is product present in cart or not
	 * 
	 * @param productId
	 * @return true if product present in cart
	 */
	public boolean isProductPresentInCart(int productId) {
		boolean flag = false;
		if (cartItems.getList().containsKey(productId)) {
			flag = true;
		}

		return flag;
	}

	/**
	 * override toString method of String class
	 * 
	 * @return String containing details of products add on cart
	 */
	@Override
	public String toString() {
		if (isCartEmpty() == true) {
			return "\n----------Cart is Empty---------\n---------Buy some Product----------\n";
		}
		CartProduct product;
		String result = "\n------------------------Your Products in cart------------------------\n\n";
		Set<Integer> productId = cartItems.getList().keySet();
		for (int id : productId) {
			product = (CartProduct) cartItems.getList().get(id);
			result += product.getId() + "  -->  " + product.getProductName()
					+ "  -->  Price = Rs " + product.getProductPrice()
					+ "  -->  Quantity = " + product.getQuantity()
					+ " untis  -->  Total Amount : "
					+ product.getProductPrice() + " * " + product.getQuantity()
					+ " = Rs " + product.getProductPrice()
					* product.getQuantity() + "\n";
		}

		return result;
	}
}
