import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import ShoppingStore.Bill;
import ShoppingStore.BillGenerator;
import ShoppingStore.Cart;
import ShoppingStore.CartProducts;
import ShoppingStore.OrderPromo;
import ShoppingStore.ProductPromo;
import ShoppingStore.AddProductToCart;
import ShoppingStore.Store;
import ShoppingStore.RemoveProductFromCart;

/**
 * Main class which creates , display and perform actions on Menu.
 * 
 * @author Udit Saxena
 * 
 */
public class Main {
	private static Cart cart = new Cart();
	private static OrderPromo orderPromo = new OrderPromo();
	private static ProductPromo productPromo = new ProductPromo();
	private static Store store = new Store();
	private static String userName;
	private static Scanner scan;

	/**
	 * Creates a Menu
	 * 
	 */
	public static Menu createMenu() {
		Menu mainMenu = new Menu();

		List<MenuItem> subMenu = mainMenu.getSubMenu();
		MenuItem displayProduct = new ActionableMenuItem<Store>(new Store());
		displayProduct.setDisplayName("1.Display Product List");
		subMenu.add(displayProduct);

		Menu promotionsMenu = new Menu();
		promotionsMenu.setDisplayName("2.Display Promotion List");
		subMenu.add(promotionsMenu);

		List<MenuItem> subPromotionMenu = ((Menu) promotionsMenu).getSubMenu();
		MenuItem ProductPromo = new ActionableMenuItem<ProductPromo>(
				new ProductPromo());
		ProductPromo.setDisplayName("1.Product Promotion");
		subPromotionMenu.add(ProductPromo);

		MenuItem OrderPromo = new ActionableMenuItem<OrderPromo>(
				new OrderPromo());
		OrderPromo.setDisplayName("2.Order Promotion");
		subPromotionMenu.add(OrderPromo);

		MenuItem back = new ActionableMenuItem<String>("");
		back.setDisplayName("3.Back");
		subPromotionMenu.add(back);
		MenuItem buyProduct = new Menu();
		buyProduct.setDisplayName("3.Buy Product");
		subMenu.add(buyProduct);

		List<MenuItem> cartMenu = ((Menu) buyProduct).getSubMenu();
		MenuItem addToCart = new ActionableMenuItem<AddProductToCart>(
				new AddProductToCart(cart, productPromo, orderPromo));
		addToCart.setDisplayName("1.Add to cart");
		cartMenu.add(addToCart);
		MenuItem removeFromCart = new ActionableMenuItem<RemoveProductFromCart>(
				new RemoveProductFromCart(cart));
		removeFromCart.setDisplayName("2.Remove Product from cart");
		cartMenu.add(removeFromCart);

		MenuItem displaycart = new ActionableMenuItem<Cart>(cart);
		displaycart.setDisplayName("3.Display cart");
		cartMenu.add(displaycart);
		MenuItem checkOut = new ActionableMenuItem<Bill>(new Bill(userName,
				cart, productPromo));
		checkOut.setDisplayName("4.CheckOut");
		cartMenu.add(checkOut);
		MenuItem cartBack = new ActionableMenuItem<String>("");
		cartBack.setDisplayName("5.Back");
		cartMenu.add(cartBack);
		return mainMenu;

	}

	/**
	 * Display the menu and perform function as per given choice.
	 * 
	 */
	public static void display(Menu menu) {
		Iterator<MenuItem> itr = menu.getSubMenu().iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next().getDisplayName());
		}
	}

	/**
	 * get user choice from Console
	 * 
	 * @return user enter choice
	 */
	public static int getInput(Menu menu) {
		Scanner scan = new Scanner(System.in);
		int choice;
		while (!scan.hasNextInt() || (choice = scan.nextInt()) < 1) {
			System.out.println("Enter psoitive integer\n");
			displayAndPerformAction(menu);
			scan.nextLine();
		}
		return choice - 1;
	}

	/**
	 * Displays menu and perform action according to choice.
	 */
	public static void displayAndPerformAction(Menu menu) {
		display(menu);
		int choice = getInput(menu);
		MenuItem menuItem = menu.getSelection(choice);
		if (menuItem == null) {
			displayAndPerformAction(menu);
		} else if (menuItem instanceof ActionableMenuItem) {

			((ActionableMenuItem<?>) menuItem).performAction();
			if (!menuItem.getDisplayName().contains("Back")) {
				displayAndPerformAction(menu);
			}
		} else {
			displayAndPerformAction((Menu) menuItem);
		}
	}

	public static void main(String args[]) {
		scan = new Scanner(System.in);
		System.out.println("Enter Your Name: ");
		userName = scan.nextLine();
		System.out.println("\n----------Welcome " + userName
				+ " to Shopping Mall----------\n");
		Menu menu = createMenu();
		while (true) {
			displayAndPerformAction(menu);
		}

	}
}
