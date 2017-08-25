/** 
 * @author Udit Saxena
 * @project Room Allotment using Hash Table
 * 
 */
package com.metacube.roomallotment;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class MyHashTable.
 *
 * @param <E>
 *            the element type
 * @param <V>
 *            the value type
 */
public class MyHashTable<E, V> {

	/** The room bucket. */
	private Object[] roomInfo;

	/**
	 * Instantiates a new my hash table.
	 */
	public MyHashTable() {
		roomInfo = new Object[13];
	}

	/**
	 * Insert value.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	@SuppressWarnings("unchecked")
	public void insertValue(E key, V value) {
		if (key == null || value == null) {
			throw new IllegalArgumentException();
		}
		MyHashNode<E, V> room = new MyHashNode<E, V>();
		int MyKey = hashFunction(key);
		if (roomInfo[MyKey] == null) {
			room.setKey((E) String.valueOf(MyKey));
			room.setValue(value);
			roomInfo[MyKey] = room;
			Guest guest = (Guest) ((MyHashNode<E, V>) roomInfo[MyKey])
					.getValue();
			guest.setRoom(MyKey + 1);

		} else {
			int index = 0;
			for (index = 0; index < roomInfo.length; index++) {
				if (roomInfo[index] == null && index != MyKey) {
					room.setKey((E) String.valueOf(index));
					room.setValue(value);
					roomInfo[index] = room;
					break;
				}
			}
			Guest guest = (Guest) ((MyHashNode<E, V>) roomInfo[index])
					.getValue();
			guest.setRoom(index + 1);
		}
	}

	/**
	 * Hash function.
	 *
	 * @param key
	 *            the key
	 * @return the int
	 */
	public int hashFunction(E key) {
		int hash = (int) key % roomInfo.length;
		return hash;
	}

	/**
	 * Gets the value.
	 *
	 * @param age
	 *            the age
	 * @param name
	 *            the name
	 * @return the value
	 */
	@SuppressWarnings("unchecked")
	public V getValue(int age, String name) {
		for (int index = 0; index < roomInfo.length; index++) {
			Guest guest = (Guest) ((MyHashNode<E, V>) roomInfo[index])
					.getValue();
			if (guest.getName().equals(name) && guest.getAge() == age) {
				return ((MyHashNode<E, V>) roomInfo[index]).getValue();
			}
		}
		return (V) "none";
	}

	/**
	 * Gets the all values.
	 *
	 * @return the all values
	 */
	@SuppressWarnings("unchecked")
	public List<String> getAllValues() {
		List<String> allGuests = new ArrayList<String>();

		for (int index = 0; index < roomInfo.length; index++) {
			if (roomInfo[index] != null) {
				Guest guest = (Guest) ((MyHashNode<E, V>) roomInfo[index])
						.getValue();
				allGuests.add("\nName : " + guest.getName() + "\tAge : "
						+ guest.getAge() + "\t RoomNo. : " + guest.getRoom());
			}
		}
		return allGuests;
	}
}
