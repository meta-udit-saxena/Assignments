package ShoppingStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * keep the list of products a user has picked up from the store.
 * 
 * @author Udit Saxena
 * 
 */
public class Cart {
	private List<CartProducts> cartItems = new ArrayList<CartProducts>();
	private double orderLevelDiscount;
	private Scanner scan;

	/**
	 * getter for orderLevelDiscount
	 * 
	 * @return orderLevelDiscount
	 */
	public double getOrderLevelDiscount() {
		return orderLevelDiscount;
	}
	
	/**
	 * Calculate final amount after applying all discount
	 * @return final amount
	 */
	public double getFinalAmount() {
		return getSubTotal() - getTotalProductLevelDiscount()
				- getOrderLevelDiscount();
	}

	/**
	 * setter for orderLevelDiscount
	 * 
	 * @param orderLevelDiscount
	 *            -discount offers on complete order
	 */
	public void setOrderLevelDiscount(double orderLevelDiscount) {
		this.orderLevelDiscount = orderLevelDiscount;
	}

	/**
	 * getter for sub total amount
	 * 
	 * @return subTotal
	 */
	public double getSubTotal() {
		double subTotal = 0;
		for (CartProducts products : cartItems) {
			subTotal += products.getProductPrice() * products.getQuantity();
		}
		return subTotal;
	}

	/**
	 * getter for totalProductLevelDiscount
	 * 
	 * @return totalProductLevelDiscount
	 */

	public double getTotalProductLevelDiscount() {
		double totalProductLevelDiscount = 0;
		for (CartProducts products : cartItems) {
			totalProductLevelDiscount += (products.getDiscount() * products
					.getQuantity());
		}
		return totalProductLevelDiscount;
	}

	/**
	 * setter for totalProductLevelDiscount
	 * 
	 * @param totalProductLevelDiscount
	 *            - sum of all discount available on product
	 */

	public void setCartItems(List<CartProducts> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * Adding product to cart by its product ID
	 * 
	 * @param store
	 *            - Store Class Object
	 * @param id
	 *            - product ID
	 * @param quantity
	 *            - quantity of product
	 */
	public void addProductToCartByProductId(Store store, int id, int quantity) {
		Product product = store.getProductByProductId(id);
		CartProducts cartProducts = getCartProductById(id);
		// if product already in cartItems only increase its quantity
		if (cartItems.contains(cartProducts)) {
			cartProducts.setQuantity(cartProducts.getQuantity() + quantity);
		}
		// else create new CartProducts object and add to cartItems
		else {
			CartProducts cartProduct = new CartProducts(product.getProductId()
					+ "," + product.getProductName() + ","
					+ product.getProductPrice());
			cartProduct.setQuantity(quantity);
			cartItems.add(cartProduct);
		}
	}

	/**
	 * remove product from cart By product Id
	 * 
	 * @return String
	 */
	public String removeProductFromCartByProductId() {
		scan = new Scanner(System.in);
		System.out.println("Enter product id You want to remove from cart :");
		int id = scan.nextInt();
		CartProducts product = getCartProductById(id);

		if (cartItems.contains(product)) {
			cartItems.remove(product);
			setOrderLevelDiscount(getOrderLevelDiscount()-(product.getTotalAmount()));
			return product.getProductId() + "  " + product.getProductName()
					+ "  removed from cart";
		} else {
			return "Product not present in Cart";
		}
	}

	/**
	 * Getting ChartProducts Object from cartItems list by product ID
	 * 
	 * @param id
	 *            -product ID
	 * @return product ChartProducts Class Object
	 */
	public CartProducts getCartProductById(int id) {
		CartProducts product = null;
		for (CartProducts p : cartItems) {
			if (p.getProductId() == id) {
				product = p;
				break;
			}
		}
		return product;
	}

	/**
	 * 
	 * @return cartItems - List of product present in cartItems
	 */
	public List<CartProducts> getCartItems() {
		return cartItems;
	}

	/**
	 * override toString method of String class
	 * 
	 * @return String containing details of products add on cart
	 */
	@Override
	public String toString() {
		if (cartItems.size() == 0) {
			return "\n----------Cart is Empty---------\n---------Buy some Product----------\n";
		}
		String result = "\n------------------------Your Products in cart------------------------\n\n";
		for (CartProducts product : cartItems) {
			result += product.getProductId()
					+ "  -->  "
					+ product.getProductName()
					+ "  -->  Price :  Rs "
					+ product.getProductPrice()
					+ "*"
					+ product.getQuantity()
					+ " = Rs "
					+ product.getProductPrice()
					* product.getQuantity()
					+ "  --> Discount : "
					+ product.getDiscount()
					+ "*"
					+ product.getQuantity()
					+ " = Rs "
					+ (product.getQuantity() * product.getDiscount())
					+ "  -->  Total Amount = "
					+ ((product.getProductPrice() - product.getDiscount()) * product
							.getQuantity()) + "\n";
		}
		return result;
	}
}
