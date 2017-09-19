package com.metacube.controller;

import com.metacube.entity.Guest;
import com.metacube.hashtable.MyHashTable;

/**
 * The Class RoomAllocation .
 */
public class RoomAllocation {
	private MyHashTable<Integer, Guest> hashTable;

	/**
	 * Instantiates a new room allocation.
	 *
	 * @param totalRooms
	 *            the total rooms
	 */
	public RoomAllocation(int totalRooms) {
		hashTable = new MyHashTable<Integer, Guest>(totalRooms);
	}

	/**
	 * Adds the guest.
	 *
	 * @param age
	 *            the age
	 * @param name
	 *            the name
	 */
	public boolean addGuest(int age, String name) {
		if (age == 0 || name == null) {
			return false;
		}

		return hashTable.insertValue(age, new Guest(name, age));
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
		if (age == 0 || name == null) {
			return null;
		}

		return hashTable.getValue(age, name);
	}

	/**
	 * Gets the all guest.
	 *
	 * @return the all guest
	 */
	public String getAllGuest() {
		return hashTable.getAllValues().toString();
	}
}
