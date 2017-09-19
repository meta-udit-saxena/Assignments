package com.metacube.testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.metacube.stackimplementation.MyStack;

public class MyStackTestCases {

	MyStack<Integer> stack;

	@Before
	public void setUpObject() {
		stack = new MyStack<Integer>();
	}

	@Test
	public void GivenElementIsValid_WhenPush_ThenTrue() {
		assertEquals(true, stack.push(10));
	}

	@Test
	public void GivenElementIsNull_WhenPush_ThenFalse() {
		assertEquals(false, stack.push(null));
	}

	@Test
	public void Given20IsAtTopOfStack_WhenPop_Then20() {
		stack.push(10);
		stack.push(20);
		int actual = stack.pop();
		assertEquals(20, actual);
	}

	@Test
	public void GivenStackIsEmpty_WhenPush_ThenNull() {
		assertEquals(null, stack.pop());
	}

	@Test
	public void GivenStackSizeIs2_WhenGetSize_Then2() {
		stack.push(10);
		stack.push(20);
		assertEquals(2, stack.getSize());
	}

	@Test
	public void Given20IsAtTopOfStack_WhenPeek_Then20() {
		stack.push(10);
		stack.push(20);
		int actual = stack.peek();
		assertEquals(20, actual);
	}

	@Test
	public void GivenStackIsEmpty_WhenPeek_ThenNull() {
		assertEquals(null, stack.peek());
	}
}
