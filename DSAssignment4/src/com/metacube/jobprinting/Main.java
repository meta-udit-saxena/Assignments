package com.metacube.jobprinting;

/** 
 * @author Udit Saxena
 * @project Job Printing using Heap
 * 
 */
import java.util.HashMap;
import java.util.Scanner;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */

	@SuppressWarnings({ "unchecked", "static-access" })
	public static void main(String[] args) {
		HeapSort heapsort = new HeapSort();
		HashMap<String, Integer> priorityMap = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of task");
		int num = 0;
		boolean flag = true;

		while (flag) {

			try {
				num = Integer.parseInt(scanner.nextLine());
				if (String.class.isInstance(num)) {
					throw new IllegalArgumentException();
				}
				flag = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Please Enter vaild  Choice");
			}
		}

		Task jobQueue[] = new Task[num];
		String msg, desg = null;
		Task job;
		Input input = new Input();
		priorityMap = input.getPriorityMap();
		for (int i = 0; i < num; i++) {
			job = new Task();
			System.out.println("Enter Designation");

			boolean checkDesignation = true;

			while (checkDesignation) {
				desg = scanner.nextLine().toLowerCase();
				try {
					if (!(desg.equals("chairman") || desg.equals("professors")
							|| desg.equals("graduate") || desg
								.equals("undergraduates"))) {
						throw new IllegalArgumentException();
					}
					checkDesignation = false;
				} catch (IllegalArgumentException e) {
					System.out.println("Please Enter a Valid Designation");
				}
			}
			System.out.println("Enter msg");
			msg = scanner.nextLine();
			job.setDesignation(desg);
			job.setMesssage(msg);
			job.setPriority(priorityMap.get(desg));
			jobQueue[i] = job;
		}
		heapsort.heapSort(jobQueue);
		for (int i = 0; i < num; i++) {
			System.out.println("Message from: " + jobQueue[i].getDesignation()
					+ " is " + jobQueue[i].getMesssage());
		}
		scanner.close();
	}
}
