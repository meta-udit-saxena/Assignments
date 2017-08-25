/** 
 * @author Udit Saxena
 * 
 */
package com.metacube.jobprinting;

/**
 * The Class HeapSort.
 */
public class HeapSort {

	/**
	 * Heap sort.
	 *
	 * @param <T>
	 *            the generic type
	 * @param list
	 *            the list
	 */
	public static <T extends Comparable<T>> void heapSort(T[] list) {

		Heap<T> heap = new Heap<>();

		for (T list1 : list) {
			heap.buildHeap(list1);
		}

		for (int i = list.length - 1; i >= 0; i--) {
			list[i] = heap.heapify();
		}

	}

}