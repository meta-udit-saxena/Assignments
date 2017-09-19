package com.metacube.stackimplementation;

/**
 * The Class Node.
 *
 * @param <E>
 *            the element type
 */
public class Node<E> {

	private E element;
	private Node<E> nextNode;

	/**
	 * Instantiates a new node.
	 *
	 * @param element
	 *            the element
	 */
	public Node(E element) {
		this.element = element;
		this.nextNode = null;
	}

	/**
	 * Gets the element.
	 *
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Sets the element.
	 *
	 * @param element
	 *            the new element
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * Gets the next node.
	 *
	 * @return the next node
	 */
	public Node<E> getNextNode() {
		return nextNode;
	}

	/**
	 * Sets the next node.
	 *
	 * @param nextNode
	 *            the new next node
	 */
	public void setNextNode(Node<E> nextNode) {
		this.nextNode = nextNode;
	}
}
