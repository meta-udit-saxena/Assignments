package com.metacube.testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.SortOrder;

import org.junit.Before;
import org.junit.Test;

import com.metacube.linkedlistinterface.MyLinkedList;
import com.metacube.singlylinkedlist.MySinglyLinkedList;

public class MySinglyLinkedListTestCases<E extends Comparable<E>> {

	MyLinkedList<Integer> singlyLinkedList;

	@Before
	public void setUpObject() {
		singlyLinkedList = new MySinglyLinkedList<Integer>();
		singlyLinkedList.add(10);
		singlyLinkedList.add(20);
	}

	@Test
	public void GivenElementIsValid_WhenAdd_ThenTrue() {
		boolean actual = singlyLinkedList.add(1);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenAdd_ThenFalse() {
		boolean actual = singlyLinkedList.add(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsValid_WhenaddFirst_ThenTrue() {
		boolean actual = singlyLinkedList.addFirst(1);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenaddFirst_ThenFalse() {
		boolean actual = singlyLinkedList.addFirst(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenPositionIsValid_WhenAdd_ThenTrue() {
		boolean actual = singlyLinkedList.add(1, 10);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenPositionIsValidButElementIsNull_WhenAdd_ThenFalse() {
		boolean actual = singlyLinkedList.add(1, null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void GivenPosititonIsInValid_WhenAdd_ThenIndexOutOfBoundException() {
		singlyLinkedList.add(-1, 10);
	}

	@Test
	public void GivenElementIsValid_WhenAddLast_ThenTrue() {
		boolean actual = singlyLinkedList.addLast(2);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenAddLast_ThenFalse() {
		boolean actual = singlyLinkedList.addLast(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenLinkedListHaveTwoElement_WhenSize_Then2() {
		int actual = singlyLinkedList.size();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenLinkedListIsEmpty_WhenSize_Then0() {
		singlyLinkedList.clear();
		int actual = singlyLinkedList.size();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsValid_WhenContains_ThenTrue() {
		boolean actual = singlyLinkedList.contains(10);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsInValid_WhenContains_ThenFalse() {
		boolean actual = singlyLinkedList.contains(30);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenContains_ThenFalse() {
		boolean actual = singlyLinkedList.contains(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenIndexIsValid_WhenGet_ThenElement() {
		Object actual = singlyLinkedList.get(1);
		Object expected = 10;
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void GivenIndexIsInValid_WhenGet_ThenIndexOutOfBoundException() {
		singlyLinkedList.get(10);
	}

	@Test
	public void GivenLinkedListIsNotEmpty_WhenGetFirst_ThenElement() {
		Object actual = singlyLinkedList.getFirst();
		Object expected = 10;
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenLinkedListIsEmpty_WhenGetFirst_ThenNoSuchElementException() {
		singlyLinkedList.clear();
		singlyLinkedList.getFirst();
	}

	@Test
	public void GivenLinkedListIsNotEmpty_WhenGetLast_ThenElement() {
		Object actual = singlyLinkedList.getLast();
		Object expected = 20;
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenLinkedListIsEmpty_WhenGetLast_ThenNoSuchElementException() {
		singlyLinkedList.clear();
		singlyLinkedList.getLast();
	}

	@Test
	public void GivenElementIsValid_WhenIndexOF_ThenIndex() {
		int actual = singlyLinkedList.indexOf(10);
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsInvalid_WhenIndexOF_ThenIndex() {
		int actual = singlyLinkedList.indexOf(null);
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenIndexOF_ThenIndex() {
		int actual = singlyLinkedList.indexOf(null);
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenPositionIsValid_WhenRemoveByPosition_ThenElement() {
		int actual = singlyLinkedList.removeByPosition(1);
		int expected = 10;
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenPositionIsInValid_WhenRemoveByPosition_ThenNoSuchElementException() {
		singlyLinkedList.removeByPosition(3);
	}

	@Test
	public void GivenElementIsValid_WhenRemove_ThenTrue() {
		boolean actual = singlyLinkedList.remove(10);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenElementIsInValid_WhenRemove_ThenNoSuchElementException() {
		singlyLinkedList.remove(30);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenElementIsNull_WhenRemove_ThenNoSuchElementException() {
		singlyLinkedList.remove(null);
	}

	@Test
	public void GivenIndexIsValid_WhenSet_ThenElement() {
		Object actual = singlyLinkedList.set(1, 100);
		Object expected = 100;
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void GivenIndexIsInValid_WhenSet_ThenIndexOutOfBoundsException() {
		singlyLinkedList.set(10, 100);
	}

	@Test(expected = NullPointerException.class)
	public void GivenLinkedListIsEmpty_WhenReverse_ThenNullPointerException() {
		singlyLinkedList.clear();
		singlyLinkedList.reverse();
	}

	@Test
	public void GivenLinkedListIsNotEmpty_WhenReverse_ThenReverseLinkedList() {
		singlyLinkedList.add(30);
		singlyLinkedList.add(40);
		singlyLinkedList.reverse();
		int[] actual = new int[4];
		int index =0;
		Iterator<Integer> iterator = singlyLinkedList.iterator();
		while(iterator.hasNext()) {
			actual[index++]=iterator.next();
		}
		int[] expected = {40,30,20,10};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void GivenLinkedList_WhenSort_ThenSortedLinkedList() {
		singlyLinkedList.add(2);
		singlyLinkedList.add(4);
		singlyLinkedList.sort();
		int[] actual = new int[4];
		int index =0;
		Iterator<Integer> iterator = singlyLinkedList.iterator();
		while(iterator.hasNext()) {
			actual[index++]=iterator.next();
		}
		int[] expected = {2,4,10,20};
		assertArrayEquals(expected, actual);
	}
	@Test
	public void GivenLinkedList_WhenSortInDescending_ThenDescendingOrderSortedLinkedList() {
		singlyLinkedList.add(2);
		singlyLinkedList.add(4);
		singlyLinkedList.sort(SortOrder.DESCENDING);
		int[] actual = new int[4];
		int index =0;
		Iterator<Integer> iterator = singlyLinkedList.iterator();
		while(iterator.hasNext()) {
			actual[index++]=iterator.next();
		}
		int[] expected = {20,10,4,2};
		assertArrayEquals(expected, actual);
	}
	@Test(expected=NullPointerException.class)
	public void GivenLinkedListIsEmpty_WhenSort_ThenNullPointerException() {
		singlyLinkedList.clear();
		singlyLinkedList.sort(SortOrder.DESCENDING);
	}
}
