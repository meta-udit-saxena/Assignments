package ShoppingStore;

/**
 * Class containing product details
 * 
 * @author Udit Saxena
 * 
 */
public class Product {
	private int productId;
	private String productName;
	private double productPrice;

	public Product() {

	}

	public Product(String id, String name, String price) {
		productId = Integer.parseInt(id);
		productName = name;
		productPrice = Double.parseDouble(price);
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
}
