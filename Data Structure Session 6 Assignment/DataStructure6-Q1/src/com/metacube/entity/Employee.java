package com.metacube.entity;

import java.util.Comparator;

/**
 * Employee class
 * 
 * @author Udit Saxena
 *
 */
public class Employee implements Comparable<Employee> {
	private int empId;
	private String name;
	private String address;

	/**
	 * @param empId
	 * @param name
	 * @param address
	 */
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId
	 *            the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the employee name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Comparator object to sort employees list or array in order of Name
	 */
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee obj1, Employee obj2) {
			return obj1.getName().compareTo(obj2.getName());
		}
	};

	/**
	 * Override compareTo to sort employees list or array in order of id
	 */
	@Override
	public int compareTo(Employee obj) {
		return this.empId - obj.getEmpId();
	}

	/**
	 * return string containing employee details
	 */
	@Override
	public String toString() {
		return this.getEmpId() + "  " + this.getName() + "\t"
				+ this.getAddress() + " \n";
	}

	/**
	 * return hash code for employee id
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	/**
	 * If object have same id then return true else false
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (empId != other.empId) {
			return false;
		}

		return true;
	}
}
