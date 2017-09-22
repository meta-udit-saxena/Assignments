package com.metacube.sortingsystem.controller;

import com.metacube.sortingsystem.dto.SortResponse;
import com.metacube.sortingsystem.facade.ComparisonSortFacade;
import com.metacube.sortingsystem.facade.LinearSortFacade;
import com.metacube.sortingsystem.view.Main;

/**
 * The Class SortingSystemController.
 */
public class SortingSystemController {

	/**
	 * Do comparison sort - perform quick sort or bubble sort based on condition
	 * if input number of element is greater than 10 than it perform quick sort
	 * else bubble sort
	 *
	 * @param inputArray
	 *            the input array
	 */
	public SortResponse doComparisonSort(int[] inputArray) {
		SortResponse response = ComparisonSortFacade.getInstance().sort(
				inputArray);
		new Main().displayResponse(response);
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
	public SortResponse doLinearSort(int[] inputArray) {
		SortResponse response = LinearSortFacade.getInstance().sort(inputArray);
		new Main().displayResponse(response);
		return response;
	}
}