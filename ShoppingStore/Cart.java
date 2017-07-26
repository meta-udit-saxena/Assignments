import java.util.ArrayList;
import java.util.List;

/**
 * keep the list of products a user has picked up from the store.
 * 
 * @author Udit Saxena
 * 
 */
public class Cart {
	private List<CartProducts> cartItems = new ArrayList<CartProducts>();
	private double orderLevelDiscount;
	private double subTotal;
	private double totalProductLevelDiscount;

	/**
	 * getter for orderLevelDiscount
	 * 
	 * @return orderLevelDiscount
	 */
	public double getOrderLevelDiscount() {
		return orderLevelDiscount;
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
		return subTotal;
	}

	/**
	 * setter for sub total amount
	 * 
	 * @param subTotal
	 *            - sum of amount of all product
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * getter for totalProductLevelDiscount
	 * 
	 * @return totalProductLevelDiscount
	 */
	public double getTotalProductLevelDiscount() {
		return totalProductLevelDiscount;
	}

	/**
	 * setter for totalProductLevelDiscount
	 * 
	 * @param totalProductLevelDiscount
	 *            - sum of all discount available on product
	 */
	public void setTotalProductLevelDiscount(double totalProductLevelDiscount) {
		this.totalProductLevelDiscount = totalProductLevelDiscount;
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
		CartProducts cartProducts = getChartProductById(id);
		// if product already in cartItems obly increase its quantity
		if (cartItems.contains(cartProducts)) {
			cartProducts.setQuantity(cartProducts.getQuantity() + quantity);
		}
		// else create new CartProducts object and add to cartItems
		else {
			CartProducts cartProduct = new CartProducts(String.valueOf(product
					.getProductId()), String.valueOf(product.getProductName()),
					String.valueOf(product.getProductPrice()));
			cartProduct.setQuantity(quantity);
			cartItems.add(cartProduct);
		}
	}

	/**
	 * Getting ChartProducts Object from cartItems list by product ID
	 * 
	 * @param id
	 *            -product ID
	 * @return product ChartProducts Class Object
	 */
	public CartProducts getChartProductById(int id) {
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
	 * calculate the total amount and set subTotal and TotalProductLevelDiscount
	 * 
	 * @param cart
	 *            - Cart class object
	 */
	public void calculateTotal(Cart cart) {
		double subTotal = 0;
		double totalProductLevelDiscount = 0;
		for (CartProducts products : cart.getCartItems()) {
			subTotal += products.getProductPrice() * products.getQuantity();
			totalProductLevelDiscount += products.getDiscount()
					* products.getQuantity();
		}
		cart.setSubTotal(subTotal);
		cart.setTotalProductLevelDiscount(totalProductLevelDiscount);
	}

	/**
	 * override toString method of String class
	 * 
	 * @return String containing details of products add on cart
	 */
	@Override
	public String toString() {
		String result = "";
		for (CartProducts product : cartItems) {
			result += product.getProductId() + "  -->  "
					+ product.getProductName() + "  -->  "
					+ product.getProductPrice() + "*" + product.getQuantity()
					+ " = " + product.getProductPrice() * product.getQuantity()
					+ "  --> " + product.getDiscount() + "*"
					+ product.getQuantity() + " = " + product.getQuantity()
					* product.getDiscount() + "  -->  "
					+ (product.getProductPrice() - product.getDiscount())
					* product.getQuantity() + "\n";
		}
		return result;
	}
}
