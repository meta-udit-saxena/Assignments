package com.metacube.testcases;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.metacube.binarysearch.Search;

@RunWith(Parameterized.class)
public class SearchTestCasesForString {
	Search<String> search;

	@Before
	public void setUpObject() {
		search = new Search<String>();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] {
				{ "a", 0 },
				{ "x", -1 },
				{ "c", 2 },
				{ "d", 5 },
				{ "z", 10 },
				{ "", -1 } });
	}

	@Parameter(0)
	public String data;
	@Parameter(1)
	public int expectedPosition;

	@Test
	public void binarySearchTestsCases() {
		String[] arr = { "a", "b", "c", "c", "c", "d", "d", "e", "f", "g", "z",
				"z", "z", "z" };
		int actualPosition = search.binarySearch(arr, data);
		assertEquals(actualPosition, expectedPosition);
	}
}