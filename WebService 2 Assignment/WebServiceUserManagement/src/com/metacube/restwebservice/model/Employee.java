package com.metacube.restwebservice.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class which contain properties of an employee
 * 
 * @author Udit Saxena
 *
 */
@XmlRootElement
public class Employee {
	private String id;
	private String name;
	private String age;

	public Employee() {

	}

	/**
	 * constructor to set the values of its properties
	 * 
	 * @param id
	 * @param name
	 * @param age
	 */
	public Employee(String id, String name, String age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	// getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}