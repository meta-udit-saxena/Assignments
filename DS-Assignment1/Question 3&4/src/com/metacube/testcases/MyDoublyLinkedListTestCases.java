package com.metacube.testcases;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.SortOrder;

import org.junit.Before;
import org.junit.Test;

import com.metacube.doublylinkedlist.MyDoublyLinkedList;
import com.metacube.linkedlistinterface.MyLinkedList;

public class MyDoublyLinkedListTestCases<E extends Comparable<E>> {

	MyLinkedList<Integer> doublyLinkedList;

	@Before
	public void setUpObject() {
		doublyLinkedList = new MyDoublyLinkedList<Integer>();
		doublyLinkedList.add(10);
		doublyLinkedList.add(20);
	}

	@Test
	public void GivenElementIsValid_WhenAdd_ThenTrue() {
		boolean actual = doublyLinkedList.add(1);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenAdd_ThenFalse() {
		boolean actual = doublyLinkedList.add(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsValid_WhenaddFirst_ThenTrue() {
		boolean actual = doublyLinkedList.addFirst(1);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenaddFirst_ThenFalse() {
		boolean actual = doublyLinkedList.addFirst(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenPositionIsValid_WhenAdd_ThenTrue() {
		boolean actual = doublyLinkedList.add(1, 10);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenPositionIsValidButElementIsNull_WhenAdd_ThenFalse() {
		boolean actual = doublyLinkedList.add(1, null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void GivenPosititonIsInValid_WhenAdd_ThenIndexOutOfBoundException() {
		doublyLinkedList.add(-1, 10);
	}

	@Test
	public void GivenElementIsValid_WhenAddLast_ThenTrue() {
		boolean actual = doublyLinkedList.addLast(2);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenAddLast_ThenFalse() {
		boolean actual = doublyLinkedList.addLast(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenLinkedListHaveTwoElement_WhenSize_Then2() {
		int actual = doublyLinkedList.size();
		int expected = 2;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenLinkedListIsEmpty_WhenSize_Then0() {
		doublyLinkedList.clear();
		int actual = doublyLinkedList.size();
		int expected = 0;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsValid_WhenContains_ThenTrue() {
		boolean actual = doublyLinkedList.contains(10);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsInValid_WhenContains_ThenFalse() {
		boolean actual = doublyLinkedList.contains(30);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenContains_ThenFalse() {
		boolean actual = doublyLinkedList.contains(null);
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenIndexIsValid_WhenGet_ThenElement() {
		Object actual = doublyLinkedList.get(1);
		Object expected = 10;
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void GivenIndexIsInValid_WhenGet_ThenIndexOutOfBoundException() {
		doublyLinkedList.get(10);
	}

	@Test
	public void GivenLinkedListIsNotEmpty_WhenGetFirst_ThenElement() {
		Object actual = doublyLinkedList.getFirst();
		Object expected = 10;
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenLinkedListIsEmpty_WhenGetFirst_ThenNoSuchElementException() {
		doublyLinkedList.clear();
		doublyLinkedList.getFirst();
	}

	@Test
	public void GivenLinkedListIsNotEmpty_WhenGetLast_ThenElement() {
		Object actual = doublyLinkedList.getLast();
		Object expected = 20;
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenLinkedListIsEmpty_WhenGetLast_ThenNoSuchElementException() {
		doublyLinkedList.clear();
		doublyLinkedList.getLast();
	}

	@Test
	public void GivenElementIsValid_WhenIndexOF_ThenIndex() {
		int actual = doublyLinkedList.indexOf(10);
		int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsInvalid_WhenIndexOF_ThenIndex() {
		int actual = doublyLinkedList.indexOf(null);
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsNull_WhenIndexOF_ThenIndex() {
		int actual = doublyLinkedList.indexOf(null);
		int expected = -1;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenPositionIsValid_WhenRemoveByPosition_ThenElement() {
		int actual = doublyLinkedList.removeByPosition(1);
		int expected = 10;
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenPositionIsInValid_WhenRemoveByPosition_ThenNoSuchElementException() {
		doublyLinkedList.removeByPosition(3);
	}

	@Test
	public void GivenElementIsValid_WhenRemove_ThenTrue() {
		boolean actual = doublyLinkedList.remove(10);
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenElementIsInValid_WhenRemove_ThenNoSuchElementException() {
		doublyLinkedList.remove(30);
	}

	@Test(expected = NoSuchElementException.class)
	public void GivenElementIsNull_WhenRemove_ThenNoSuchElementException() {
		doublyLinkedList.remove(null);
	}

	@Test
	public void GivenIndexIsValid_WhenSet_ThenElement() {
		Object actual = doublyLinkedList.set(1, 100);
		Object expected = 100;
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void GivenIndexIsInValid_WhenSet_ThenIndexOutOfBoundsException() {
		doublyLinkedList.set(10, 100);
	}

	@Test(expected = NullPointerException.class)
	public void GivenLinkedListIsEmpty_WhenReverse_ThenNullPointerException() {
		doublyLinkedList.clear();
		doublyLinkedList.reverse();
	}

	@Test
	public void GivenLinkedListIsNotEmpty_WhenReverse_ThenReverseLinkedList() {
		doublyLinkedList.add(30);
		doublyLinkedList.add(40);
		doublyLinkedList.reverse();
		int[] actual = new int[4];
		int index =0;
		Iterator<Integer> iterator = doublyLinkedList.iterator();
		while(iterator.hasNext()) {
			actual[index++]=iterator.next();
		}
		int[] expected = {40,30,20,10};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void GivenLinkedList_WhenSort_ThenSortedLinkedList() {
		doublyLinkedList.add(2);
		doublyLinkedList.add(4);
		doublyLinkedList.sort();
		int[] actual = new int[4];
		int index =0;
		Iterator<Integer> iterator = doublyLinkedList.iterator();
		while(iterator.hasNext()) {
			actual[index++]=iterator.next();
		}
		int[] expected = {2,4,10,20};
		assertArrayEquals(expected, actual);
	}
	@Test
	public void GivenLinkedList_WhenSortInDescending_ThenDescendingOrderSortedLinkedList() {
		doublyLinkedList.add(2);
		doublyLinkedList.add(4);
		doublyLinkedList.sort(SortOrder.DESCENDING);
		int[] actual = new int[4];
		int index =0;
		Iterator<Integer> iterator = doublyLinkedList.iterator();
		while(iterator.hasNext()) {
			actual[index++]=iterator.next();
		}
		int[] expected = {20,10,4,2};
		assertArrayEquals(expected, actual);
	}
	@Test(expected=NullPointerException.class)
	public void GivenLinkedListIsEmpty_WhenSort_ThenNullPointerException() {
		doublyLinkedList.clear();
		doublyLinkedList.sort(SortOrder.DESCENDING);
	}
}
