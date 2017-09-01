package com.metacube.sortingsystem.controller;

import com.metacube.sortingsystem.dto.ControllerResponse;
import com.metacube.sortingsystem.facade.SortingTechniques;
import com.metacube.sortingsystem.view.Main;

/**
 * The Class SortingSystemController.
 */
public class SortingSystemController {
	private SortingTechniques sortingTechniques;
	private Main main;

	/**
	 * Instantiates a new sorting system controller.
	 */
	public SortingSystemController() {
		sortingTechniques = new SortingTechniques();
		main = new Main();
	}

	/**
	 * Do comparison sort - perform quick sort or bubble sort based on condition
	 * if input number of element is greater than 10 than it perform quick sort
	 * else bubble sort
	 *
	 * @param inputArray
	 *            the input array
	 */
	public ControllerResponse doComparisonSort(int[] inputArray) {
		ControllerResponse response = new ControllerResponse();
		if (inputArray == null || inputArray.length == 0) {
			main.displayResponse(response);
		} else {
			if (inputArray.length > 10) {
				response.sortedArray = sortingTechniques.quickSort(inputArray);
				response.message = "Quick Sort";
			} else {
				response.sortedArray = sortingTechniques.bubbleSort(inputArray);
				response.message = "Bubble Sort";
			}

			main.displayResponse(response);
		}

		return response;
	}

	/**
	 * Do linear sort - perform radixSort or counting sort based on condition if
	 * any element digits are greater than 2 then it perform radix sort else
	 * counting sort
	 *
	 * @param inputArray
	 *            the input array
	 */
	public ControllerResponse doLinearSort(int[] inputArray) {
		ControllerResponse response = new ControllerResponse();
		if (inputArray == null || inputArray.length == 0) {
			main.displayResponse(response);
		} else {
			int min = sortingTechniques.getLowestValue(inputArray);
			int max = sortingTechniques.getLargestValue(inputArray);
			max = Math.abs(min) > max ? min : max;
			if (Math.abs(max) / 100 > 0) {
				response.sortedArray = sortingTechniques.radixSort(inputArray);
				response.message = "Radix Sort";
			} else {
				response.sortedArray = sortingTechniques
						.countingSort(inputArray);
				response.message = "Counting Sort";
			}

			main.displayResponse(response);
		}

		return response;
	}
}