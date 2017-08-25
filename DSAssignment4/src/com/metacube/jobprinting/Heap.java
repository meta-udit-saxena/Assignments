package com.metacube.jobprinting;

/** 
 * @author Udit Saxena
 */
import java.util.ArrayList;

/**
 * The Class Heap.
 *
 * @param <T>
 *            the generic type
 */
final class Heap<T extends Comparable<T>> {

	/** The heap array. */
	private final ArrayList<T> heapArray = new ArrayList<>();

	/**
	 * Instantiates a new heap.
	 */
	public Heap() {

	}

	/**
	 * Instantiates a new heap.
	 *
	 * @param jobQueue
	 *            the objects
	 */
	public Heap(T[] jobQueue) {
		for (T object : jobQueue) {
			buildHeap(object);
		}
	}

	/**
	 * Builds the heap.
	 *
	 * @param jobQueueObj
	 *            the new object
	 */
	public void buildHeap(T jobQueueObj) {
		heapArray.add(jobQueueObj);
		int currentIndex = heapArray.size() - 1;

		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;

			if (heapArray.get(currentIndex).compareTo(
					heapArray.get(parentIndex)) > 0) {
				T temp = heapArray.get(currentIndex);
				heapArray.set(currentIndex, heapArray.get(parentIndex));
				heapArray.set(parentIndex, temp);
			} else {
				break;
			}

			currentIndex = parentIndex;
		}
	}

	/**
	 * Heapify.
	 *
	 * @return the t
	 */
	public T heapify() {
		if (heapArray.isEmpty()) {
			return null;
		}

		T removedObject = heapArray.get(0);
		heapArray.set(0, heapArray.get(heapArray.size() - 1));
		heapArray.remove(heapArray.size() - 1);

		int currentIndex = 0;
		while (currentIndex < heapArray.size()) {
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;

			if (leftChildIndex >= heapArray.size()) {
				break;
			}

			int maxIndex = leftChildIndex;

			if (rightChildIndex < heapArray.size()) {
				if (heapArray.get(maxIndex).compareTo(
						heapArray.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}

			if (heapArray.get(currentIndex).compareTo(heapArray.get(maxIndex)) < 0) {
				T temp = heapArray.get(maxIndex);
				heapArray.set(maxIndex, heapArray.get(currentIndex));
				heapArray.set(currentIndex, temp);
				currentIndex = maxIndex;
			} else {
				break;
			}
		}

		return removedObject;

	}

	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getSize() {
		return heapArray.size();
	}
}
