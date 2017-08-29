package com.metacube.uniqueemployeecollection;

import java.util.HashSet;
import java.util.Set;
import com.metacube.entity.Employee;

/**
 * The Class UniqueEmployeeCollection.
 */
public class UniqueEmployeeCollection {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Set<Employee> empSet = new HashSet<Employee>();
		empSet.add(new Employee(1, "Udit", "sector 18"));
		empSet.add(new Employee(3, "Mahesh", "sector 19"));
		empSet.add(new Employee(2, "Neel", "sector 8"));
		empSet.add(new Employee(5, "Prateek", "sector 13"));
		empSet.add(new Employee(4, "Chetan", "sector 12"));
		empSet.add(new Employee(1, "Udit1", "sector 18"));
		empSet.add(new Employee(3, "Mahesh1", "sector 19"));
		empSet.add(new Employee(2, "Neel1", "sector 8"));
		empSet.add(new Employee(5, "Prateek", "sector 13"));
		empSet.add(new Employee(4, "Chetan", "sector 12"));
		System.out.println(empSet);
	}
}
