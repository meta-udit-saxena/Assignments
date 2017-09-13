package com.metacube.singlylinkedlist;

@SuppressWarnings("rawtypes")
public class Node<E extends Comparable> {

	private E element;
	private Node nextNode;
	
	public Node(E element) {
		this.element = element;
		this.nextNode = null;
	}
	/**
	 * @return the element
	 */
	public E getElement() {
		return element;
	}
	/**
	 * @param temp the element to set
	 */
	public void setElement(E temp) {
		this.element = temp;
	}
	/**
	 * @return the nextNode
	 */
	public Node getNextNode() {
		return nextNode;
	}
	/**
	 * @param nextNode the nextNode to set
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}