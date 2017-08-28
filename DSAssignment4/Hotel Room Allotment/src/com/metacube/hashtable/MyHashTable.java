package com.metacube.hashtable;

import java.util.ArrayList;
import java.util.List;

import com.metacube.entity.Guest;
import com.metacube.entity.MyHashNode;

/**
 * The Class MyHashTable contains Functions related to HashTable.
 *
 * @param <E>
 *            the element type
 * @param <V>
 *            the value type
 */
public class MyHashTable<E, V> {
	private E[] roomBucket;

	/**
	 * Instantiates a new my hash table.
	 *
	 * @param totalRooms
	 *            the total rooms
	 */
	public MyHashTable(int totalRooms) {
		roomBucket = (E[]) new Object[totalRooms];
	}

	/**
	 * Insert value into MyHashTable.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public boolean insertValue(E key, V value) {
		if (key == null || value == null) {
			return false;
		}
		int myKey = hashFunction(key);
		int count = roomBucket.length;
		while (roomBucket[myKey] != null & count != 0) {
			myKey = (myKey + 1) % roomBucket.length;
			count--;
		}
		if (count != 0) {
			MyHashNode<E, V> room = new MyHashNode<E, V>(
					(E) String.valueOf(myKey), value);
			roomBucket[myKey] = (E) room;
			if (value instanceof Guest) {
				((Guest) value).setRoomNumber(myKey + 1);
			}
			return true;
		}
		return false;
	}

	/**
	 * Hash function to generate Key.
	 *
	 * @param key
	 *            the key
	 * @return the hash value
	 */
	public int hashFunction(E key) throws NullPointerException {
		if (key == null) {
			throw new NullPointerException();
		}
		return key.hashCode() % roomBucket.length;
	}

	/**
	 * Gets the value related to the key.
	 *
	 * @param age
	 *            the age
	 * @param name
	 *            the name
	 * @return the value
	 */
	public V getValue(int age, String name) {
		for (int index = 0; index < roomBucket.length; index++) {
			if (roomBucket[index] != null) {
				Guest guest = (Guest) ((MyHashNode<E, V>) roomBucket[index])
						.getValue();
				if (guest.getName().equals(name) && guest.getAge() == age) {
					return ((MyHashNode<E, V>) roomBucket[index]).getValue();
				}
			}
		}

		return null;
	}

	/**
	 * Gets the all values
	 *
	 * @return the list of values
	 */
	public List<V> getAllValues() {
		List<V> allGuests = new ArrayList<V>();
		for (int index = 0; index < roomBucket.length; index++) {
			if (roomBucket[index] != null) {
				allGuests.add((V) ((MyHashNode<E, V>) roomBucket[index])
						.getValue());
			}
		}

		return allGuests;
	}
}
