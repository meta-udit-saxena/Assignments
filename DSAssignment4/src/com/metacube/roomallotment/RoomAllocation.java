/** 
 * @author Udit Saxena
 * @project Room Allotment using Hash Table
 * 
 */
package com.metacube.roomallotment;

import java.util.List;

/**
 * The Class RoomAllocation.
 */
public class RoomAllocation {

	/** The hash table. */
	MyHashTable<Integer, Guest> hashTable = new MyHashTable<Integer, Guest>();

	/**
	 * Adds the guest.
	 *
	 * @param name
	 *            the name
	 * @param age
	 *            the age
	 */
	public void addGuest(String name, int age) {
		Guest guest = new Guest();
		guest.setName(name);
		guest.setAge(age);
		hashTable.insertValue(age, guest);
	}

	/**
	 * Gets the guest.
	 *
	 * @param age
	 *            the age
	 * @param name
	 *            the name
	 * @return the guest
	 */
	public Guest getGuest(int age, String name) {
		Guest guest = hashTable.getValue(age, name);
		return guest;
	}

	/**
	 * Gets the all guest.
	 *
	 * @return the all guest
	 */
	public String getAllGuest() {
		List<String> guests = hashTable.getAllValues();
		return "##################### \n \n " + guests.toString();
	}
}
