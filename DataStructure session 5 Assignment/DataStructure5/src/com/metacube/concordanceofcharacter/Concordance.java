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
			input = input.concat(s);
		}
		String display = "";
		Map<Character, List<Integer>> characterDictionary = concordance
				.getCharactersMap("Hello World");
		Set<Character> key = characterDictionary.keySet();
		// display hash map data to console
		for (Character ch : key) {
			display += ch + "=" + characterDictionary.get(ch) + " ";
		}

		System.out.println(display);
	}

	/**
	 * Gets the character map.
	 *
	 * @param inputString
	 *            the input string
	 * @return the character map
	 */
	public Map<Character, List<Integer>> getCharactersMap(String inputString) {
		if (inputString == null) {
			return new HashMap<Character, List<Integer>>();
		}
		// if string containing spaces then split by spaces and concatenate the
		// strings
		String input = "";
		String[] array = inputString.split(" ");
		for (String str : array) {
			input = input.concat(str);
		}
		Map<Character, List<Integer>> characterDictionary = new HashMap<Character, List<Integer>>();
		Character character;
		for (int index = 0; index < input.length(); index++) {
			character = input.charAt(index);
			// if character not present in map then put character and new list
			// to map
			if (characterDictionary.containsKey(character) == false) {
				characterDictionary.put(character, new ArrayList<Integer>());
			}
			characterDictionary.get(character).add(index);
		}

		return characterDictionary;
	}
}
