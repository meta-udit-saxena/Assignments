package com.metacube.sortingsystem.facade;

import com.metacube.sortingsystem.dto.CountingSortRequest;

/**
 * The Class SortingTechniques contains Bubble sort, Quick sort, Counting sort
 * and Radix sort.
 */
public class SortingTechniques {

	/**
	 * Bubble sort.
	 *
	 * @param array
	 *            the array to sort
	 * @return the sorted array
	 */
	public int[] bubbleSort(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		for (int index1 = 0; index1 < array.length; index1++) {
			for (int index2 = index1 + 1; index2 < array.length; index2++) {
				if (array[index1] > array[index2]) {
					swap(array, index1, index2);
				}
			}
		}

		return array;
	}

	/**
	 * Swap the value.
	 *
	 * @param array
	 *            the array
	 * @param index1
	 *            the index 1
	 * @param index2
	 *            the index 2
	 */
	private void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	/**
	 * Quick sort calls its privates method .
	 *
	 * @param array
	 *            the array
	 * @return the sorted Array
	 */
	public int[] quickSort(int[] array) {
		if (array == null || array.length == 0) {
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
				swap(array, partitionIndex, index);
			}
		}

		swap(array, ++partitionIndex, endIndex);

		return partitionIndex;
	}

	/**
	 * Counting sort call its private function .
	 *
	 * @param array
	 *            the array
	 * @return the sorted array
	 */
	public int[] countingSort(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		int minimum = getLowestValue(array);
		for (int index = 0; index < array.length; index++) {
			array[index] -= minimum;
		}
		CountingSortRequest request = new CountingSortRequest();
		request.array = array;
		request.count = 1;
		request.max = getLargestValue(array) + 1;
		request.mod = request.max;
		countingSort(request);
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
		int exp = request.count;
		int mod = request.mod;
		int[] array = request.array;
		int[] countingArray = new int[request.max];
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

	/**
	 * Gets the largest value from the given array.
	 *
	 * @param array
	 *            the array
	 * @return the largest value
	 */
	public Integer getLargestValue(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		int max = Integer.MIN_VALUE;
		for (int i : array) {
			if (max < i) {
				max = i;
			}
		}

		return max;
	}

	/**
	 * Gets the lowest value.
	 *
	 * @param array
	 *            the array
	 * @return the lowest value
	 */
	public Integer getLowestValue(int[] array) {
		if (array == null) {
			return null;
		}
		int min = Integer.MAX_VALUE;
		for (int i : array) {
			if (min > i) {
				min = i;
			}
		}

		return min;
	}

	/**
	 * Radix sort.
	 *
	 * @param array
	 *            the array
	 * @return the sorted array
	 */
	public int[] radixSort(int[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		int minimum = getLowestValue(array);
		for (int index = 0; index < array.length; index++) {
			array[index] -= minimum;
		}

		CountingSortRequest request = new CountingSortRequest();
		request.array = array;
		request.max = 10;
		request.mod = 10;
		int maximum = getLargestValue(array);
		for (int count = 1; maximum / count > 0; count *= 10) {
			request.count = count;
			countingSort(request);
		}

		for (int index = 0; index < array.length; index++) {
			array[index] += minimum;
		}

		return array;
	}
}