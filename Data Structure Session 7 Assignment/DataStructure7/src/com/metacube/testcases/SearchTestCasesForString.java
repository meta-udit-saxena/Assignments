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
		return Arrays
				.asList(new Object[][] {
						{ new String[] { "a", "b", "c", "c", "c", "d", "d" },"a", 0 },
						{ new String[] { "a", "b", "c", "c", "c", "d", "d" },"x", -1 },
						{ new String[] { "a" }, "a", 0 },
						{ new String[] {}, "d", -1 },
						{ null, "z", -1 } });
	}

	@Parameter(0)
	public String[] array;
	
	@Parameter(1)
	public String searchData;
	
	@Parameter(2)
	public int expectedPosition;

	@Test
	public void binarySearchInStringArrayTestsCases() {
		int actualPosition = search.binarySearch(array, searchData);
		assertEquals(actualPosition, expectedPosition);
	}
}