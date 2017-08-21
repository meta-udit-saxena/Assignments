package com.metacube.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.linkedlistinterface.MyLinkedList;
import com.metacube.singlylinkedlist.MySinglyLinkedList;

public class MySinglyLinkedListTestCases<E extends Comparable<E>> {

	MyLinkedList<Integer> mySinglyLinkedList;
	
	@Before
	public void setUpObject() {
		mySinglyLinkedList = new MySinglyLinkedList<Integer>();
	}
	
	@Test
	public void GivenElementIsValid_WhenAdd_ThenTrue() {
			boolean actual = mySinglyLinkedList.add(1);
			boolean expected = true;
			assertEquals(expected, actual);
	}
	@Test
	public void GivenElementIsNull_WhenAdd_ThenFalse() {
			boolean actual = mySinglyLinkedList.add(null);
			boolean expected = false;
			assertEquals(expected, actual);
	}

}
