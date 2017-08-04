import java.util.Scanner;
/**
 * Drives all the functionality through main Class
 * @author Udit Saxena
 *
 */
public class ShoppingMall {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		ProductPromo productPromo = new ProductPromo();
		BillGenerator billGenerator = new BillGenerator();
		Cart cart = new Cart();
		Store store = new Store();
		OrderPromo orderPromo = new OrderPromo();
		int numberOfProduct = 0;
		int quantity = 0;
		int productId = 0;
		System.out.println("Enter your First Name:");
		String name = scan.nextLine();
		System.out.println("Welcome " + name + " to Shopping Mall\n\n");
		System.out.println("List of Products Available: " + "\n");
		System.out.println(store);
		System.out.println("Offers Available on following Products: " + "\n");
		System.out.println(productPromo);
		System.out.println("Offers Available on Shopping : " + "\n");
		System.out.println(orderPromo);
		System.out.println("\nEnter Number of Products you want to buy: ");
		while (!scan.hasNextInt() || (numberOfProduct = scan.nextInt()) < 1) {
			System.out.println("Enter psoitive integer");
			scan.nextLine();
		}
		for (int loop = 0; loop < numberOfProduct; loop++) {
			System.out.println("Enter " + (loop + 1) + " Product Id");
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
		System.out.println(billGenerator.billCalculator(cart, productPromo,
				orderPromo, name));
		scan.close();
	}
}
