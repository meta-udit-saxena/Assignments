package com.metacube.sortingsystem.facade;

import com.metacube.sortingsystem.Enum.Sort;
import com.metacube.sortingsystem.dto.SortResponse;
import com.metacube.sortingsystem.utility.Utility;

/**
 * The Class ComparisonSortFacade.
 */
public class ComparisonSortFacade implements SortingTechniques {
	private static ComparisonSortFacade comparisonSortingFacade;

	/**
	 * Constructor is Private to constraint the creation of object using new
	 * keyword
	 */
	private ComparisonSortFacade() {
	}

	/**
	 * Gets the single instance of ComparisonSortFacade.
	 *
	 * @return single instance of ComparisonSortFacade
	 */
	public static ComparisonSortFacade getInstance() {
		if (comparisonSortingFacade == null) {
			synchronized (ComparisonSortFacade.class) {
				if (comparisonSortingFacade == null) {
					comparisonSortingFacade = new ComparisonSortFacade();
				}
			}
		}
		return comparisonSortingFacade;
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
			if (inputArray.length > 10) {
				response.sortedArray = quickSort(inputArray);
				response.message = Sort.QUICK_SORT;
			} else {
				response.sortedArray = bubbleSort(inputArray);
				response.message = Sort.BUBBLE_SORT;
			}
		}
		return response;
	}

	/**
	 * Bubble sort.
	 *
	 * @param array
	 *            the array to sort
	 * @return the sorted array
	 */
	public int[] bubbleSort(int[] array) {
		if (array == null) {
			return null;
		}
		for (int index1 = 0; index1 < array.length; index1++) {
			for (int index2 = index1 + 1; index2 < array.length; index2++) {
				if (array[index1] > array[index2]) {
					Utility.swap(array, index1, index2);
				}
			}
		}

		return array;
	}
	/**
	 * Quick sort calls its privates method .
	 *
	 * @param array
	 *            the array
	 * @return the sorted Array
	 */
	public int[] quickSort(int[] array) {
		if (array == null) {
			return null;
		}
		quickSort(array, 0, array.length - 1);

		return array;
	}

	/**
	 * Perform Quick sort using recursion.
	 *
	 * @param array
	 *            the array
	 * @param startIndex
	 *            the start index
	 * @param endIndex
	 *            the end index
	 */
	private void quickSort(int[] array, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pivot = getPivotIndex(array, startIndex, endIndex);
			quickSort(array, startIndex, pivot - 1);
			quickSort(array, pivot + 1, endIndex);
		}
	}

	/**
	 * Gets the pivot index.
	 *
	 * @param array
	 *            the array
	 * @param startIndex
	 *            the start index
	 * @param endIndex
	 *            the end index
	 * @return the pivot index
	 */
	private int getPivotIndex(int[] array, int startIndex, int endIndex) {
		int partitionIndex = startIndex - 1;
		for (int index = startIndex; index <= endIndex; index++) {
			if (array[index] < array[endIndex]) {
				partitionIndex++;
				Utility.swap(array, partitionIndex, index);
			}
		}

		Utility.swap(array, ++partitionIndex, endIndex);

		return partitionIndex;
	}
}