package com.metacube.binarysearch;

/**
 * The Class Search.
 *
 * @param <E> the element type
 */
public class Search<E extends Comparable<E>> {

	/**
	 * Binary search.(Assumption - Array is in sorted order)
	 *
	 * @param array
	 *            the array
	 * @param data
	 *            the data to search
	 * @return the position
	 */
	public int binarySearch(E[] array, E data) {
		if(array==null){
			return -1;
		}
		
		return binarySearch(array, data, 0, array.length - 1);
	}

	/**
	 * Binary search using recursion.
	 *
	 * @param array
	 *            the array
	 * @param data
	 *            the data to search
	 * @param start
	 *            the start starting point
	 * @param end
	 *            the end ending point
	 * @return the position of data
	 */
	private int binarySearch(E[] array, E data, int start, int end) {
		int mid = (start + end) / 2;
		//base condition
		if (start > end) {
			return -1;
		}
		if (data.compareTo(array[mid]) > 0) {
			return binarySearch(array, data, mid + 1, end);
		} else if (data.compareTo(array[mid]) < 0||(mid != 0 && array[mid - 1].compareTo(data) == 0)) {
			return binarySearch(array, data, start, mid - 1);
		}

		return mid;
	}
}