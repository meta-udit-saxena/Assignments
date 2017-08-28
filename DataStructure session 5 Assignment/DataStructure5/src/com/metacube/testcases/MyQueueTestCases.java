package com.metacube.testcases;

import static org.junit.Assert.assertEquals;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;
import com.metacube.queue.MyQueue;

public class MyQueueTestCases {

	MyQueue<Integer> queue;

	@Before
	public void setUpObject() {
		queue = new MyQueue<Integer>();
	}

	@Test
	public void GivenElement_WhenAdd_ThenTrue() {
		boolean actual = queue.add(10);
		assertEquals(true, actual);
	}

	@Test
	public void GivenQueueIsNotEmpty_WhenPeek_ThenFirstElementData() {
		queue.add(10);
		queue.add(20);
		int actual = queue.peek();
		assertEquals(10, actual);
	}

	@Test
	public void GivenQueueIsEmpty_WhenPeek_ThenNull() {
		assertEquals(null, queue.peek());
	}

	@Test
	public void GivenQueueIsNotEmpty_WhenElement_ThenFirstElementData() {
		queue.add(10);
		queue.add(20);
		int actual = queue.element();
		assertEquals(10, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenQueueIsEmpty_WhenPeek_ThenNoSuchElementException() {
		queue.element();
	}

	@Test
	public void GivenQueueIsNotEmpty_WhenPoll_ThenFirstElement() {
		queue.add(10);
		queue.add(20);
		int actual = queue.poll();
		assertEquals(10, actual);
	}

	@Test
	public void GivenQueueIsEmpty_WhenPoll_ThenNull() {
		assertEquals(null, queue.poll());
	}

	@Test
	public void GivenQueueIsNotEmpty_WhenRemove_ThenFirstElement() {
		queue.add(10);
		queue.add(20);
		int actual = queue.remove();
		assertEquals(10, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenQueueIsEmpty_WhenRemove_ThenNoSuchElementException() {
		queue.remove();
	}

	@Test
	public void GivenQueueIsNotEmpty_WhenIsEmpty_ThenFalse() {
		queue.add(10);
		boolean actual = queue.isEmpty();
		assertEquals(false, actual);
	}

	@Test
	public void GivenQueueIsEmpty_WhenIsEmpty_ThenTrue() {
		boolean actual = queue.isEmpty();
		assertEquals(true, actual);
	}

	@Test
	public void GivenQueueIsNotEmpty_WhenClear_ThenEmptyQueue() {
		queue.add(10);
		queue.clear();
		boolean actual = queue.isEmpty();
		assertEquals(true, actual);
	}
}
