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
import com.metacube.sortingsystem.controller.SortingSystemController;
import com.metacube.sortingsystem.dto.ControllerResponse;

@RunWith(Parameterized.class)
public class DoLinearSortTestCases {
	SortingSystemController controller;

	@Before
	public void setUpObject() {
		controller = new SortingSystemController();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][]{
				{ new int[]{25, 65, 89, 65, 32, 0, 12, -12},new int[]{-12, 0, 12, 25, 32, 65, 65, 89},"Counting Sort" },
				{ new int[]{-2555, -890, 890, 10000, 13452, -34521},new int[]{-34521, -2555, -890, 890, 10000, 13452},"Radix Sort" },
				{ new int[]{}, new int[]{}, "Empty Array"}});
	}

	@Parameter(0)
	public int[] input;

	@Parameter(1)
	public int[] expectedArray;

	@Parameter(2)
	public String message;

	@Test
	public void GivenArray_WhenCountingSort_ThenSortedArray() {
		ControllerResponse actualResponse = controller.doLinearSort(input);
		assertArrayEquals(actualResponse.sortedArray, expectedArray);
		assertEquals(actualResponse.message, message);
	}
}