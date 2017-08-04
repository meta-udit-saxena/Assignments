import java.util.ArrayList;
import java.util.List;

public class Store {
	private List<Product> products = new ArrayList<Product>();

	public Store() {
		this.initStoreItems();
	}

	/**
	 * Read from product file and initializing product class object and add to
	 * products List
	 */
	public void initStoreItems() {
		List<String> productsDetails = new FileHandling()
				.read(Constants.PRODUCT_LIST_PATH);
		for (String str : productsDetails) {
			String[] details = str.split(",");
			this.products.add(new Product(details[0], details[1], details[2]));
		}
	}

	/**
	 * @return products list
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * Check whether given id is valid or not
	 * 
	 * @param id
	 *            - ProductId
	 * @return true if product available in store having given id else false
	 */
	public boolean isIdValid(int id) {
		for (Product product : products) {
			if (product.getProductId() == id) {
				return true;
			}
		}
		return false;
	}

	/**
	 * It return product from store by its id
	 * 
	 * @param id
	 *            - ProductId
	 * @return product Product Class Object
	 */
	public Product getProductByProductId(int id) {
		Product product = new Product();
		for (Product p : products) {
			if (p.getProductId() == id) {
				product = p;
				break;
			}
		}
		return product;
	}

	/**
	 * Overriding toString method of String class
	 * 
	 * @return String containing details of all product available in store
	 */
	@Override
	public String toString() {
		String result = "";
		for (Product product : products) {

			result += "Product Id : " + product.getProductId() + "  -->  "
					+ product.getProductName() + "  -->  Rs "
					+ product.getProductPrice() + "\n";
		}
		return result;
	}
}
