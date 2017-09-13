package com.metacube.shoppingCart.View;

import java.util.Scanner;

import com.metacube.shoppingCart.controller.CartController;
import com.metacube.shoppingCart.controller.StoreController;

/**
 * Responsible for Displaying Option and taking input from console
 * 
 * @author Udit Saxena
 * 
 */
public class DisplayInput {
	private static Scanner scan;
	private static DisplayInput input;
	private static int choice;

	private DisplayInput() {
	}

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
		scan = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("\n1.Display Product");
			System.out.println("2.Buy Product");
			System.out.println("3.Cart");
			System.out.println("4.Exit");
			System.out.println("Enter Your Choice:-");
			choice = getValidInteger("Enter Your Choice:-");
			switch (choice) {
			case 1:
				StoreController.getInstance().displayProduct();
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
				System.out.println("Enter correct choice\n");
			}
		}
	}

	/**
	 * Get the input until the user enter Integer
	 * 
	 * @param msg
	 *            - message display after error message
	 * @return integer
	 */
	private int getValidInteger(String msg) {
		while (!scan.hasNextInt() || (choice = scan.nextInt()) < 1) {
			System.out
					.print("Error ---> Enter Positive Integer Value:\n" + msg);
			scan.next();
		}

		return choice;
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
			System.out.println("Enter Your Choice:-");
			choice = getValidInteger("Enter Your Choice :-");
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
	 * Checkout and call generate Bill
	 */
	private void checkout() {
		if (!CartController.getInstance().isCartEmpty()) {
			System.out.println("Enter your Name :");
			scan.nextLine();
			CartController.getInstance().generateBill(scan.nextLine());
		} else {
			System.out
					.println("\n--------------No Product Available in Cart for Checkout-----------------\n");
		}
	}

	/**
	 * Edit product from cart
	 */
	private void editProduct() {
		if (!CartController.getInstance().isCartEmpty()) {
			System.out.println("Enter Product Id - ");
			int productId = getValidInteger("Enter Product Id -");
			while (!CartController.getInstance().isProductPresentInCart(
					productId)) {
				System.out.println("Enter Valid Product Id - ");
				productId = getValidInteger("Enter Product Id -");
			}
			System.out.println("Enter new Quantity of Product");
			int quantity = getValidInteger("Enter new Quantity of Product");
			CartController.getInstance().editProductFromCart(productId,
					quantity);
		} else {
			DisplayOutput.getInstance().displayOutput(
					"\n-----Cart Is Empty----\n");
		}
	}

	/**
	 * Remove product from cart
	 */
	private void removeProduct() {
		if (!CartController.getInstance().isCartEmpty()) {
			System.out.println("Enter Product Id - ");
			int productId = getValidInteger("Enter Product Id - ");
			while (!CartController.getInstance().isProductPresentInCart(
					productId)) {
				System.out.println("Enter Valid Product Id - ");
				productId = getValidInteger("Enter Product Id - ");
			}
			CartController.getInstance().removeProductFromCart(productId);
		} else {
			DisplayOutput.getInstance().displayOutput(
					"\n-----Cart Is Empty----\n");
		}
	}

	/**
	 * Buy Product or add Product to Cart
	 */
	private void buyProduct() {
		System.out.println("Enter Number of Product :- ");
		int numberOfProduct = getValidInteger("Enter Number of Product :- ");
		while (!StoreController.getInstance().isValidNumberOfProduct(
				numberOfProduct)) {
			System.out.println("Enter Valid Number of Product :- ");
			numberOfProduct = getValidInteger("Enter Number of Product :- ");
		}
		for (int number = 1; number <= numberOfProduct; number++) {
			System.out.println("Enter " + number + " Product Id");
			int productId = getValidInteger("Enter " + number + " Product Id");
			while (!StoreController.getInstance().isValidProductId(productId)) {
				System.out.println("Enter Valid Product Id");
				productId = getValidInteger("Enter " + number + " Product Id");
			}
			System.out.println("Enter product Quantity");
			int quantity = getValidInteger("Enter product Quantity");
			CartController.getInstance().addProductToCart(productId, quantity);
		}
	}
}
