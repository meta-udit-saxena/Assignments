package com.metacube.sortingsystem.utility;

public class Utility {

	/**
	 * Gets the lowest value.
	 *
	 * @param array
	 *            the array
	 * @return the lowest value
	 */
	public static Integer getLowestValue(int[] array) {
		if (array == null||array.length==0) {
			return 0;
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
	 * Gets the largest value from the given array.
	 *
	 * @param array
	 *            the array
	 * @return the largest value
	 */
	public static Integer getLargestValue(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
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
	 * Swap the value.
	 *
	 * @param array
	 *            the array
	 * @param index1
	 *            the index 1
	 * @param index2
	 *            the index 2
	 */
	public static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}