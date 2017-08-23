package com.metacube.testcase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.metacube.binarytree.BinaryTree;

public class BinaryTreeTestCases {
	BinaryTree<Integer> binaryTree;

	@Before
	public void setUpObject() {
		binaryTree = new BinaryTree<Integer>();
		binaryTree.insert(10);
		binaryTree.insert(20);
		binaryTree.insert(30);
		binaryTree.insert(40);
		binaryTree.insert(50);
		binaryTree.insert(60);
		binaryTree.insert(70);
		binaryTree.insert(80);
	}

	@Test
	public void GivenElementIsValid_WhenInsert_ThenTrue() {
		boolean actual = binaryTree.insert(90);
		assertEquals(actual, true);
	}

	@Test
	public void GivenElementIsNull_WhenInsert_ThenFalse() {
		boolean actual = binaryTree.insert(null);
		assertEquals(actual, false);
	}

	@Test
	public void GivenElementIsPresent_WhenPreOrder_ThenPreOrderString() {
		String actual = binaryTree.preOrder();
		String expected = "10 30 50 70 80 60 40 20 ";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenTreeIsEmpty_WhenPreOrder_ThenEmptyString() {
		String actual = new BinaryTree<Integer>().preOrder();
		String expected = "";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsPresent_WhenPostOrder_ThenPostOrderString() {
		String actual = binaryTree.postOrder();
		String expected = "80 70 60 50 40 30 20 10 ";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenTreeIsEmpty_WhenPostOrder_ThenEmptyString() {
		String actual = new BinaryTree<Integer>().postOrder();
		String expected = "";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenElementIsPresent_WhenInOrder_ThenInOrderString() {
		String actual = binaryTree.inOrder();
		String expected = "70 80 50 60 30 40 10 20 ";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenTreeIsEmpty_WhenInOrder_ThenEmptyString() {
		String actual = new BinaryTree<Integer>().inOrder();
		String expected = "";
		assertEquals(expected, actual);
	}

	@Test
	public void GivenBinaryTreeIsMirrorImage_WhenIsMirrorImage_ThenTrue() {
		BinaryTree<Integer> secondBinaryTree = new BinaryTree<Integer>();
		secondBinaryTree.insertMirror(10);
		secondBinaryTree.insertMirror(20);
		secondBinaryTree.insertMirror(30);
		secondBinaryTree.insertMirror(40);
		secondBinaryTree.insertMirror(50);
		secondBinaryTree.insertMirror(60);
		secondBinaryTree.insertMirror(70);
		secondBinaryTree.insertMirror(80);
		boolean actual = binaryTree.isMirrorImage(binaryTree, secondBinaryTree);
		assertEquals(true, actual);
	}

	@Test
	public void GivenBinaryTreeIsNotMirrorImage_WhenIsMirrorImage_ThenFalse() {
		BinaryTree<Integer> secondBinaryTree = new BinaryTree<Integer>();
		secondBinaryTree.insertMirror(10);
		secondBinaryTree.insertMirror(50);
		secondBinaryTree.insertMirror(60);
		secondBinaryTree.insertMirror(80);
		secondBinaryTree.insertMirror(20);
		secondBinaryTree.insertMirror(30);
		secondBinaryTree.insertMirror(90);
		secondBinaryTree.insertMirror(80);
		boolean actual = binaryTree.isMirrorImage(binaryTree, secondBinaryTree);
		assertEquals(false, actual);
	}

	@Test
	public void GivenBothBinaryTreeIsEmpty_WhenIsMirrorImage_ThenTrue() {
		BinaryTree<Integer> secondBinaryTree = new BinaryTree<Integer>();
		BinaryTree<Integer> firstBinaryTree = new BinaryTree<Integer>();
		boolean actual = firstBinaryTree.isMirrorImage(firstBinaryTree,
				secondBinaryTree);
		assertEquals(true, actual);
	}

	@Test
	public void GivenOneBinaryTreeIsEmpty_WhenIsMirrorImage_ThenFalse() {
		BinaryTree<Integer> secondBinaryTree = new BinaryTree<Integer>();
		boolean actual = binaryTree.isMirrorImage(binaryTree, secondBinaryTree);
		assertEquals(false, actual);
	}
}
