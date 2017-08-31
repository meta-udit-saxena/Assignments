package com.metacube.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class BinarySearchTree.
 *
 * @param <T>
 *            the generic type
 */
public class BinarySearchTree<T extends Comparable<T>> {
	private BSTNode<T> root;
	private int size;

	/**
	 * Insert single element to tree.
	 *
	 * @param element
	 *            the element
	 */
	public void insert(T element) {
		this.root = insert(this.root, element);
	}

	/**
	 * Insert element array to tree.
	 *
	 * @param array
	 *            the array
	 */
	public void insert(T[] array) {
		for (T element : array)
			this.root = insert(this.root, element);
	}

	/**
	 * Insert.
	 *
	 * @param root
	 *            the root
	 * @param element
	 *            the element
	 * @return the BST node
	 */
	private BSTNode<T> insert(BSTNode<T> root, T element) {
		if (root == null) {
			root = new BSTNode<T>(element);
			this.size++;
		} else {
			if (root.getData().compareTo(element) > 0) {
				root.setLeft(insert(root.getLeft(), element));
			} else {
				root.setRight(insert(root.getRight(), element));
			}
		}
		return root;
	}

	/**
	 * Sort the tree.
	 *
	 * @return the sorted list
	 */
	public List<T> sort() {
		List<T> array = new ArrayList<T>();
		return inorder(root, array, 0);

	}

	/**
	 * Inorder traversing and add data to list.
	 *
	 * @param root
	 *            the root
	 * @param array
	 *            the list
	 * @param index
	 *            the index
	 * @return the sorted list
	 */
	private List<T> inorder(BSTNode<T> root, List<T> array, int index) {
		if (root == null) {
			return null;
		}
		inorder(root.getLeft(), array, index);
		array.add(root.getData());
		inorder(root.getRight(), array, index);
		return array;
	}
}