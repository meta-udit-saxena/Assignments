package com.metacube.sortingsystem.facade;

import com.metacube.sortingsystem.Enum.Sort;
import com.metacube.sortingsystem.dto.CountingSortRequest;
import com.metacube.sortingsystem.dto.SortResponse;
import com.metacube.sortingsystem.utility.Utility;

/**
 * The Class LinearSortFacade.
 */
public class LinearSortFacade implements SortingTechniques {
	private static LinearSortFacade linearSortfacade;

	/**
	 * Constructor is Private to constraint the creation of object using new
	 * keyword
	 */
	private LinearSortFacade() {
	}

	/**
	 * Gets the single instance of LinearSortFacade.
	 *
	 * @return single instance of LinearSortFacade
	 */
	public static LinearSortFacade getInstance() {
		if (linearSortfacade == null) {
			synchronized (LinearSortFacade.class) {
				if (linearSortfacade == null) {
					linearSortfacade = new LinearSortFacade();
				}
			}
		}

		return linearSortfacade;
	}

	/**
	 * Sort the array.
	 *
	 * @param inputArray
	 *            the input array
	 * @return the sort response contains sorted array and message
	 */
	@Override
	public SortResponse sort(int[] inputArray) {
		SortResponse response = new SortResponse();
		if (inputArray != null) {
			int min = Utility.getLowestValue(inputArray);
			int max = Utility.getLargestValue(inputArray);
			max = Math.abs(min) > max ? min : max;
			if (Math.abs(max) / 100 > 0) {
				response.sortedArray = radixSort(inputArray);
				response.message = Sort.RADIX_SORT;
			} else {
				response.sortedArray = countingSort(inputArray);
				response.message = Sort.COUNTING_SORT;
			}
		}

		return response;
	}

	/**
	 * Counting sort call its private function .
	 *
	 * @param array
	 *            the array
	 * @return the sorted array
	 */
	public int[] countingSort(int[] array) {
		if (array == null) {
			return null;
		}
		int minimum = Utility.getLowestValue(array);
		for (int index = 0; index < array.length; index++) {
			array[index] -= minimum;
		}
		CountingSortRequest request = new CountingSortRequest();
		request.array = array;
		request.divisor = 1;
		request.arraySize = Utility.getLargestValue(array) + 1;
		request.mod = request.arraySize;
		countingSort(request);
		for (int index = 0; index < array.length; index++) {
			array[index] += minimum;
		}

		return array;
	}

	/**
	 * Radix sort.
	 *
	 * @param array
	 *            the array
	 * @return the sorted array
	 */
	public int[] radixSort(int[] array) {
		if (array == null) {
			return null;
		}
		int minimum = Utility.getLowestValue(array);
		for (int index = 0; index < array.length; index++) {
			array[index] -= minimum;
		}

		CountingSortRequest request = new CountingSortRequest();
		request.array = array;
		request.arraySize = 10;
		request.mod = 10;
		int maximum = Utility.getLargestValue(array);
		for (int count = 1; maximum / count > 0; count *= 10) {
			request.divisor = count;
			countingSort(request);
		}

		for (int index = 0; index < array.length; index++) {
			array[index] += minimum;
		}

		return array;
	}

	/**
	 * Counting sort.
	 *
	 * @param request
	 *            the request
	 * @return the sorted array.
	 */
	private int[] countingSort(CountingSortRequest request) {
		int exp = request.divisor;
		int mod = request.mod;
		int[] array = request.array;
		int[] countingArray = new int[request.arraySize];
		int[] result = new int[array.length];
		// increase count on particular index
		for (int index : array) {
			countingArray[(index / exp) % mod]++;
		}
		// adding count with its previous count
		for (int index = 1; index < countingArray.length; index++) {
			countingArray[index] += countingArray[index - 1];
		}
		// insert the data in result array at particular index
		for (int index = array.length - 1; index >= 0; index--) {
			result[--countingArray[(array[index] / exp) % mod]] = array[index];
		}
		// sorting the original array
		for (int index = 0; index < array.length; index++) {
			array[index] = result[index];
		}

		return result;
	}
}