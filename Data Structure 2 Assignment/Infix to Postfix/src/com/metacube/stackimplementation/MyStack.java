package com.metacube.stackimplementation;

/**
 * The Class MyStack contains all the operations related to stack
 *
 * @param <E>
 *            the element type
 */
public class MyStack<E> {
	private Node<E> top;
	private int size;

	/**
	 * Push the element to stack
	 *
	 * @param element
	 *            the element
	 * @return true, if successful
	 */
	public boolean push(E element) {
		boolean pushed = false;
		Node<E> newNode = new Node<E>(element);
		if (element != null) {
			newNode.setNextNode(top);
			top = newNode;
			pushed = true;
			this.size++;
		}

		return pushed;
	}

	/**
	 * Pop the element from top
	 *
	 * @return the element if present else message "Empty Stack"
	 */
	public E pop() {
		if (top == null) {
			return null;
		}
		E element = top.getElement();
		top = top.getNextNode();
		this.size--;
		return element;
	}

	/**
	 * Gets the top.
	 *
	 * @return the top
	 */
	public Node<E> getTop() {
		return top;
	}

	/**
	 * Peek the top element
	 *
	 * @return the top element of present else null
	 */
	public E peek() {
		if (top == null) {
			return null;
		}
		
		return top.getElement();
	}

	/**
	 * Sets the top.
	 *
	 * @param top
	 *            the new top
	 */
	public void setTop(Node<E> top) {
		this.top = top;
	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Sets the size.
	 *
	 * @param size
	 *            the new size
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
