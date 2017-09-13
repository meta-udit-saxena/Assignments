package com.metacube.linkedlistinterface;

import java.util.NoSuchElementException;

import javax.swing.SortOrder;

/**
 * The Interface LinkedList.
 *
 * @param <E>
 *            the element type
 */
public interface MyLinkedList<E extends Comparable<E>> extends Iterable<E> {

	/**
	 * Adds the element at the index in linked List
	 *
	 * @param index
	 *            the index
	 * @param element
	 *            the element
	 * @return true,if successful else false
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	public boolean add(int index, E element) throws IndexOutOfBoundsException;

	/**
	 * Adds the element to the linked list
	 *
	 * @param element
	 *            the element
	 * @return true,if successful else false
	 */
	public boolean add(E element);

	/**
	 * Adds the element at the first.
	 *
	 * @param element
	 *            the element
	 * @return true,if successful else false
	 */
	public boolean addFirst(E element);

	/**
	 * Adds the element at the last.
	 *
	 * @param element
	 *            the element
	 * @return true,if successful else false
	 */
	public boolean addLast(E element);

	/**
	 * Clear the linked list.
	 */
	public void clear();

	/**
	 * Contains
	 *
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 */
	public boolean contains(E element);

	/**
	 * Gets the element by its index
	 *
	 * @param index
	 *            the index
	 * @return the e
	 * @throws IndexOutOfBoundsException
	 *             the index out of bounds exception
	 */
	public E get(int index) throws IndexOutOfBoundsException;

	/**
	 * Gets the element present at first position.
	 *
	 * @return the first
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public E getFirst() throws NoSuchElementException;

	/**
	 * Gets the element from last position.
	 *
	 * @return the last
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public E getLast() throws NoSuchElementException;

	/**
	 * Get Index of Element
	 *
	 * @param element
	 *            the element
	 * @return the index of element
	 */
	public int indexOf(E element);

	/**
	 * Removes the element by its position
	 *
	 * @param position
	 *            the position
	 * @return the Element
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public E removeByPosition(int position) throws NoSuchElementException;

	/**
	 * Removes the element
	 *
	 * @param element
	 *            the element
	 * @return true,if successful else false
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public boolean remove(E element) throws NoSuchElementException;

	/**
	 * Removes the first element.
	 *
	 * @return the Element
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public E removeFirst() throws NoSuchElementException;

	/**
	 * Removes the last element
	 *
	 * @return the Element
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public E removeLast() throws NoSuchElementException;

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
	public E set(int index, E element) throws IndexOutOfBoundsException;

	/**
	 *
	 * @return the size of linked list
	 */
	public int size();

	/**
	 * Reverse the linked list
	 *
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	public void reverse() throws NullPointerException;

	/**
	 * Sort the linked list.
	 *
	 * @throws NullPointerException
	 *             the null pointer exception
	 */
	public void sort() throws NullPointerException;

	/**
	 * Sort the linked list according to sorting order.
	 *
	 * @param sortOrder
	 *            the sort order
	 */
	public void sort(SortOrder sortOrder);

}
