package com.metacube.doublylinkedlist;
@SuppressWarnings("rawtypes")
public class Node<E extends Comparable<E>> {
	private E element;
	private Node nextNode;
	private Node previousNode;

	public Node(E element) {
		this.element = element;
		this.nextNode = null;
		this.previousNode = null;
	}

	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}

	/**
	 * @param element
	 *            the element to set
	 */
	public void setElement(E element) {
		this.element = element;
	}

	/**
	 * @return the nextNode
	 */
	public Node getNextNode() {
		return nextNode;
	}

	/**
	 * @param nextNode
	 *            the nextNode to set
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	/**
	 * @return the previousNode
	 */
	public Node getPreviousNode() {
		return previousNode;
	}

	/**
	 * @param previousNode
	 *            the previousNode to set
	 */
	public void setPreviousNode(Node previousNode) {
		this.previousNode = previousNode;
	}
}
