package com.metacube.insertinsortedlinkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * The Class SortedLinkedList.
 *
 * @param <E>
 *            the element type
 */
public class SortedLinkedList<E extends Comparable<E>> {
	List<E> sortedLinkedList;

	/**
	 * Instantiates a new sorted linked list.
	 */
	public SortedLinkedList() {
		sortedLinkedList = new LinkedList<E>();
	}

	/**
	 * Adds the element to Sorted LinkedList.
	 *
	 * @param element
	 *            the element
	 * @return true, if successful
	 */
	public boolean add(E element) {
		if (element == null) {
			return false;
		}
		int position = findPositionOfElement(0, element);
		sortedLinkedList.add(position, element);
		return true;
	}

	/**
	 * Find position of element in Sorted linked List.
	 *
	 * @param position
	 *            the position
	 * @param element
	 *            the element
	 * @return the position of Element
	 */
	private int findPositionOfElement(int position, E element) {
		if (position >= sortedLinkedList.size()) {
			return position;
		}
		if (sortedLinkedList.get(position).compareTo(element) > 0) {
			return position;
		}

		return findPositionOfElement(position + 1, element);
	}

	/**
	 * Gets the linked list.
	 *
	 * @return the sorted linked list
	 */
	public List<E> getLinkedList() {
		return sortedLinkedList;
	}

	/**
	 * Gets the index of element.
	 *
	 * @param element
	 *            the element
	 * @return the index of element
	 */
	public int getIndexOfElement(E element) {
		if (element == null) {
			return -1;
		}

		return sortedLinkedList.indexOf(element);
	}
}
