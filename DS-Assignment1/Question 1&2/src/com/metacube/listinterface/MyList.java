package com.metacube.listinterface;

import javax.swing.SortOrder;

/**
 * The Interface MyList.
 *
 * @param <E>
 *            the element type
 */
public interface MyList<E> extends Iterable<E> {

	/**
	 * Add the element to list
	 *
	 * @param element
	 *            the element
	 * @return true if added successfully else false
	 */
	public boolean add(E element);

	/**
	 * Removes the element
	 *
	 * @param element
	 *            the element
	 */
	public boolean remove(E element);

	/**
	 *
	 * @return size of list
	 */
	public int size();

	/**
	 * Clear the list.
	 */
	public void clear();

	/**
	 * Adds the element to the index
	 *
	 * @param index
	 *            the index
	 * @param element
	 *            the element
	 * @return boolean - true if add to list else false
	 */
	public boolean add(int index, E element);

	/**
	 * Removes the element from given index
	 *
	 * @param index
	 *            the index
	 * @return boolean - true if removed from list else false
	 */
	public boolean remove(int index);

	/**
	 * Gets the first index of element
	 *
	 * @param element
	 *            the element
	 * @return the first index
	 */
	public int getFirstIndex(E element);

	/**
	 * Gets the element from given index.
	 *
	 * @param index
	 *            the index
	 * @return the element
	 */
	public Object getElement(int index);

	/**
	 * Reverse the list
	 */
	public void reverse();

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public Comparable[] getList();

	/**
	 * Sort the list according to the sorting order.
	 *
	 * @param sortingOrder
	 *            the sorting order - Ascending or Descending
	 */
	public void sort(SortOrder sortingOrder);

	/**
	 * Gets the first index after given position
	 *
	 * @param element
	 *            the element
	 * @param position
	 *            the index
	 * @return the first index after position
	 */
	public int getFirstIndexAfterPosition(E element, int position);

	/**
	 * Adds the second list to the current list
	 *
	 * @param secondList
	 *            the second list
	 * @return true if added successfully
	 */

	public boolean add(MyList<E> secondList);

	/**
	 * Sort the list in Ascending order
	 */
	public void sort();
}
