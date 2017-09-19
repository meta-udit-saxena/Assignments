package com.metacube.main;

import com.metacube.entity.Task;
import com.metacube.priorityenum.Designation;
import com.metacube.priorityqueue.MyPriorityQueue;

public class Main {
	public static void main(String[] args) {
		MyPriorityQueue<Task> priorityQueue = new MyPriorityQueue<Task>();
		priorityQueue.enqueue(new Task(Designation.graduate, "I am graduate"));
		priorityQueue.enqueue(new Task(Designation.Undergraduate,
				"I am undergraduate"));
		priorityQueue.enqueue(new Task(Designation.chairman, "I am chairman1"));
		priorityQueue
				.enqueue(new Task(Designation.professor, "I am professor"));
		priorityQueue.enqueue(new Task(Designation.graduate, "I am graduate"));
		priorityQueue.enqueue(new Task(Designation.Undergraduate,
				"I am undergraduate"));
		priorityQueue.enqueue(new Task(Designation.chairman, "I am chairman2"));
		priorityQueue
				.enqueue(new Task(Designation.professor, "I am professor"));
		int size = priorityQueue.getSize();
		for (int i = 0; i < size; i++) {
			Task t = priorityQueue.dequeue();
			System.out.println(t.getDesignation() + "\t Job->"
					+ t.getJobToPrint());
		}

	}

}
