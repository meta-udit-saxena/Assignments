package com.metacube.binarytree;

/**
 * The Class BSTNode.
 *
 * @param <T>
 *            the generic type
 */
public class BSTNode<T> {
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;

	/**
	 * Instantiates a new BST node.
	 *
	 * @param data
	 *            the data
	 */
	public BSTNode(T data) {
		this.data = data;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * Sets the data.
	 *
	 * @param data
	 *            the new data
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Gets the left.
	 *
	 * @return the left node
	 */
	public BSTNode<T> getLeft() {
		return left;
	}

	/**
	 * Sets the left.
	 *
	 * @param left
	 *            the new left node
	 */
	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}

	/**
	 * Gets the right.
	 *
	 * @return the right node
	 */
	public BSTNode<T> getRight() {
		return right;
	}

	/**
	 * Sets the right.
	 *
	 * @param right
	 *            the new right node
	 */
	public void setRight(BSTNode<T> right) {
		this.right = right;
	}
}