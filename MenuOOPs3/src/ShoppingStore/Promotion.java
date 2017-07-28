package ShoppingStore;

/**
 * Promotion Interface which implements by all Promotion Classes
 * 
 * @author goku
 * 
 */
public interface Promotion {
	/**
	 * If product is valid for discount or not
	 * 
	 * @param id
	 *            - Product Id
	 * @return true if valid else false
	 */
	boolean isApplicable(double id);

	/**
	 * Set discount fom each product and for final order
	 * 
	 * @param cart
	 *            - Cart class object
	 */
	void setDiscount(Cart cart);
}
