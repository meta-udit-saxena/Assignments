/**
 * Extends the Product class and add more functionality - discount,quantity and totalAmount
 * @author Udit Saxena
 *
 */
public class CartProducts extends Product {
	private double discount;
	private int quantity;
	private double totalAmount;
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount() {
	//calculating totalAmount
		this.totalAmount=(this.getProductPrice()-this.discount)*this.quantity;
	}
	public CartProducts(String id, String name, String price) {
		super(id, name, price);
		
	}
	public CartProducts() {
		super();
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
