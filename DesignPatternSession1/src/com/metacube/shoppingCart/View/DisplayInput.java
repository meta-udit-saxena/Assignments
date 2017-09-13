package com.metacube.shoppingCart.View;

import java.util.Scanner;

import com.metacube.shoppingCart.controller.StoreController;

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
		scan = new Scanner(System.in);
		StoreController.getInstance().displayProduct();
	}
}
