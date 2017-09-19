package com.metacube.entity;

/**
 * The Class MyHashNode contains key and value.
 *
 * @param <E>
 *            the element type
 * @param <V>
 *            the value type
 */
public class MyHashNode<E, V> {
	E key;
	V value;

	/**
	 * Instantiates a new my hash node.
	 *
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public MyHashNode(E key, V value) {
		this.key = key;
		this.value = value;
	}

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
	 *            the new key
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
	 *            the new value
	 */
	public void setValue(V value) {
		this.value = value;
	}
}
