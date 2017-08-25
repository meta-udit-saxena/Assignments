/** 
 * @author Udit Saxena
 * @project Room Allotment using Hash Table
 * 
 */
package com.metacube.roomallotment;

/**
 * The Class MyHashNode.
 *
 * @param <E>
 *            the element type
 * @param <V>
 *            the value type
 */
public class MyHashNode<E, V> {

	/** The key. */
	E key;
	/** The value. */
	V value;

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public E getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *            the key to set
	 */
	public void setKey(E key) {
		this.key = key;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}
}
