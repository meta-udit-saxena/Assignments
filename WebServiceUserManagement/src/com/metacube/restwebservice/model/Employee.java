package com.metacube.restwebservice.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class which contain properties of an employee.
 *
 * @author Udit Saxena
 */
@XmlRootElement
public class Employee {
	private String id;
	private String name;
	private String age;

	/**
	 * constructor to set the values of its properties.
	 *
	 * @param id
	 *            Employee ID
	 * @param name
	 *            Employee Name
	 * @param age
	 *            Employee age
	 */
	public Employee(String id, String name, String age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	// getters and setters
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
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
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age
	 *            the new age
	 */
	public void setAge(String age) {
		this.age = age;
	}

}