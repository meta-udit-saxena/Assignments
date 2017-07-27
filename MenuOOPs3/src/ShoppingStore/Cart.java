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
	private double subTotal;
	private double totalProductLevelDiscount;
	private double finalAmount;
	private Scanner scan;

	/**
	 * getter for orderLevelDiscount
	 * 
	 * @return orderLevelDiscount
	 */
	public double getOrderLevelDiscount() {
		return orderLevelDiscount;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
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
		CartProducts cartProducts = getChartProductById(id);
		// if product already in cartItems only increase its quantity
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
	
	public String removeProductFromCartByProductId()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter product id You want to remove from cart :");
		int id = scan.nextInt();
		CartProducts product=getChartProductById(id);

		if(cartItems.contains(product)){
		cartItems.remove(product);
		return product.getProductId()+"  "+product.getProductName()+ "  removed from cart";
		}else
		{
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
		cart.setSubTotal(Double.parseDouble(String.format("%2f",subTotal)));
		cart.setTotalProductLevelDiscount(Double.parseDouble(String.format("%2f",totalProductLevelDiscount)));
	}

	/**
	 * override toString method of String class
	 * 
	 * @return String containing details of products add on cart
	 */
	@Override
	public String toString() {
		if(cartItems.size()==0){
			return "\n----------Cart is Empty---------\n---------Buy some Product----------\n";
		}
		String result = "\n----------Your Products in cart----------\n";
		for (CartProducts product : cartItems) {
			result += product.getProductId() + "  -->  "
					+ product.getProductName() + "  -->  Price =  Rs "
					+ product.getProductPrice() + "*" + product.getQuantity()
					+ " = Rs " + product.getProductPrice() * product.getQuantity()
					+ "  --> Discount = " + product.getDiscount() + "*"
					+ product.getQuantity() + " = Rs " + product.getQuantity()
					* product.getDiscount() + "  -->  Total Amount = "
					+ (product.getProductPrice() - product.getDiscount())
					* product.getQuantity() + "\n";
		}
		return result;
	}
}
