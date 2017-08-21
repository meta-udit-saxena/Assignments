package com.metacube.doublylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.swing.SortOrder;

import com.metacube.linkedlistinterface.MyLinkedList;

@SuppressWarnings("rawtypes")
public class MyDoublyLinkedList<E extends Comparable<E>> implements MyLinkedList<E> {

	private Node head;
	private int size = 0;

	@Override
	public boolean addFirst(E element) {
		Node node = new Node(element);
		if (this.head == null) {
			this.head = node;
		} else {
			this.head.setPreviousNode(node);
			node.setNextNode(this.head);
			this.head = node;
		}
		size++;
		return true;

	}

	@Override
	public boolean add(E element) {
		Node start = this.head;
		if (start == null) {
			addFirst(element);
		} else {
			while (start.getNextNode() != null) {
				start = start.getNextNode();
			}
			Node node = new Node(element);
			node.setPreviousNode(start);
			start.setNextNode(node);
			this.size++;
			return true;
		}
	}

	@Override
	public void add(int index, E element) throws IndexOutOfBoundsException {
		if (index > size() || index < 1) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 1) {
			addFirst(element);
		} else if (index == size()) {
			addLast(element);
		} else {
			Node start = this.head;
			Node node = new Node(element);
			int position = 1;
			while (start != null) {
				if (index == position) {
					break;
				}
				position++;
				start = start.getNextNode();
			}
			node.setNextNode(start);
			node.setPreviousNode(start.getPreviousNode());
			start.getPreviousNode().setNextNode(node);
			start.setPreviousNode(node);
			this.size++;
		}

	}

	@Override
	public void addLast(E element) {
		add(element);
	}

	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	@Override
	public boolean contains(E element) {
		boolean isContain = false;
		if (head != null) {
			Node start = this.head;
			while (start != null) {
				if (start.getElement().equals(element)) {
					isContain = true;
					break;
				}
				start = start.getNextNode();
			}
		}
		return isContain;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > size() || index < 1) {
			throw new IndexOutOfBoundsException();
		}
		Node start = this.head;
		int position = 1;
		while (start != null) {
			if (position == index) {
				break;
			}
			position++;
			start = start.getNextNode();
		}
		return (E) start.getElement();
	}

	@Override
	public E getFirst() throws NoSuchElementException {
		if (this.head == null) {
			throw new NoSuchElementException();
		}
		return (E) this.head.getElement();
	}

	@Override
	public E getLast() throws NoSuchElementException {
		if (this.head == null) {
			throw new NoSuchElementException();
		}
		Node start = this.head;
		while (start.getNextNode() != null) {
			start = start.getNextNode();
		}
		return (E) start.getElement();
	}

	@Override
	public int indexOf(E element) {
		if (contains(element)) {
			int index = 1;
			Node start = this.head;
			while (start != null) {
				if (start.getElement().equals(element)) {
					break;
				}
				index++;
				start = start.getNextNode();
			}
			return index;
		}
		return -1;
	}

	@Override
	public E remove(int position) throws NoSuchElementException {
		if (position > size() || position < 1 || this.head == null) {
			throw new NoSuchElementException();
		}
		E element = get(position);
		remove(element);
		return element;
	}

	@Override
	public void remove(E element) throws NoSuchElementException {
		if (head == null || element == null || contains(element) == false) {
			throw new NoSuchElementException();
		}
		Node start = this.head;
		if (start.getElement().equals(element)) {
			removeFirst();
		} else if (getLast().equals(element)) {
			removeLast();
		} else {
			while (start != null) {
				if (start.getElement().equals(element)) {
					break;
				}
				start = start.getNextNode();
			}
			start.getPreviousNode().setNextNode(start.getNextNode());
			start.getNextNode().setPreviousNode(start.getPreviousNode());
			start.setNextNode(null);
			start.setPreviousNode(null);
		}

	}

	@Override
	public E removeFirst() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		}
		this.head = this.head.getNextNode();
		this.head.setPreviousNode(null);
		return (E) this.head.getElement();
	}

	@Override
	public E removeLast() throws NoSuchElementException {
		if (head == null) {
			throw new NoSuchElementException();
		}
		Node start = this.head;
		while (start.getNextNode() != null) {
			start = start.getNextNode();
		}
		start.getPreviousNode().setNextNode(null);
		start.setPreviousNode(null);
		return null;
	}

	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException {
		if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node start = this.head;
		int position = 1;
		while (start != null) {
			if (index == position) {
				break;
			}
			start = start.getNextNode();
			position++;
		}
		start.setElement(element);
		return (E) start.getElement();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void reverse() throws NullPointerException {
		if (this.head == null) {
			throw new NullPointerException();
		}
		Node currentNode = this.head;
		Node nextNode = null;
		while (currentNode.getNextNode() != null) {
			nextNode = currentNode.getNextNode();
			currentNode.setNextNode(currentNode.getPreviousNode());
			currentNode.setPreviousNode(nextNode);
			currentNode = nextNode;
		}
		currentNode.setNextNode(currentNode.getPreviousNode());
		currentNode.setPreviousNode(null);
		this.head = currentNode;
	}

	private void swap(Node firstNode, Node secondNode) {
		E temp = (E) firstNode.getElement();
		firstNode.setElement(secondNode.getElement());
		secondNode.setElement(temp);
	}

	@Override
	public void sort() throws NullPointerException {
		sort(SortOrder.ASCENDING);
	}

	@Override
	public void sort(SortOrder sortOrder) {
		if (this.head == null) {
			throw new NullPointerException();
		}
		Node firstLoop = this.head;
		Node secondLoop;
		while (firstLoop != null) {
			secondLoop = firstLoop.getNextNode();
			while (secondLoop != null) {
				if (sortOrder.equals(SortOrder.ASCENDING)) {
					if (firstLoop.getElement().compareTo(secondLoop.getElement()) > 0) {
						swap(firstLoop, secondLoop);
					}
				} else {
					if (firstLoop.getElement().compareTo(secondLoop.getElement()) < 0) {
						swap(firstLoop, secondLoop);
					}
				}
				secondLoop = secondLoop.getNextNode();
			}
			firstLoop = firstLoop.getNextNode();
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node start = head;

			@Override
			public boolean hasNext() {
				return start != null;
			}

			@Override
			public E next() {
				E element = (E) start.getElement();
				start = start.getNextNode();
				return element;
			}
		};
	}

	@Override
	public String toString() {
		String display = "[";
		Node start = this.head;
		while (start != null) {
			display += start.getElement() + " <--> ";
			start = start.getNextNode();
		}
		display += "null]";

		return display;
	}
}
