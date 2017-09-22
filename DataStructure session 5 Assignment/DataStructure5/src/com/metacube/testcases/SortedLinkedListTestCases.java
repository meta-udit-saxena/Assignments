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
import com.metacube.insertinsortedlinkedlist.SortedLinkedList;

@RunWith(Parameterized.class)
public class SortedLinkedListTestCases {
	SortedLinkedList<Integer> sortedLinkedList;

	@Before
	public void setUpObject() {
		sortedLinkedList = new SortedLinkedList<Integer>();
		sortedLinkedList.add(10);
		sortedLinkedList.add(20);
		sortedLinkedList.add(30);
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] {
				{ 12, 1 },
				{ 22, 2 },
				{ 0, 0 },
				{ 8, 0 },
				{ 33, 3 },
				{ 10, 0 },
				{ 20, 1 },
				{ 30, 2 },
				{ null, -1 } });
	}

	@Parameter(0)
	public Integer input;
	@Parameter(1)
	public int expectedPosition;

	@Test
	public void GivenMultipleValuesInserted_WhenAdd_ThenAddedAtCorrectPosition() {
		sortedLinkedList.add(input);
		int actual = sortedLinkedList.getIndexOfElement(input);
		assertEquals(expectedPosition, actual);
	}
}
