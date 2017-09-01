package com.metacube.testcase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.metacube.binarytree.BinarySearchTree;
import com.metacube.entity.Student;

public class BinarySearchTreeTestCases {
	BinarySearchTree<Student> tree;
	Student s1, s2, s3, s4, s5;

	@Before
	public void setUpObject() {
		tree = new BinarySearchTree<Student>();
		s1 = new Student(1, "Udit");
		s2 = new Student(2, "Mahesh");
		s3 = new Student(3, "Rajat");
		s4 = new Student(4, "Prateek");
		s5 = new Student(6, "Neel");
	}

	@Test
	public void GivenUnsortedArrayWhenSortThenSortedArray() {
		Student[] student = { s1, s5, s3, s4, s2 };
		tree.insert(student);
		Student[] expectedArray = { s1, s2, s3, s4, s5 };
		assertArrayEquals(tree.sort().toArray(), expectedArray);
	}

	@Test
	public void GivenEmptyArrayWhenSortThenNull() {
		Student[] student = null;
		tree.insert(student);
		assertEquals(null, tree.sort());
	}
}