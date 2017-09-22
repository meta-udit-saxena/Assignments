package com.metacube.uniquecharacter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.metacube.dto.FindTotalUniqueCharacterDTO;

/**
 * The Class UniqueCharacters.
 */
public class UniqueCharacters {
	/** The string map works as cache memory */
	private static Map<String, Set<Character>> stringMap;

	/**
	 * Instantiates a new unique characters and also 
	 * if stringMap is null then initialize the map
	 * by doing this if we create multiple object of this class it uses the same map as cache memory
	 */
	public UniqueCharacters() {
		if (stringMap == null) {
			stringMap = new HashMap<String, Set<Character>>();
		}
	}

	/**
	 * Find total unique characters from input String.
	 *
	 * @param input
	 *            the input
	 * @return the total unique character
	 */
	public FindTotalUniqueCharacterDTO findTotalUniqueCharacters(String input) {
		FindTotalUniqueCharacterDTO dto = new FindTotalUniqueCharacterDTO();
		dto.fromCache = false;
		dto.success = true;
		if (input == null) {
			dto.success = false;
			dto.result = -1;
			return dto;
		}

		if (stringMap.containsKey(input)) {
			dto.result = stringMap.get(input).size();
			dto.fromCache = true;
			return dto;
		}

		Set<Character> characterSet = new HashSet<Character>();
		for (int index = 0; index < input.length(); index++) {
			characterSet.add(input.charAt(index));
		}

		stringMap.put(input, characterSet);
		dto.result = characterSet.size();
		return dto;
	}
}