package com.metacube.entity;

/**
 * The Class Student.
 */
public class Student implements Comparable<Student> {
	private int rollNo;
	private String name;

	/**
	 * Instantiates a new student.
	 *
	 * @param rollNo
	 *            the roll no
	 * @param name
	 *            the name
	 */
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	/**
	 * Gets the roll no.
	 *
	 * @return the roll no
	 */
	public int getRollNo() {
		return rollNo;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Display Student Data
	 */
	@Override
	public String toString() {
		return "Roll No :" + this.getRollNo() + "\tName : " + this.name + "\n";
	}

	/**
	 * Compare Student by Their Roll Number
	 */
	@Override
	public int compareTo(Student obj) {
		return this.getRollNo() - obj.getRollNo();
	}
}