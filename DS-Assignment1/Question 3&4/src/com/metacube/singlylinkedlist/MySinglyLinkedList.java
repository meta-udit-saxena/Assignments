/**
 * 
 */
package com.metacube.singlylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.SortOrder;

import com.metacube.linkedlistinterface.MyLinkedList;

/**
 * @author Udit Saxena
 *
 */
@SuppressWarnings("rawtypes")
public class MySinglyLinkedList<E extends Comparable<E>> implements MyLinkedList<E> {

	private Node head;
	private int size = 0;

	/**
	 * Adds the element to the linked list
	 *
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 */
	@Override
	public boolean add(E element) {
		if (element == null) {

			return false;
		}
		Node currentNode = this.head;
		if (currentNode == null) {
			addFirst(element);
		} else {
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(new Node(element));
			this.size++;
		}

		return true;
	}

	/**
	 * Adds the element at the first.
	 *
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 */
	@Override
	public boolean addFirst(E element) {
		if (element == null) {

			return false;
		}
		Node node = new Node(element);
		if (this.head == null) {
			this.head = node;
		} else {
			node.setNextNode(this.head);
			this.head = node;
		}
		this.size++;

		return true;
	}

	/**
	 * Adds the element at the index in linked List
	 *
	 * @param index
	 *            the index
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	@Override
	public boolean add(int position, E element) throws IndexOutOfBoundsException {
		if (element == null) {

			return false;
		}
		if (position > this.size + 1 || position < 1) {
			throw new IndexOutOfBoundsException();
		}
		if (position == 1) {
			addFirst(element);
		} else if (position == size()) {
			addLast(element);
		} else {
			Node currentNode = this.head;
			Node previousNode = null;
			int index = 1;
			while (currentNode != null) {
				if (index == position) {
					break;
				}
				index++;
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
			Node node = new Node(element);
			node.setNextNode(currentNode);
			previousNode.setNextNode(node);
			this.size++;
		}

		return true;
	}

	/**
	 * Adds the element at the last.
	 *
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 * 
	 */
	@Override
	public boolean addLast(E element) {

		return add(element);
	}

	/**
	 * Clear the linked list.
	 */
	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	/**
	 * Contains
	 *
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 */
	@Override
	public boolean contains(E element) {
		Node currentNode = this.head;
		boolean found = false;
		while (currentNode != null) {
			if (currentNode.getElement().equals(element)) {
				found = true;
				break;
			}
			currentNode = currentNode.getNextNode();
		}

		return found;
	}

	/**
	 * Gets the element by its index
	 *
	 * @param index
	 *            the index
	 * @return the e
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > size() || index < 1) {
			throw new IndexOutOfBoundsException();
		}
		Node currentNode = this.head;
		int position = 1;
		while (currentNode != null) {
			if (position == index) {
				break;
			}
			position++;
			currentNode = currentNode.getNextNode();
		}

		return (E) currentNode.getElement();
	}

	/**
	 * Gets the element present at first position.
	 *
	 * @return the first
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if (this.head == null) {
			throw new NoSuchElementException();
		}

		return (E) head.getElement();
	}

	/**
	 * Gets the element from last position.
	 *
	 * @return the last
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	@Override
	public E getLast() throws NoSuchElementException {
		Node currentNode = this.head;
		if (this.head == null) {
			throw new NoSuchElementException();
		}
		while (currentNode.getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}

		return (E) currentNode.getElement();
	}

	/**
	 * Get Index of Element
	 *
	 * @param element
	 *            the element
	 * @return the index of element
	 */
	@Override
	public int indexOf(E element) {
		if (contains(element)) {
			int index = 1;
			int count = 1;
			Node currentNode = this.head;
			while (currentNode != null) {
				if (currentNode.getElement().equals(element)) {
					break;
				}
				index++;
				currentNode = currentNode.getNextNode();
			}

			return index;
		}

		return -1;
	}

