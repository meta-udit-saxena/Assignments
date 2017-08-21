package com.metacube.testcase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import javax.swing.SortOrder;

import org.junit.Before;
import org.junit.Test;

import com.metacube.listinterface.MyList;
import com.metacube.myarraylist.MyArrayList;

public class MyArrayListTestCases<E extends Comparable<E>> {
	MyList<String> arrayList;

	@Before
	public void setUpObject() {
		arrayList = new MyArrayList<String>();
		arrayList.add("Abc");
		arrayList.add("xyz");
	}

	@Test
	public void GivenElementAdded_WhenAdd_ThenTrue() {
		boolean actual = arrayList.add("Udit");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenListAdded_WhenAdd_ThenTrue() {
		MyList<String> secondList = new MyArrayList<String>();
		secondList.add("xyz");
		boolean actual = arrayList.add(secondList);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenEmptyListAdded_WhenAdd_ThenFalse() {
		MyList<String> secondList = new MyArrayList<String>();
		boolean actual = arrayList.add(secondList);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenTwoElementPresent_WhenSize_Then1() {
		int actual = arrayList.size();
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenIndexIsValidtElement_ThenElement() {
		Object actual = arrayList.getElement(1);
		Object expected = "xyz";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenEmptyList_WhenGetElement_ThenNull() {
		arrayList.clear();
		Object actual = arrayList.getElement(1);
		Object expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenNegativeIndex_WhenGetElement_ThenNull() {
		Object actual = arrayList.getElement(-1);
		Object expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenIndexIsGreaterThanSize_WhenGetElement_ThenNull() {
		Object actual = arrayList.getElement(2);
		Object expected = null;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementInsertAtValidIndex_WhenAdd_ThenTrue() {
		boolean actual = arrayList.add(0, "Udit");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementInsertAtInValidIndex_WhenAdd_ThenFalse() {
		boolean actual = arrayList.add(-1, "Udit");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementRemoveFromValidIndex_WhenRemove_ThenTrue() {
		boolean actual = arrayList.remove(1);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementRemoveFromInValidIndex_WhenRemove_ThenFalse() {
		boolean actual = arrayList.remove(-1);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenValidElementRemove_WhenRemove_ThenTrue() {
		boolean actual = arrayList.remove("xyz");
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenInValidElementRemove_WhenRemove_ThenFalse() {
		boolean actual = arrayList.remove("xqwer");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenValidPosition_WhengetFirstIndexAfterPosition_ThenValidIndex() {
		arrayList.add("Abc");
		arrayList.add("xyz");
		arrayList.add("Abc");
		int actual = arrayList.getFirstIndexAfterPosition("Abc", 2);
		int expected = 4;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenInValidPosition_WhengetFirstIndexAfterPosition_ThenMinusOne() {
		arrayList.add("Abc");
		arrayList.add("xyz");
		arrayList.add("Abc");
		int actual = arrayList.getFirstIndexAfterPosition("Abc", 5);
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhengetFirstIndexAfterPosition_ThenMinusOne() {
		arrayList.add("Abc");
		arrayList.add("xyz");
		arrayList.add("Abc");
		int actual = arrayList.getFirstIndexAfterPosition(null, 5);
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenValidElement_WhengetFirstIndex_ThenValidIndex() {
		arrayList.add("Abc");
		arrayList.add("xyz");
		arrayList.add("Abc");
		int actual = arrayList.getFirstIndex("xyz");
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenInValidElement_WhengetFirstIndex_ThenValidIndex() {
		arrayList.add("Abc");
		arrayList.add("xyz");
		arrayList.add("Abc");
		int actual = arrayList.getFirstIndex("sadsad");
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenArrayList_WhenReverse_ThenReversedList() {
		arrayList.add("qaz");
		arrayList.add("wsx");
		arrayList.add("edc");
		arrayList.reverse();
		Object[] actual = arrayList.getList();
		Object[] expected = { "edc", "wsx", "qaz", "xyz", "Abc" };
		assertArrayEquals(expected, actual);
	}

	@Test
	public void GiventArrayList_WhenSort_ThenSortedArrayList() {
		arrayList.add("qaz");
		arrayList.add("wsx");
		arrayList.add("edc");
		arrayList.sort();
		Object[] actual = arrayList.getList();
		Object[] expected = { "Abc", "edc", "qaz", "wsx", "xyz" };
		assertArrayEquals(actual, expected);
	}

	@Test
	public void GiventArrayList_WhenSortInDescendingOrder_ThenSortedArrayList() {
		arrayList.add("qaz");
		arrayList.add("wsx");
		arrayList.add("edc");
		arrayList.sort(SortOrder.DESCENDING);
		Object[] actual = arrayList.getList();
		Object[] expected = { "xyz", "wsx", "qaz", "edc", "Abc" };

	}
}
