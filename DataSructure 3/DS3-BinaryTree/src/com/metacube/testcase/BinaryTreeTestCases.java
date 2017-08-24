package com.metacube.testcase;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.metacube.binarytree.BinaryTree;

@RunWith(Parameterized.class)
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
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] { { 33, true }, { 132, true },
				{ null, false } });
	}

	@Parameter(0)
	public Integer insertedInput;

	@Parameter(1)
	public boolean expectedOutput;

	@Test
	public void GivenElementInserted_WhenInsert_ThenCorrectOutput() {
		System.out.println(insertedInput);
		boolean actual = binaryTree.insert(insertedInput);
		assertEquals(expectedOutput, actual);
	}

	@Test
	public void GivenElementIsPresent_WhenPreOrder_ThenPreOrderString() {
		String actual = binaryTree.preOrder();
		String expected = "10 20 40 50 30 60 70 ";
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
		String expected = "40 50 20 60 70 30 10 ";
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
		String expected = "40 20 50 10 60 30 70 ";
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
		secondBinaryTree.insert(10);
		secondBinaryTree.insert(30);
		secondBinaryTree.insert(20);
		secondBinaryTree.insert(70);
		secondBinaryTree.insert(60);
		secondBinaryTree.insert(50);
		secondBinaryTree.insert(40);
		boolean actual = binaryTree.isMirrorImage(binaryTree, secondBinaryTree);
		assertEquals(true, actual);
	}

	@Test
	public void GivenBinaryTreeIsNotMirrorImage_WhenIsMirrorImage_ThenFalse() {
		BinaryTree<Integer> secondBinaryTree = new BinaryTree<Integer>();
		secondBinaryTree.insert(10);
		secondBinaryTree.insert(50);
		secondBinaryTree.insert(60);
		secondBinaryTree.insert(80);
		secondBinaryTree.insert(20);
		secondBinaryTree.insert(30);
		secondBinaryTree.insert(90);
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
