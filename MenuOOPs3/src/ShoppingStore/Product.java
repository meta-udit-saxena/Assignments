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

	public Product(String productDetails) {
		String[] details = productDetails.split(",");
		productId = Integer.parseInt(details[0]);
		productName = details[1];
		productPrice = Double.parseDouble(details[2]);
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
