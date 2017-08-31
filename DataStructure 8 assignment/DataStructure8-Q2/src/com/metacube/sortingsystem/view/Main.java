package com.metacube.sortingsystem.view;

import java.util.Arrays;
import java.util.Scanner;
import com.metacube.sortingsystem.controller.SortingSystemController;
import com.metacube.sortingsystem.dto.ControllerResponse;

public class Main {
	static Scanner scan;

	public static void main(String[] args) {
		scan = new Scanner(System.in);
		SortingSystemController controller = new SortingSystemController();
		int[] inputArray = null;
		boolean exit = false;
		while (!exit) {
			System.out
			.println("\n1.Enter Array\n2.Comparision Sort\n3.Linear Sort\n4.Exit");
			switch (getValidInteger()) {
			case 1:
				inputArray = getArrayFromUser();
				break;
			case 2:
				controller.doComparisonSort(inputArray);
				break;
			case 3:
				controller.doLinearSort(inputArray);
				break;
			case 4:
				exit = true;
				break;
			default:
				System.err.println("Enter Correct Choice");
			}
		}
	}

	private static int getValidInteger() {
		while (scan.hasNextInt() == false) {
			System.out.println("Enter positive Integers");
			scan.next();
		}
		return scan.nextInt();
	}

	private static int[] getArrayFromUser() {
		System.out.println("Enter Number of Element in Array");
		int[] array = new int[getValidInteger()];
		System.out.println("Enter Elements of Array");
		for (int index = 0; index < array.length; index++) {
			array[index] = getValidInteger();
		}

		return array;
	}

	public void displayResponse(ControllerResponse response) {
		System.out.print(response.message + " : ");
		System.out.println(Arrays.toString(response.sortedArray));
	}
}