package com.metacube.sortingsystem.testcases;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.metacube.sortingsystem.facade.SortingTechniques;

@RunWith(Parameterized.class)
public class SortingTechniquesTestCases {
	SortingTechniques sortingTechniques;

	@Before
	public void setUpObject() {
		sortingTechniques = new SortingTechniques();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][]{
				{ new int[]{25, 65, 89, 65, 32, 0, 12, -12},new int[]{-12, 0, 12, 25, 32, 65, 65, 89} },
				{ new int[]{-225, -65, -89, -65, -32, -0, -12, 0},new int[]{-225, -89, -65, -65, -32, -12, 0, 0 } },
				{ new int[]{225, 65, 89, 6500, 32, 0, 2},new int[]{0, 2, 32, 65, 89, 225, 6500 } },
				{ new int[]{}, null },
				{ null, null }});

	}

	@Parameter(0)
	public int[] input;
	
	@Parameter(1)
	public int[] expected;

	@Test
	public void GivenArray_WhenCountingSort_ThenSortedArray() {
		int[] actual = sortingTechniques.countingSort(input);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void GivenArray_WhenRadixSort_ThenSortedArray() {
		int[] actual = sortingTechniques.radixSort(input);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void GivenArray_WhenBubbleSort_ThenSortedArray() {
		int[] actual = sortingTechniques.bubbleSort(input);
		assertArrayEquals(actual, expected);
	}

	@Test
	public void GivenArray_WhenQuickSort_ThenSortedArray() {
		int[] actual = sortingTechniques.quickSort(input);
		assertArrayEquals(actual, expected);
	}
}