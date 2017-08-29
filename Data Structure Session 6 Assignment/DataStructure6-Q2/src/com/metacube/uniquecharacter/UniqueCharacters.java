package com.metacube.uniquecharacter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * The Class UniqueCharacters.
 */
public class UniqueCharacters {

	/** The string map. */
	private Map<String, Set<Character>> stringMap;

	/**
	 * Instantiates a new unique characters.
	 */
	public UniqueCharacters() {
		stringMap = new HashMap<String, Set<Character>>();
	}

	/**
	 * Find total unique characters from input String.
	 *
	 * @param input
	 *            the input
	 * @return the total unique character
	 */
	public int findTotalUniqueCharacters(String input) {
		if (input == null) {
			return -1;
		}
		if (stringMap.containsKey(input)) {
			System.out.println("Getting From cache");
			return stringMap.get(input).size();
		}

		Set<Character> characterSet = new HashSet<Character>();
		for (int index = 0; index < input.length(); index++) {
			if (input.charAt(index) != ' ') {
				characterSet.add(input.charAt(index));
			}
		}

		stringMap.put(input, characterSet);

		return characterSet.size();
	}

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UniqueCharacters uniqueCharacters = new UniqueCharacters();
		String input = scan.nextLine();
		while (input.equalsIgnoreCase("exit") == false) {
			System.out.println(uniqueCharacters
					.findTotalUniqueCharacters(input));
			input = scan.nextLine();
		}
	}
}
