import java.util.ArrayList;
import java.util.List;

/**
 * Generates all permutations of the given string using a backtracking
 * algorithm.In this program , we start fixing letters from start to the end of
 * the string.
 * 
 * @author Udit Saxena
 * 
 */
public class StringPermutation {

	List<String> permutedList = new ArrayList<String>();

	/**
	 * This function call two function 1. removeDuplicates & 2.getPermutation
	 * 
	 * @param str
	 *            - string
	 * @return List representing different permutation
	 */
	public List<String> generatePermutations(String str) {

		return removeDuplicates(getPermutations(str, 0, str.length() - 1));
	}

	/**
	 * Generates different permutations of given input string.
	 * 
	 * @param str
	 *            - String
	 * @param startIndex
	 *            - starting Index of string
	 * @param endIndex
	 *            - ending Index of String
	 * @return List representing all permutation.
	 */
	public List<String> getPermutations(String str, int startIndex, int endIndex) {
		// Recursive calls
		if (startIndex == endIndex) {
			permutedList.add(str);
		} else {
			for (int i = startIndex; i <= endIndex; i++) {
				str = swap(str, startIndex, i);
				getPermutations(str, startIndex + 1, endIndex);
				// BackTracking to move to origin configuration;
				str = swap(str, startIndex, i);
			}
		}

		return permutedList;
	}

	/**
	 * Swaps the letters at source index and destination index of the input
	 * string.
	 * 
	 * @param str
	 *            - string
	 * @param source
	 *            - index
	 * @param destination
	 *            - index
	 * @return Updated string with swapped letters
	 */
	public String swap(String str, int source, int destination) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[source];
		charArray[source] = charArray[destination];
		charArray[destination] = temp;
		return String.valueOf(charArray);
	}

	/**
	 * Remove the Duplicate permutations from the list
	 * 
	 * @param list
	 *            - list of all possible permutations
	 * @return uniqueList - list containing dissimilar permutations
	 */
	public List<String> removeDuplicates(List<String> list) {
		boolean flag = true;
		List<String> uniqueList = new ArrayList<String>();
		uniqueList.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			flag = true;
			for (int j = 0; j < uniqueList.size(); j++) {
				if (list.get(i).equals(uniqueList.get(j))) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				uniqueList.add(list.get(i));
			}
		}

		return uniqueList;
	}
}
