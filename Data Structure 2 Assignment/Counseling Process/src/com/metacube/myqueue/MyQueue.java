package com.metacube.myqueue;

import java.util.Arrays;

/**
 * The Class MyQueue store queue and perform all actions related to queue.
 */
public class MyQueue<E> {
	private E[] queue;
	private int size, rear;
	private static final int CONSTANT_SIZE = 10;

	/**
	 * Instantiates a new my queue.
	 */
	public MyQueue() {
		queue = (E[]) new Object[CONSTANT_SIZE];
		this.rear = -1;
	}

	/**
	 * Enqueue the item
	 *
	 * @param item
	 *            the item
	 */
	public boolean enqueue(E item) {
		if (item != null) {
			queue[++this.rear] = item;
			this.size++;
			if (size() >= queue.length) {
				increaseCapacity();
			}
			return true;
		}

		return false;
	}

	/**
	 * Increase capacity by half of its current length
	 */
	private void increaseCapacity() {
		queue = Arrays.copyOf(queue, queue.length + (queue.length / 2));
	}

	/**
	 * Dequeue the item from queue
	 *
	 * @return the object
	 */
	public E dequeue() {
		E data = null;
		if (size() != 0) {
			data = queue[0];
			for (int index = 0; index <= rear; index++) {
				queue[index] = queue[index + 1];
			}
			this.size--;
			this.rear--;
		}
		if (CONSTANT_SIZE < queue.length && size() * 2 < queue.length) {
			freeExtraSpace();
		}

		return data;
	}

	/**
	 * Reduces the size of queue by its current size + 10
	 */
	private void freeExtraSpace() {
		queue = Arrays.copyOf(queue, size() + 10);
	}

	/**
	 * Make queue empty
	 */
	public void makeEmpty() {
		this.queue = (E[]) new Object[CONSTANT_SIZE];
		this.size = 0;
		this.rear = -1;
	}

	/**
	 * Gets the front element.
	 *
	 * @return the front element
	 */
	public E getFront() {
		if (size() == 0) {
			return null;
		}

		return queue[0];
	}

	/**
	 * Size of Queue
	 *
	 * @return the size of queue
	 */
	public int size() {
		return this.size;
	}

	/**
	 * overrides to String method to print queue
	 */
	@Override
	public String toString() {
		if (size() == 0) {
			return "Queue Empty";
		}
		String display = "";
		for (int i = 0; i <= rear; i++) {
			display += queue[i].toString() + "\n";
		}

		return display;
	}
}
