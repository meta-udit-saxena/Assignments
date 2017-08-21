package com.metacube.main;

import java.util.Iterator;

import com.metacube.linkedlistinterface.MyLinkedList;
import com.metacube.singlylinkedlist.MySinglyLinkedList;

public class SinglyLinkedListMain {

	public static void main(String[] args) {
		MyLinkedList<String> list = new MySinglyLinkedList<String>();
		list.add("Udit");
		list.add("Mahesh");
		list.add("Sumit");
		list.add("Sumit Saxena");
		list.add("Neel");
		list.addFirst("Chirag");
		list.addLast("Shubham");
		list.add(2,"Goyal");
		System.out.println(list.indexOf("Chirag"));
		list.set(1, "Rajat");
		list.set(2, "Jain");
		list.remove("Jain");
		System.out.println(list);
		list.reverse();
		list.sort();
	}

}
