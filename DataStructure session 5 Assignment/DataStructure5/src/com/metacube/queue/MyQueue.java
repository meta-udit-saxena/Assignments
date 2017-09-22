package com.metacube.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * The Class MyQueue contains Queue Methods.
 *
 * @param <E>
 *            the element type
 */
public class MyQueue<E> {
	private LinkedList<E> queue;

	/**
	 * Instantiates a new my queue.
	 */
	public MyQueue() {
		queue = new LinkedList<E>();
	}

	/**
	 * Adds the element to Queue
	 *
	 * @param element
	 *            the element
	 * @return true, if successful
	 */
	public boolean add(E element) {
		return queue.add(element);
	}

	/**
	 * Peek from Front of Queue
	 *
	 * @return the e - element
	 */
	public E peek() {
		try {
			return queue.getFirst();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * Element same as Peek but throws Exception
	 *
	 * @return the e - element
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public E element() throws NoSuchElementException {
		return queue.getFirst();
	}

	/**
	 * Poll remove element form first
	 *
	 * @return the element if present else null
	 */
	public E poll() {
		try {
			return queue.removeFirst();
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * Removes same as poll but throws Exception when queue is empty
	 *
	 * @return the e - element
	 * @throws NoSuchElementException
	 *             the no such element exception
	 */
	public E remove() throws NoSuchElementException {
		return queue.removeFirst();
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty else false
	 */
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	/**
	 * Clear the queue
	 */
	public void clear() {
		queue.clear();
	}

	/**
	 * Size.
	 *
	 * @return the size of queue
	 */
	public int size() {
		return queue.size();
	}
}
