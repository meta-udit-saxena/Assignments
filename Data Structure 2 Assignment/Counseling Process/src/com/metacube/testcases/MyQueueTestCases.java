package com.metacube.testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.metacube.myqueue.MyQueue;

public class MyQueueTestCases {

	MyQueue<Integer> queue;

	@Before
	public void setUpObject() {
		queue = new MyQueue<Integer>();
	}

	@Test
	public void GivenElementIsValidWhenEnqueueThenTrue() {
		boolean actual = queue.enqueue(10);
		assertEquals(true, actual);
	}

	@Test
	public void GivenElementIsNullWhenEnqueueThenFalse() {
		boolean actual = queue.enqueue(null);
		assertEquals(false, actual);
	}

	@Test
	public void GivenQueueIsNotEmptyWhenDequeueThenValidElement() {
		queue.enqueue(10);
		int actual = queue.dequeue();
		assertEquals(10, actual);
	}

	@Test
	public void GivenElementIsNullWhenDequeueThenNull() {
		assertEquals(null, queue.dequeue());
	}

	@Test
	public void GivenQueueWhenMakeEmptyThenSizeIs0() {
		queue.enqueue(10);
		queue.enqueue(20);
		queue.makeEmpty();
		int actual = queue.size();
		assertEquals(0, actual);
	}

	@Test
	public void Given20IsAFrontElementWhenGetFrontThen20() {
		queue.enqueue(20);
		queue.enqueue(10);
		int actual = queue.getFront();
		assertEquals(20, actual);
	}

	@Test
	public void GivenQueueIsEmptyWhenGetFrontThenNull() {
		Integer actual = queue.getFront();
		assertEquals(null, actual);
	}

	@Test
	public void GivenQueueIsEmptyWhenSizeThen0() {
		int actual = queue.size();
		assertEquals(0, actual);
	}

	@Test
	public void Given2ElementInQueueWhenSizeThen2() {
		queue.enqueue(20);
		queue.enqueue(10);
		int actual = queue.size();
		assertEquals(2, actual);
	}

}
