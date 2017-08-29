package com.metacube.testcase;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.metacube.uniquecharacter.UniqueCharacters;

@RunWith(Parameterized.class)
public class UniqueCharactersTestCases {
	static UniqueCharacters uniqueCharacters;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uniqueCharacters = new UniqueCharacters();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] {
				{ "udit", 4 },
				{ "udit saxena", 9 },
				{ "@#$%^&*()!_+", 12 },
				{ "           ", 0 },
				{ "aABb", 4 },
				{ "1234567890", 10 },
				{ "aABb", 4 },
				{ "udit", 4 },
				{ null, -1 } });
	}

	@Parameter(0)
	public String input;
	@Parameter(1)
	public int expected;

	@Test
	public void GivenMultipleString_WhenFindTotalUniqueCharacters_ThenRespectiveAnswer() {
		int actual = uniqueCharacters.findTotalUniqueCharacters(input);
		assertEquals(actual, expected);
	}
}