	/**
	 * Removes the element by its position
	 *
	 * @param position
	 *            the position
	 * @return the Element
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	@Override
	public E removeByPosition(int position) throws NoSuchElementException {
		if (position > size() || position < 1 || this.head == null) {
			throw new NoSuchElementException();
		}
		E element = get(position);
		remove(element);

		return element;
	}

	/**
	 * Removes the element
	 *
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	@Override
	public boolean remove(E element) throws NoSuchElementException {
		if (head == null || element == null || contains(element) == false) {
			throw new NoSuchElementException();
		}
		Node currentNode = this.head;
		if (currentNode.getElement().equals(element)) {
			removeFirst();
		} else if (element.equals(getLast())) {
			removeLast();
		} else {
			Node previousNode = null;
			while (currentNode != null) {
				if (currentNode.getElement().equals(element)) {
					break;
				}
				previousNode = currentNode;
				currentNode = currentNode.getNextNode();
			}
			previousNode.setNextNode(currentNode.getNextNode());
		}
		return true;
	}

	/**
	 * Removes the first element.
	 *
	 * @return the Element
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	@Override
	public E removeFirst() throws NoSuchElementException {
		if (this.head == null) {
			throw new NoSuchElementException();
		}
		this.head = this.head.getNextNode();

		return (E) this.head.getElement();
	}

	/**
	 * Removes the last element
	 *
	 * @return the Element
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	@Override
	public E removeLast() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		}
		Node currentNode = this.head;
		while (currentNode.getNextNode().getNextNode() != null) {
			currentNode = currentNode.getNextNode();
		}
		E element = (E) currentNode.getNextNode().getElement();
		currentNode.setNextNode(null);
		currentNode.getNextNode().setNextNode(null);

		return (E) element;
	}

	/**
	 * Sets the element at given index
	 *
	 * @param index
	 *            the index
	 * @param element
	 *            the element
	 * @return the element
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException {
		if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node currentNode = this.head;
		int position = 1;
		while (currentNode != null) {
			if (index == position) {
				break;
			}
			currentNode = currentNode.getNextNode();
			position++;
		}
		currentNode.setElement(element);

		return (E) currentNode.getElement();
	}

	/**
	 *
	 * @return the size of linked list
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Reverse the linked list
	 *
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	@Override
	public void reverse() throws NullPointerException {
		if (this.head == null) {
			throw new NullPointerException();
		}
		Node currentNode = this.head;
		Node previousNode = null;
		Node nextNode = null;
		while (currentNode != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(previousNode);
			previousNode = currentNode;
			currentNode = nextNode;
		}
		this.head = previousNode;
	}

	/**
	 * Swap the node data
	 * 
	 * @param firstNode
	 * @param secondNode
	 */
	private void swap(Node firstNode, Node secondNode) {
		E temp = (E) firstNode.getElement();
		firstNode.setElement(secondNode.getElement());
		secondNode.setElement(temp);
	}

	/**
	 * Sort the linked list.
	 *
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	@Override
	public void sort() throws NullPointerException {
		sort(SortOrder.ASCENDING);
	}

	/**
	 * Sort the linked list according to sorting order.
	 *
	 * @param sortOrder
	 *            the sort order
	 */
	@Override
	public void sort(SortOrder sortOrder) throws NullPointerException {
		if (this.head == null) {
			throw new NullPointerException();
		}
		Node firstLoop = this.head;
		Node secondLoop;
		while (firstLoop != null) {
			secondLoop = firstLoop.getNextNode();
			while (secondLoop != null) {
				if (sortOrder.equals(SortOrder.ASCENDING)) {
					if (firstLoop.getElement().compareTo(secondLoop.getElement()) > 0) {
						swap(firstLoop, secondLoop);
					}
				} else {
					if (firstLoop.getElement().compareTo(secondLoop.getElement()) < 0) {
						swap(firstLoop, secondLoop);
					}
				}
				secondLoop = secondLoop.getNextNode();
			}
			firstLoop = firstLoop.getNextNode();
		}
	}

	/**
	 * Overriding the to string method;
	 */
	@Override
	public String toString() {
		String display = "[";
		Node currentNode = this.head;
		while (currentNode != null) {
			display += currentNode.getElement() + "-->";
			currentNode = currentNode.getNextNode();
		}
		display += "null]";

		return display;
	}

	/**
	 * Implementing the iterator of Iterable interface
	 * 
	 * @return the Iterator object
	 */
	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node currentNode = head;

			@Override
			public boolean hasNext() {
				return currentNode != null;
			}

			@Override
			public E next() {
				E element = (E) currentNode.getElement();
				currentNode = currentNode.getNextNode();
				return element;
			}
		};
	}
}
