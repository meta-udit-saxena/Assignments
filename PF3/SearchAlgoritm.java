/**
 * Recursive functions for the following: linear search strategy. binary search
 * strategy.
 * 
 * @author Udit Saxena
 *
 */
public class SearchAlgoritm {
	/**
	 * function to search for a given value x in an array using linear search
	 * strategy.
	 * 
	 * @param array
	 *            - integer array (sorted)
	 * @param x
	 *            - number to be found
	 * @param startIndex
	 *            - starting index of array
	 * @return index of number or -1 if number not present
	 */
	int linearSearch(int[] array, int x, int startIndex) {
		try {
			// calling checkEmptyArray method from class QuickSortAlgorithm
			new QuickSortAlgorithm().checkEmptyArray(array);
			if (startIndex >= array.length) {
				return -1;
			}
			if (array[startIndex] == x) {
				return startIndex + 1;
			} else {
				return linearSearch(array, x, startIndex + 1);
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	/**
	 * to search for a given value x in an array using binary search strategy.
	 * 
	 * @param array
	 *            - integer array (sorted)
	 * @param x
	 *            - number to be found
	 * @param startIndex
	 *            - starting index of array
	 * @param endIndex
	 *            - end index of array
	 * @return index of number or -1 if number not present
	 */
	int binarySearch(int[] array, int startIndex, int endIndex, int x) {
		try {
			// calling checkEmptyArray method from class QuickSortAlgorithm
			new QuickSortAlgorithm().checkEmptyArray(array);
			if (startIndex < 0 || endIndex < 0 || startIndex >= array.length
					|| endIndex >= array.length) {
				return -1;
			}
			int mid = (startIndex + endIndex) / 2;
			// if number present at the mid of array
			if (array[mid] == x) {
				return mid + 1;
			}
			if (array[mid] < x) {
				/*
				 * change start index to mid+1 i.e element present in right part
				 * of array
				 */
				return binarySearch(array, mid + 1, endIndex, x);
			} else {
				/*
				 * change the end index to mid-1 i.e element present in left
				 * part of array
				 */
				return binarySearch(array, startIndex, mid - 1, x);
			}
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
