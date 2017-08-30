package com.metacube.entity;

import java.util.Comparator;

/**
 * Employee class.
 *
 * @author Udit Saxena
 */
public class Employee implements Comparable<Employee> {
	private int empId;
	private String name;
	private String address;

	/**
	 * Instantiates a new employee.
	 *
	 * @param empId
	 *            the employee id
	 * @param name
	 *            the name
	 * @param address
	 *            the address
	 */
	public Employee(int empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	/**
	 * Gets the employee id.
	 *
	 * @return the employee id
	 */
	public int getEmpId() {
		return empId;
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
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/** Name comparator object to sort employees in order of employee name. */
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
		@Override
		public int compare(Employee emp1, Employee emp2) {
			return emp1.getName().compareTo(emp2.getName());
		}
	};

	/**
	 * Override compareTo to sort employees in order of employee id.
	 *
	 * @param obj
	 *            the employee object
	 * @return 0 if equals , 1 if greater and -1 if smaller than obj
	 */
	@Override
	public int compareTo(Employee obj) {
		return this.empId - obj.getEmpId();
	}

	/**
	 * return string containing employee details.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.getEmpId() + "  " + this.getName() + "\t"
				+ this.getAddress() + " \n";
	}

	/**
	 * return hash code for employee id.
	 *
	 * @return the hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		return result;
	}

	/**
	 * If object have same id then return true else false.
	 *
	 * @param obj
	 *            the object
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		Employee other = (Employee) obj;
		if (obj == null || this.getClass() != obj.getClass()
				|| empId != other.empId) {
			return false;
		}

		return true;
	}
}