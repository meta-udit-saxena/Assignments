package com.metacube.entity;

/**
 * The Class Node holding Binary tree Node
 *
 * @param <E>
 *            the element type
 */
public class BTNode<E> {

	private E data;
	private BTNode<E> left;
	private BTNode<E> right;

	/**
	 * Instantiates a new node.
	 *
	 * @param data
	 *            the data
	 */
	public BTNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public E getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Gets the left node.
	 *
	 * @return the left node
	 */
	public BTNode<E> getLeft() {
		return left;
	}

	/**
	 * Sets the left node.
	 *
	 * @param left
	 *            the new left node
	 */
	public void setLeft(BTNode<E> left) {
		this.left = left;
	}

	/**
	 * Gets the right node.
	 *
	 * @return the right node
	 */
	public BTNode<E> getRight() {
		return right;
	}

	/**
	 * Sets the right node.
	 *
	 * @param right
	 *            the new right node
	 */
	public void setRight(BTNode<E> right) {
		this.right = right;
	}
}
