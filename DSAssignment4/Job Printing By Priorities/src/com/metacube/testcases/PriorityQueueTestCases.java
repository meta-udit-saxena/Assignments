package com.metacube.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.entity.Task;
import com.metacube.priorityenum.Designation;
import com.metacube.priorityqueue.MyPriorityQueue;

public class PriorityQueueTestCases {

	MyPriorityQueue<Task> priorityQueue;

	@Before
	public void setUpObject() {
		priorityQueue = new MyPriorityQueue<Task>();
	}

	@Test
	public void GivenTaskIsValidWhenEnqueueThenTrue() {
		boolean actual = priorityQueue.enqueue(new Task(Designation.chairman,
				"I am chairman"));
		assertEquals(true, actual);
	}

	@Test
	public void GivenTaskIsNullWhenEnqueueThenFalse() {
		boolean actual = priorityQueue.enqueue(null);
		assertEquals(false, actual);
	}

	@Test
	public void GivenMultipleTaskEnqueuedWhenDequeueThenTopPriorityTask() {
		priorityQueue
				.enqueue(new Task(Designation.graduate, "I am graduate 1"));
		priorityQueue.enqueue(new Task(Designation.Undergraduate,
				"I am undergraduate 1"));
		priorityQueue
				.enqueue(new Task(Designation.chairman, "I am chairman 1"));
		priorityQueue.enqueue(new Task(Designation.professor,
				"I am professor 1"));
		priorityQueue
				.enqueue(new Task(Designation.graduate, "I am graduate 2"));
		priorityQueue.enqueue(new Task(Designation.Undergraduate,
				"I am undergraduate 2"));
		priorityQueue
				.enqueue(new Task(Designation.chairman, "I am chairman 2"));
		priorityQueue.enqueue(new Task(Designation.professor,
				"I am professor 2"));
		Task actual = priorityQueue.dequeue();
		Task expected = new Task(Designation.chairman, "I am chairman 1");
		assertEquals(expected, actual);
	}
}
