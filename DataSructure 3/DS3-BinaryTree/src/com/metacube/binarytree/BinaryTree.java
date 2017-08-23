package com.metacube.binarytree;

import com.metacube.entity.BTNode;

/**
 * The Class BinaryTree Responsible for all operation on Binary tree
 *
 * @param <E>
 *            the element type
 */
public class BinaryTree<E> {
	private BTNode<E> root;
	private String inOrder;
	private String postOrder;
	private String preOrder;

	/**
	 * Checks if Binary Tree is empty.
	 *
	 * @return true, if Binary Tree is empty
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * Insert data into Binary Tree
	 *
	 * @param data
	 *            the data
	 * @return true, if successful
	 */
	public boolean insert(E data) {
		if (data == null) {
			return false;
		}
		this.root = insert(data, this.root);
		return true;

	}

	/**
	 * Insert data into Binary Tree Recursively
	 *
	 * @param data
	 *            the data
	 * @param node
	 *            the node
	 * @return the node
	 */
	public BTNode<E> insert(E data, BTNode<E> node) {
		if (node == null) {
			node = new BTNode<E>(data);
		} else {
			if (node.getRight() == null) {
				node.setRight(insert(data, node.getRight()));
			} else {
				node.setLeft(insert(data, node.getLeft()));
			}
		}
		return node;
	}

	/**
	 * Insert Data to Mirror Tree
	 *
	 * @param data
	 *            the data
	 * @return true, if successful
	 */
	public boolean insertMirror(E data) {
		if (data == null) {
			return false;
		}
		this.root = insertMirror(data, this.root);
		return true;

	}

	/**
	 * Insert Data to Mirror Tree Recursively
	 *
	 * @param data
	 *            the data
	 * @param node
	 *            the node
	 * @return the node
	 */
	public BTNode<E> insertMirror(E data, BTNode<E> node) {
		if (node == null) {
			node = new BTNode<E>(data);
		} else {
			if (node.getLeft() == null) {
				node.setLeft(insertMirror(data, node.getLeft()));
			} else {
				node.setRight(insertMirror(data, node.getRight()));
			}
		}
		return node;
	}

	/**
	 * Pre-order of Binary Tree
	 *
	 * @return the string of Pre-Order
	 */
	public String preOrder() {
		preOrder = "";
		setPreOrder(this.root);
		return preOrder;
	}

	/**
	 * Sets the pre order of Binary Tree to String
	 *
	 * @param node
	 *            the root node
	 */
	private void setPreOrder(BTNode<E> node) {
		if (node != null) {
			preOrder += node.getData() + " ";
			setPreOrder(node.getLeft());
			setPreOrder(node.getRight());
		}
	}

	/**
	 * Post order of Binary Tree
	 *
	 * @return the string of Post order
	 */
	public String postOrder() {
		postOrder = "";
		setPostOrder(this.root);
		return postOrder;
	}

	/**
	 * Sets the post order of Binary tree to String
	 *
	 * @param node
	 *            the root node
	 */
	private void setPostOrder(BTNode<E> node) {
		if (node != null) {
			setPostOrder(node.getLeft());
			setPostOrder(node.getRight());
			postOrder += node.getData() + " ";
		}
	}

	/**
	 * In order of Binary tree.
	 *
	 * @return the string of In-Order
	 */
	public String inOrder() {
		inOrder = "";
		setInOrder(this.root);
		return inOrder;
	}

	/**
	 * Sets the in order of Binary Tree to String
	 *
	 * @param node
	 *            the root node
	 */
	private void setInOrder(BTNode<E> node) {
		if (node != null) {
			setInOrder(node.getLeft());
			inOrder += node.getData() + " ";
			setInOrder(node.getRight());
		}
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
	 * Gets the root.
	 *
	 * @return the root
	 */
	public BTNode<E> getRoot() {
		return this.root;
	}
}
