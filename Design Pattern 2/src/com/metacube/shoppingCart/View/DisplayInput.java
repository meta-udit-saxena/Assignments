package com.metacube.shoppingCart.View;

import java.util.Scanner;

import com.metacube.shoppingCart.Facade.CartFacade;
import com.metacube.shoppingCart.controller.CartController;

/**
 * Responsible for Displaying Option and taking input from console
 * 
 * @author Udit Saxena
 * 
 */
public class DisplayInput {
	private Scanner scan;
	private static DisplayInput input;

	/**
	 * Creating the DisplayInput class singleton
	 * 
	 * @return the Instance of DisplayInput
	 */
	public static DisplayInput getInstance() {
		if (input == null) {
			synchronized (DisplayInput.class) {
				if (input == null) {
					input = new DisplayInput();
				}
			}
		}

		return input;
	}

	/**
	 * Display the main menu
	 */
	public void displayInput() {
		boolean exit = false;
		scan = new Scanner(System.in);
		System.out.println("Enter your name");
		while (!exit) {
			System.out.println("1.Display Product");
			System.out.println("2.Buy Product");
			System.out.println("3.Cart");
			System.out.println("4.Exit");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				CartController.getInstance().displayProduct();
				break;
			case 2:
				buyProduct();
				break;
			case 3:
				cart();
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Enter correct choice");
			}
		}
	}

	/**
	 * Display the cart menu
	 */
	private void cart() {
		boolean back = false;
		while (!back) {
			System.out.println("1.Display Cart");
			System.out.println("2.Remove Product From Cart");
			System.out.println("3.Edit Product in Cart");
			System.out.println("4.Checkout");
			System.out.println("5.Back");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				CartController.getInstance().displayCart();
				break;
			case 2:
				removeProduct();
				break;
			case 3:
				editProduct();
				break;
			case 4:
				checkout();
				break;
			case 5:
				back = true;
				break;
			case 6:
				System.out.println("Enter Correct Choice :-");
			}
		}
	}

	/**
	 * Checkout nad call generate Bill
	 */
	private void checkout() {
		System.out.println("Enter your Name :");
		scan.nextLine();
		CartController.getInstance().generateBill(scan.nextLine());
	}

	/**
	 * Edit product from cart
	 */
	private void editProduct() {
		System.out.println("Enter Product Id - ");
		int productId = scan.nextInt();
		if (!CartFacade.getInstance().isCartEmpty()) {
			while (!CartFacade.getInstance().isProductPresentInCart(productId)) {
				System.out.println("Enter Product Id - ");
				productId = scan.nextInt();
			}
			System.out.println("Enter new Quantity of Product");
			int quantity = scan.nextInt();
			CartController.getInstance().editProductFromCart(productId,
					quantity);
		} else {
			DisplayOutput.getInstance().displayOutput("Cart Is Empty");
		}
	}

	/**
	 * Remove product from cart
	 */
	private void removeProduct() {
		System.out.println("Enter Product Id - ");
		int productId = scan.nextInt();
		if (!CartFacade.getInstance().isCartEmpty()) {
			while (!CartFacade.getInstance().isProductPresentInCart(productId)) {
				System.out.println("Enter Product Id - ");
				productId = scan.nextInt();
			}
			CartController.getInstance().removeProductFromCart(productId);
		} else {
			DisplayOutput.getInstance().displayOutput("Cart Is Empty");
		}
	}

	/**
	 * Buy Product or add Product to Cart
	 */
	private void buyProduct() {
		System.out.println("Enter Number of Product :- ");
		int numberOfProduct = scan.nextInt();
		while (!CartController.getInstance().isValidNumberOfProduct(
				numberOfProduct)) {
			System.out.println("Enter Valid Number of Product :- ");
			numberOfProduct = scan.nextInt();
		}
		for (int number = 1; number <= numberOfProduct; number++) {
			System.out.println("Enter " + number + " Product Id");
			int productId = scan.nextInt();
			while (!CartController.getInstance().isValidProductId(productId)) {
				System.out.println("Enter Valid Product Id");
				productId = scan.nextInt();
			}
			System.out.println("Enter product Quantity");
			int quantity = scan.nextInt();
			CartController.getInstance().addProductToCart(productId, quantity);
		}
	}
}
