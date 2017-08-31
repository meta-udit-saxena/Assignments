package com.metacube.main;

import com.metacube.binarytree.BinarySearchTree;
import com.metacube.entity.Student;

/**
 * The Class Main.
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Student[] studentArray = (Student[]) new Student[] {
				new Student(1, "Udit"), new Student(2, "Mahesh"),
				new Student(6, "Neel"), new Student(5, "Prateek"),
				new Student(3, "Rajat") };
		BinarySearchTree<Student> tree = new BinarySearchTree<Student>();
		tree.insert(studentArray);
		System.out.println(tree.sort());
	}
}