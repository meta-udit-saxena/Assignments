package com.metacube.testcases;

import static org.junit.Assert.assertEquals;
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
public class SearchTestCasesForInteger {
	Search<Integer> search;

	@Before
	public void setUpObject() {
		search = new Search<Integer>();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] {
				{ new Integer[] { 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9 }, 2, 1 },
				{ new Integer[] { 1, 2, 3, 4, 5, 6 }, 4, 3 },
				{ new Integer[] { 1, 2 }, 3, -1 },
				{ new Integer[] { 1 }, 1, 0 },
				{ new Integer[] {}, 2, -1 },
				{ null, 2, -1 } });
	}

	@Parameter(0)
	public Integer[] array;

	@Parameter(1)
	public int data;

	@Parameter(2)
	public int expectedPosition;

	@Test
	public void binarySearchInIntegerArrayTestsCases() {
		int actualPosition = search.binarySearch(array, data);
		assertEquals(actualPosition, expectedPosition);
	}
}