package com.metacube.myarraylist;

import java.util.Arrays;
import java.util.Iterator;
import javax.swing.SortOrder;
import com.metacube.listinterface.MyList;

/**
 * @author Udit Saxena
 *
 * @param <T>
 */
public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
	private T[] list;
	private int size;
	private static final int FIXED_SIZE = 5;

	/**
	 * Array List Constructor
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		list = (T[]) new Comparable[FIXED_SIZE];
		this.size = -1;
	}

	/**
	 * Return the current size of Array List
	 */
	@Override
	public int size() {

		return this.size;
	}

	/**
	 * Add the element to list
	 *
	 * @param element
	 *            the element
	 * @return true if added successfully else false
	 */
	@Override
	public boolean add(T element) {
		if (element == null) {
			return false;
		}
		this.size++;
		if (this.size > list.length - 1) {
			increaseCapacity();
		}
		list[this.size] = element;
		return true;
	}

	/**
	 * Adds the second list to the current list
	 *
	 * @param secondList
	 *            the second list
	 * @return true if added successfully else false
	 */
	@Override
	public boolean add(MyList<T> secondList) {
		if (secondList.size() == -1) {
			return false;
		}
		Iterator<T> iterator = secondList.iterator();
		while (iterator.hasNext()) {
			add(iterator.next());
		}
		return true;
	}

	/**
	 * Gets the Array list.
	 *
	 * @return the Array list
	 */
	@Override
	public Comparable[] getList() {

		return list;
	}

	/**
	 * Increase the Capacity of Array list by double
	 */
	private void increaseCapacity() {
		list = Arrays.copyOf(list, list.length * 2);
	}

	/**
	 * Gets the element from given index.
	 *
	 * @param index
	 *            the index
	 * @return the element if present else null
	 */
	@Override
	public Object getElement(int index) {
		if (index < 0 || index > size()) {

			return null;
		}

		return list[index];
	}

	/**
	 * Adds the element to the index
	 *
	 * @param index
	 *            the index
	 * @param element
	 *            the element
	 * @return boolean - true if add to list else false
	 */
	@Override
	public boolean add(int position, T element) {
		boolean added = true;
		this.size++;
		if (position < 0 || position > size() || element == null) {
			added = false;
		} else {
			Comparable[] newList = new Comparable[list.length];
			for (int index = 0; index < position; index++) {
				newList[index] = list[index];
			}
			newList[position] = element;
			for (int index = position + 1; index < list.length; index++) {
				newList[index] = list[index - 1];
			}
			list = (T[]) newList;
		}
		return added;
	}

	/**
	 * Removes the element from given position
	 *
	 * @param index
	 *            the index
	 * @return boolean - true if removed from list else false
	 */
	@Override
	public boolean remove(int position) {
		boolean removed = true;
		if (position > size() || position < 0) {
			removed = false;
		} else {
			int index;
			for (index = position; index < list.length - 1; index++) {
				list[index] = list[index + 1];
			}
			list[index] = null;
			this.size--;
		}
		return removed;
	}

	/**
	 * Removes the element
	 *
	 * @param element
	 *            the element
	 */
	@Override
	public boolean remove(T element) {

		return remove(getFirstIndex(element));
	}

	/**
	 * Gets the first index after given position
	 *
	 * @param element
	 *            the element
	 * @param position
	 *            the index
	 * @return the first index after position or -1 if element not found
	 */
	@Override
	public int getFirstIndexAfterPosition(T element, int position) {
		int index = 0;
		if (position > this.size || element == null) {

			return -1;
		}
		for (Object elementValue : list) {
			if (index > this.size) {
				index = -1;
			}
			if (index > position) {
				if (elementValue.equals(element)) {
					break;
				}
			}
			index++;
		}

		return index;
	}

	/**
	 * Gets the first index of element
	 *
	 * @param element
	 *            the element
	 * @return the first index of element or -1 if element not found
	 */
	@Override
	public int getFirstIndex(T element) {
		int index = 0;
		boolean found = false;
		for (Object elementValue : list) {
			if (index > size()) {
				break;
			}
			if (elementValue.equals(element)) {
				found = true;
				break;
			}
			index++;
		}
		if (found == true) {
			return index;
		}
		return -1;
	}

	/**
	 * Clear the list.
	 */
	@Override
	public void clear() {
		list = (T[]) new Comparable[FIXED_SIZE];
		this.size = -1;
	}

	/**
	 * Reverse the list
	 */
	@Override
	public void reverse() {
		for (int i = 0; i <= size() / 2; i++) {
			swap(i, size() - i);
		}
	}

	/**
	 * Swap of the number present at first index and second index
	 * 
	 * @param firstIndex
	 * @param secondIndex
	 */
	private void swap(int firstIndex, int secondIndex) {
		T temp = list[firstIndex];
		list[firstIndex] = list[secondIndex];
		list[secondIndex] = temp;
	}

	/**
	 * Sort the list according to the sorting order.
	 *
	 * @param sortingOrder
	 *            the sorting order - Ascending or Descending
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	public void sort(SortOrder sortingOrder) {
		for (int firstIndex = 0; firstIndex <= size(); firstIndex++) {
			for (int nextIndex = firstIndex + 1; nextIndex <= size(); nextIndex++) {
				if (sortingOrder.equals(SortOrder.ASCENDING)) {
					if (list[firstIndex].compareTo(list[nextIndex]) > 0) {
						swap(firstIndex, nextIndex);
					}
				} else {
					if (list[firstIndex].compareTo(list[nextIndex]) < 0) {
						swap(firstIndex, nextIndex);
					}
				}
			}
		}
	}

	/**
	 * Sort the list in Ascending order
	 */
	@Override
	public void sort() {
		sort(SortOrder.ASCENDING);
	}

	/**
	 * Override the iterator method and return the iterator object
	 */
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {

				return index <= size();
			}

			@Override
			public T next() {

				return (T) list[index++];
			}
		};
	}
}
