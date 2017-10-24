package com.metacube.view;

import java.util.Scanner;
import com.metacube.controller.LibraryController;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		LibraryController controller = new LibraryController();
		int choice;
		Scanner scan = new Scanner(System.in);
		Boolean exit = false;
		while (exit != true) {
			System.out
					.println("\nSelect Your Choice\n1.Display List\n2.Check Book Available\n3.Delete all those books which were not issued in last 1 year\n4.Exit");
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				System.out.println("1.Enter Author Name : ");
				System.out.println(controller.getTitlesPublishedByAuthor(scan
						.nextLine()));
				break;
			case 2:
				System.out.println("2.Enter Book Name : ");
				System.out
						.println(controller.isBookAvailable(scan.nextLine()).message);
				break;
			case 3:
				System.out.println(controller.deleteOldUnissuedBooks().message);
				break;
			case 4:
				System.out
						.println("********************************************* EXIT ******************************************");
				exit = true;
				scan.close();
				break;
			}
		}
	}
}