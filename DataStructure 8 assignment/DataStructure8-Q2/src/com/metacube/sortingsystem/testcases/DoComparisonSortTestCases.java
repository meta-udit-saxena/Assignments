package com.metacube.sortingsystem.testcases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.metacube.sortingsystem.Enum.Sort;
import com.metacube.sortingsystem.controller.SortingSystemController;
import com.metacube.sortingsystem.dto.SortResponse;

@RunWith(Parameterized.class)
public class DoComparisonSortTestCases {
	SortingSystemController controller;

	@Before
	public void setUpObject() {
		controller = new SortingSystemController();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][]{
				{new int[]{25, 65, 89, 65, 32, 0, 12, -12},	new int[]{-12, 0, 12, 25, 32, 65, 65, 89},Sort.BUBBLE_SORT},
				{new int[]{-25, 65, -89, 65, 32, 0, 12, -12, 10, 100,15, 5, 2},	new int[]{-89, -25, -12, 0, 2, 5, 10, 12, 15, 32, 65,65, 100}, Sort.QUICK_SORT},
				{new int[]{}, new int[]{}, Sort.BUBBLE_SORT},
				{null, null, null}});
	}

	@Parameter(0)
	public int[] input;

	@Parameter(1)
	public int[] expectedArray;

	@Parameter(2)
	public Sort message;

	@Test
	public void GivenArray_WhenCountingSort_ThenSortedArray() {
		SortResponse actualResponse = controller.doComparisonSort(input);
		assertArrayEquals(actualResponse.sortedArray, expectedArray);
		assertEquals(actualResponse.message, message);
	}
}