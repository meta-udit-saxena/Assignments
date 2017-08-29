package com.metacube.naturalsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.metacube.entity.Employee;

/**
 * The Class Sorting.
 */
public class Sorting {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Udit", "sector 18"));
		empList.add(new Employee(3, "Mahesh", "sector 19"));
		empList.add(new Employee(2, "Neel", "sector 8"));
		empList.add(new Employee(5, "Prateek", "sector 13"));
		empList.add(new Employee(4, "Chetan", "sector 12"));
		System.out.println(empList);
		Collections.sort(empList);
		System.out.println(empList);
	}
}
