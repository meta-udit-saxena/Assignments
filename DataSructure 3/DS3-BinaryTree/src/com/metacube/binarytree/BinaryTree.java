package com.metacube.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.metacube.entity.BTNode;

/**
 * The Class BinaryTree Responsible for all operation on Binary tree
 *
 * @param <E>
 *            the element type
 */
public class BinaryTree<E> {
	private BTNode<E> root;
	private Queue<BTNode<E>> parentNodes;

	/**
	 * Checks if Binary Tree is empty.
	 *
	 * @return true, if Binary Tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	public BinaryTree() {
		parentNodes = new LinkedList<BTNode<E>>();
	}

	/**
	 * Insert data into Binary Tree
	 *
	 * @param data
	 *            the data
	 * @return true, if successful
	 */
	public boolean insert(E data) {
		if (data != null) {
			BTNode<E> newNode = new BTNode<E>(data);
			if (this.root == null) {
				this.root = newNode;
				parentNodes.add(this.root);
			} else {
				BTNode<E> currentNode = parentNodes.peek();
				if (currentNode.getLeft() == null) {
					currentNode.setLeft(newNode);
					parentNodes.add(currentNode.getLeft());
				} else {
					currentNode.setRight(newNode);
					parentNodes.add(currentNode.getRight());
					parentNodes.poll();
				}
			}

			return true;
		}

		return false;
	}

	/**
	 * Pre-order of Binary Tree
	 *
	 * @return the string of Pre-Order
	 */
	public String preOrder() {
		return setPreOrder(this.root);
	}

	/**
	 * Sets the pre order of Binary Tree to String
	 *
	 * @param node
	 *            the root node
	 */
	private String setPreOrder(BTNode<E> node) {
		String preOrder = "";
		if (node != null) {
			preOrder += node.getData() + " ";
			preOrder += setPreOrder(node.getLeft());
			preOrder += setPreOrder(node.getRight());
		}

		return preOrder;
	}

	/**
	 * Post order of Binary Tree
	 *
	 * @return the string of Post order
	 */
	public String postOrder() {
		return setPostOrder(this.root);
	}

	/**
	 * Sets the post order of Binary tree to String
	 *
	 * @param node
	 *            the root node
	 */
	private String setPostOrder(BTNode<E> node) {
		String postOrder = "";
		if (node != null) {
			postOrder += setPostOrder(node.getLeft());
			postOrder += setPostOrder(node.getRight());
			postOrder += node.getData() + " ";
		}

		return postOrder;
	}

	/**
	 * In order of Binary tree.
	 *
	 * @return the string of In-Order
	 */
	public String inOrder() {

		return setInOrder(this.root);
	}

	/**
	 * Sets the in order of Binary Tree to String
	 *
	 * @param node
	 *            the root node
	 */
	private String setInOrder(BTNode<E> node) {
		String inOrder = "";
		if (node != null) {
			inOrder += setInOrder(node.getLeft());
			inOrder += node.getData() + " ";
			inOrder += setInOrder(node.getRight());
		}

		return inOrder;
	}

	/**
	 * Checks if Both tree are mirror image.
	 *
	 * @param firstBinaryTree
	 *            the first binary tree
	 * @param secondBinaryTree
	 *            the second binary tree
	 * @return true, if is mirror image
	 */
	public boolean isMirrorImage(BinaryTree<E> firstBinaryTree,
			BinaryTree<E> secondBinaryTree) {

		return isMirrorImage(firstBinaryTree.root, secondBinaryTree.root);
	}

	/**
	 * Checks if is mirror image.
	 *
	 * @param firstTreeRoot
	 *            the new root
	 * @param secondTreeRoot
	 *            the old root
	 * @return true, if is mirror image
	 */
	private boolean isMirrorImage(BTNode<E> firstTreeRoot,
			BTNode<E> secondTreeRoot) {
		if (firstTreeRoot == null && secondTreeRoot == null) {
			return true;
		}

		if (firstTreeRoot == null || secondTreeRoot == null) {
			return false;
		}

		return secondTreeRoot.getData().toString()
				.equals(firstTreeRoot.getData().toString())
				&& isMirrorImage(firstTreeRoot.getLeft(),
						secondTreeRoot.getRight())
				&& isMirrorImage(firstTreeRoot.getRight(),
						secondTreeRoot.getLeft());
	}

	/**
	 * Gets the root node.
	 *
	 * @return the root
	 */
	public BTNode<E> getRoot() {
		return this.root;
	}
}