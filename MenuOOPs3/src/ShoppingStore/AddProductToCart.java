package ShoppingStore;

import java.util.Scanner;

/**
 * Drives all the functionality through main Class
 * 
 * @author Udit Saxena
 * 
 */
public class AddProductToCart {
	private static Cart cart;
	private static ProductPromo productPromo;
	private static OrderPromo orderPromo;

	public AddProductToCart(Cart cart, ProductPromo productPromo,
			OrderPromo orderPromo) {
		this.cart = cart;
		this.productPromo = productPromo;
		this.orderPromo = orderPromo;
	}

	private Scanner scan;

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
					|| !store.isIdValid(productId = scan.nextInt())) {
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
		cart.calculateTotal(cart);
		orderPromo.setDiscount(cart);
	}

	@Override
	public String toString() {
		addToCart();
		return "\n----------Add to cart Successfully-------------------\n";

	}
}
