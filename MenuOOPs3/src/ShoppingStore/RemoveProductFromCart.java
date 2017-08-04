package ShoppingStore;

/**
 * Drive method removeProductFromCartByProductId() from Cart class
 * 
 * @author Udit saxena
 *
 */
public class RemoveProductFromCart {
	private Cart cart;

	/**
	 * Constructor initialize cart class object
	 * 
	 * @param cart
	 *            - cart class object
	 */
	public RemoveProductFromCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Return message to the console
	 * 
	 * @return String containing message
	 */
	public String removeProductFromCart() {
		return cart.removeProductFromCartByProductId();
	}

	/**
	 * Override to String method of String Class
	 */
	@Override
	public String toString() {
		return "\n-------" + removeProductFromCart() + "------\n";
	}
}
