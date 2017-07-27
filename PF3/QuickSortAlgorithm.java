/**
 * Recursive function to sort the given array in ascending order using quick
 * sort Algorithm.
 * 
 * @author Udit Saxena
 *
 */

public class QuickSortAlgorithm {
	/**
	 * function for finding partition Index
	 * 
	 * @param array
	 *            - integer array (Unsorted)
	 * @param startIndex
	 *            - starting index of array
	 * @param endIndex
	 *            - end index of array
	 * @return partitionIndex 
	 * 			  -index from where array is divided into two part
	 */
	int returnPartitionIndex(int[] array, int startIndex, int endIndex) {
		try {
			checkEmptyArray(array);
			int partitionIndex = startIndex - 1;
			int pivot = array[endIndex];
			for (int i = startIndex; i < endIndex; i++) {
				if (array[i] < pivot) {
					partitionIndex++;
					swap(array, i, partitionIndex);
				}
			}
			swap(array, endIndex, partitionIndex + 1);
			return partitionIndex + 2;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	/**
	 * recursive function of quick sort algorithm
	 * 
	 * @param array
	 *            - integer array (Unsorted)
	 * @param startIndex
	 *            - starting index of array
	 * @param endIndex
	 *            - end index of array
	 */
	void quickSort(int[] array, int startIndex, int endIndex) {
		try {
			checkEmptyArray(array);
			if (startIndex < endIndex) {
				int partitionIndex = returnPartitionIndex(array, startIndex,
						endIndex) - 1;
				quickSort(array, partitionIndex + 1, endIndex);
				quickSort(array, startIndex, partitionIndex - 1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * function for swapping two values in an array
	 * 
	 * @param array
	 *            - integer array
	 * @param firstElementIndex
	 *            - index of firstElement
	 * @param secondElementIndex
	 *            - index of secondElement
	 */
	void swap(int[] array, int firstElementIndex, int secondElementIndex) {
		try {
			checkEmptyArray(array);
			int temp = array[firstElementIndex];
			array[firstElementIndex] = array[secondElementIndex];
			array[secondElementIndex] = temp;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * 
	 * @param array
	 *            - integer array
	 * @throws Exception
	 *             "Array is Empty"
	 */
	void checkEmptyArray(int[] array) throws Exception {
		if (array.length == 0) {
			throw new Exception("Array is Empty");
		}
	}

}
