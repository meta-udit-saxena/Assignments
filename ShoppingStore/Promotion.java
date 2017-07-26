/**
 * Promotion Interface which implements by all Promotion Classes
 * 
 * @author goku
 * 
 */
public interface Promotion {
	boolean isApplicable(double id);

	void setDiscount(Cart cart);
}
