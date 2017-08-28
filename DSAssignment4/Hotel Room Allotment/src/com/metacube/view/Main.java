package com.metacube.view;

import java.util.Scanner;
import com.metacube.controller.RoomAllocation;
import com.metacube.entity.Guest;

/**
 * The Class Main contains menu.
 */
public class Main {
	private static Scanner scan;

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("Enter Total Number of Rooms in Hotel");
		RoomAllocation roomAllocation = new RoomAllocation(scan.nextInt());
		do {
			System.out.println("\n1. Add Guests");
			System.out.println("2. See Guest Information");
			System.out.println("3. See All Guest Information");
			System.out.println("4. Exit");
			System.out.println("enter your choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				addGuests(roomAllocation);
				break;
			case 2:
				guestInformation(roomAllocation);
				break;
			case 3:
				String result = roomAllocation.getAllGuest();
				System.out.println(result);
				break;
			case 4:
				scan.close();
				System.exit(0);
				break;
			}
		} while (true);
	}

	/**
	 * Adds the guests.
	 *
	 * @param roomAllocation
	 *            the roomAllocation class object
	 */
	private static void addGuests(RoomAllocation roomAllocation) {
		System.out.println("Enter total guests");
		int numberOfGuests = scan.nextInt();
		for (int index = 0; index < numberOfGuests; index++) {
			System.out.println("Enter name of guest " + (index + 1));
			String name = scan.next();
			System.out.println("Enter age of guest " + (index + 1));
			int age = scan.nextInt();
			if(!roomAllocation.addGuest(age, name)){
				System.err.println("Room Not Available");
				break;
			}
		}
	}

	/**
	 * Guest information.
	 *
	 * @param roomAllocation
	 *            the roomAllocation class object
	 */
	private static void guestInformation(RoomAllocation roomAllocation) {
		System.out.println("Enter name of guest");
		String name = scan.next();
		System.out.println("Enter age of guest");
		int age = scan.nextInt();
		Guest guest = roomAllocation.getGuest(age, name);
		if (guest != null) {
			System.out.println("\nName : " + guest.getName() + "\tAge : "
					+ guest.getAge() + "\tRoomNo. : " + guest.getRoomNumber());
		} else {
			System.out.println("Guest information is invalid !!");
		}
	}
}
