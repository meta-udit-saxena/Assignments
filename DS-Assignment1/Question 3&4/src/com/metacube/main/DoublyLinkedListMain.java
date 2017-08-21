package com.metacube.main;

import com.metacube.doublylinkedlist.MyDoublyLinkedList;
import com.metacube.linkedlistinterface.MyLinkedList;

public class DoublyLinkedListMain {
	public static void main(String[] args) {
		MyLinkedList<String> list = new MyDoublyLinkedList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		list.addFirst("f");
		list.addLast("g");
		list.add(2, "h");
		list.sort();
		list.reverse();
		System.out.println(list);
	}
}
