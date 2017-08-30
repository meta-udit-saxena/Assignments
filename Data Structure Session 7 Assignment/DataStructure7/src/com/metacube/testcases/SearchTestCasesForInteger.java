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
				{ 2, 1 },
				{ 10, -1 },
				{ 4, 10 },
				{ 3, 6 },
				{ 9, 15},
				{ 123, -1 } });
	}

	@Parameter(0)
	public int data;
	@Parameter(1)
	public int expectedPosition;

	@Test
	public void binarySearchTestsCases() {
		Integer[] arr = { 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9 };
		int actualPosition = search.binarySearch(arr, data);
		assertEquals(actualPosition, expectedPosition);
	}
}