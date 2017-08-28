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
	 * Adds the element to Sorted LinkedList
	 *
	 * @param element
	 *            the element
	 */
	public boolean add(E element) {
		if (element == null) {
			return false;
		}
		int position = getPosition(0, element);
		sortedLinkedList.add(position, element);
		return true;
	}

	/**
	 * Gets the position of Element recursively
	 *
	 * @param position
	 *            the position
	 * @param element
	 *            the element
	 * @return the element position
	 */
	public int getPosition(int position, E element) {
		if (position >= sortedLinkedList.size()) {
			return position;
		}
		if (sortedLinkedList.get(position).compareTo(element) > 0) {
			return position;
		}
		return getPosition(position + 1, element);
	}

	/**
	 * Gets the linked list.
	 *
	 * @return the sorted linked list
	 */
	public List<E> getLinkedList() {
		return sortedLinkedList;
	}
}
