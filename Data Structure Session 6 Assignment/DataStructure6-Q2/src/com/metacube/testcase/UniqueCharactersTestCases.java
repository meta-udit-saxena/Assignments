package com.metacube.testcase;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.metacube.dto.FindTotalUniqueCharacterDTO;
import com.metacube.uniquecharacter.UniqueCharacters;

@RunWith(Parameterized.class)
public class UniqueCharactersTestCases {
	UniqueCharacters uniqueCharacters;

	@Before
	public void setUpBeforeClass() throws Exception {
		uniqueCharacters = new UniqueCharacters();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] { { "udit", 4, true, false },
				{ "udit saxena", 10, true, false },
				{ "@#$%^&*()!_+", 12, true, false },
				{ "        ", 1, true, false }, 
				{ "aABb", 4, true, false },
				{ "udit saxena", 10, true, true },
				{ "aABb", 4, true, true },
				{ "udit", 4, true, true },
				{ "", 0, true, false },
				{ null, -1, false, false } });
	}

	@Parameter(0)
	public String input;
	@Parameter(1)
	public int expectedData;
	@Parameter(2)
	public boolean isSuccess;
	@Parameter(3)
	public boolean fromCache;

	@Test
	public void GivenMultipleString_WhenFindTotalUniqueCharacters_ThenRespectiveAnswer() {
		FindTotalUniqueCharacterDTO actual = uniqueCharacters
				.findTotalUniqueCharacters(input);
		FindTotalUniqueCharacterDTO expected = new FindTotalUniqueCharacterDTO();
		expected.result = expectedData;
		expected.fromCache = fromCache;
		expected.success = isSuccess;
		assertEquals(actual, expected);
	}
}