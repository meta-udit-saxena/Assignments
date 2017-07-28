package ShoppingStore;

/**
 * Extends the Product class and add more functionality - discount,quantity and
 * totalAmount
 * 
 * @author Udit Saxena
 *
 */
public class CartProducts extends Product {
	private double discount;
	private int quantity;

	/**
	 * Calculate the TotalAmount and return it
	 * 
	 * @return TotalAmount
	 */
	public double getTotalAmount() {
		return (this.getProductPrice() - this.discount) * (this.quantity);
	}

	public CartProducts(String productDetails) {
		super(productDetails);
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
