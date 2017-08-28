package com.metacube.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.metacube.utility.MyHeap;

public class MyHeapTestCases {

	MyHeap<Integer> heap;

	@Before
	public void setUpObject() {
		heap = new MyHeap<Integer>();
	}

	@Test
	public void GivenListWhenBuildHeapThenHeap() {
		Integer[] array = { 40, 30, 20, 10, 50, 60, 70 };
		List<Integer> list = heap.buildHeap(Arrays.asList(array));
		Object[] actuals = list.toArray();
		Object[] expecteds = { 70, 50, 60, 10, 30, 40, 20 };
		assertArrayEquals(expecteds, actuals);
	}

	@Test
	public void GivenListIsEmptyWhenBuildHeapThenNull() {
		List<Integer> list = new ArrayList<Integer>();
		assertEquals(null, heap.buildHeap(list));
	}

	@Test
	public void GivenNullWhenBuildHeapThenNull() {
		assertEquals(null, heap.buildHeap(null));
	}

	@Test
	public void GivenListWhenGetRootThenMaximumValue() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(70);
		list.add(0);
		list.add(50);
		heap.buildHeap(list);
		int actual = heap.getRoot(list);
		assertEquals(70, actual);
	}

	@Test
	public void GivenListIsEmptyWhenGetRootThenNull() {
		List<Integer> list = new ArrayList<Integer>();
		heap.buildHeap(list);
		assertEquals(null, heap.getRoot(list));
	}

	@Test
	public void GivenNullWhenGetRootThenNull() {
		assertEquals(null, heap.getRoot(null));
	}
}
