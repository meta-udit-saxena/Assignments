package com.metacube.priorityqueue;

import java.util.ArrayList;
import java.util.List;
import com.metacube.utility.MyHeap;

/**
 * The Class PriorityQueue.
 *
 * @param <T>
 *            the generic type
 */
public class MyPriorityQueue<T extends Comparable<T>> {
	private List<T> queue;
	private MyHeap<T> heap;

	/**
	 * Instantiates a new priority queue.
	 */
	public MyPriorityQueue() {
		queue = new ArrayList<T>();
		heap = new MyHeap<T>();
	}

	/**
	 * Enqueue the element
	 *
	 * @param element
	 *            the element
	 * @return true, if successful else false
	 */
	public boolean enqueue(T element) {
		if (element != null) {
			queue.add(element);
			heap.buildHeap(queue);
			return true;
		}
		return false;
	}

	/**
	 * Dequeue the element from front
	 *
	 * @return the t - element
	 */
	public T dequeue() {
		return heap.getRoot(queue);
	}

	/**
	 * Gets the size.
	 *
	 * @return the size of queue
	 */
	public int getSize() {
		return queue.size();
	}
}
