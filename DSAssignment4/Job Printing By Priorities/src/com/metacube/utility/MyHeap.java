package com.metacube.utility;

import java.util.List;

/**
 * The Class MyHeap.
 *
 * @param <T>
 *            the generic type
 */
public class MyHeap<T extends Comparable<T>> {
	private List<T> heap;

	/**
	 * Sort.
	 *
	 * @param queue
	 *            the queue
	 * @return the list
	 */
	public List<T> buildHeap(List<T> queue) {
		if (queue != null && queue.size() != 0) {
			heap = queue;
			for (int index = heap.size() / 2 - 1; index >= 0; index--) {
				heapify(heap.size(), index);
			}

			return heap;
		}

		return null;
	}

	/**
	 * Heapify.
	 *
	 * @param size
	 *            the size of heap
	 * @param index
	 *            the index
	 */
	private void heapify(int size, int index) {
		int leftIndex = index * 2 + 1;
		int rightIndex = index * 2 + 2;
		int largest = index;
		if (leftIndex < size
				&& heap.get(leftIndex).compareTo(heap.get(largest)) > 0) {
			largest = leftIndex;
		}
		if (rightIndex < size
				&& heap.get(rightIndex).compareTo(heap.get(largest)) > 0) {
			largest = rightIndex;
		}
		if (largest != index) {
			swap(largest, index);
			heapify(size, largest);
		}
	}

	/**
	 * Gets the Root element .
	 *
	 * @param queue
	 *            the queue
	 * @return the root element
	 */
	public T getRoot(List<T> queue) {
		if (queue != null && queue.size() != 0) {
			heap = queue;
			T data = heap.get(0);
			swap(0, heap.size() - 1);
			heap.remove(heap.size() - 1);
			heapify(heap.size(), 0);

			return data;
		}

		return null;
	}

	/**
	 * Swap.
	 *
	 * @param largest
	 *            the largest
	 * @param index
	 *            the index
	 */
	private void swap(int largest, int index) {
		T temp = heap.get(largest);
		heap.set(largest, heap.get(index));
		heap.set(index, temp);
	}
}
