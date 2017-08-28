package com.metacube.concordanceofcharacter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The Class Concordance.
 */
public class Concordance {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Concordance concordance = new Concordance();
		String input = "";
		for (String s : args) {
			input += s;
		}
		System.out.println(concordance.getCharactersMap(input));
	}

	/**
	 * Gets the character map.
	 *
	 * @param inputString
	 *            the input string
	 * @return the character map in string format
	 */
	public String getCharactersMap(String inputString) {
		try {
			// if string containing spaces
			String input = "";
			String[] array = inputString.split(" ");
			for (String str : array) {
				input += str;
			}
			Map<Character, List<Integer>> characterDictionary = new HashMap<Character, List<Integer>>();
			List<Integer> characterIndex = new ArrayList<Integer>();
			for (int index = 0; index < input.length(); index++) {
				// if character already in map then gets its list and index to
				// list
				if (characterDictionary.containsKey(input.charAt(index))) {
					characterIndex = characterDictionary.get(input
							.charAt(index));
					characterIndex.add(index);
				}
				// else create new List and index to it
				else {
					characterIndex = new ArrayList<Integer>();
					characterIndex.add(index);
					characterDictionary
							.put(input.charAt(index), characterIndex);
				}
			}
			String display = "";
			Set<Character> key = characterDictionary.keySet();
			for (Character ch : key) {
				display += ch + "=" + characterDictionary.get(ch) + " ";
			}

			return display;
		} catch (NullPointerException e) {

			return null;
		}
	}
}