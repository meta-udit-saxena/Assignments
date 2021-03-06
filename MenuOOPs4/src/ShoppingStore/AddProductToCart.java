package ShoppingStore;

import java.util.Scanner;

/**
 * Responsible for adding product to Cart
 * 
 * @author Udit Saxena
 * 
 */
public class AddProductToCart {
	private Scanner scan;
	private static Cart cart;
	private static ProductPromo productPromo;
	private static OrderPromo orderPromo;

	/**
	 * 
	 * @param cart
	 *            -Cart class object
	 * @param productPromo
	 *            -ProductPromo Class Object
	 * @param orderPromo
	 *            -OrderPromo class Object
	 */
	public AddProductToCart(Cart cart, ProductPromo productPromo,
			OrderPromo orderPromo) {
		this.cart = cart;
		this.productPromo = productPromo;
		this.orderPromo = orderPromo;
	}

	/**
	 * Take input from user and add that products in Cart
	 */
	public void addToCart() {
		scan = new Scanner(System.in);
		Store store = new Store();
		int numberOfProduct = 0;
		int quantity = 0;
		int productId = 0;
		System.out.println("\nEnter Number of Products you want to buy: ");
		while (!scan.hasNextInt() || (numberOfProduct = scan.nextInt()) < 1
				|| numberOfProduct > store.getTotalNoOfProductInStore()) {
			if (numberOfProduct > store.getTotalNoOfProductInStore()) {
				System.out
						.println("Number of product is greater than product present in Store");
				System.out.println("Number of product in store :"
						+ store.getTotalNoOfProductInStore());
			} else {
				System.out.println("Enter psoitive integer");
			}
			scan.nextLine();
		}
		for (int loop = 1; loop <= numberOfProduct; loop++) {
			System.out.println("Enter " + loop + " Product Id");
			while (!scan.hasNextInt()
					|| !store.isValidProductId(productId = scan.nextInt())) {
				System.out.println("Enter Valid product Id");
				scan.nextLine();
			}
			System.out.println("Enter Quantity of Product:");
			while (!scan.hasNextInt() || (quantity = scan.nextInt()) < 1) {
				System.out.println("Enter psoitive integer");
				scan.nextLine();
			}
			cart.addProductToCartByProductId(store, productId, quantity);
		}
		productPromo.setDiscount(cart);
	}

	/**
	 * OverRiding toString method of String Class
	 */
	@Override
	public String toString() {
		addToCart();
		return "\n----------Add to cart Successfully-------------------\n";

	}
}
