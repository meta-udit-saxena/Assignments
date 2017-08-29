package com.metacube.testcases;

import static org.junit.Assert.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.metacube.entity.Employee;

public class NaturalSortingTestCases {
	List<Employee> employeeList;
	Employee e1, e2, e3, e4, e5;

	@Before
	public void setUpList() {
		employeeList = new LinkedList<Employee>();
		e1 = new Employee(1, "Udit", "sector 18");
		e2 = new Employee(3, "Mahesh", "sector 19");
		e3 = new Employee(2, "Neel", "sector 8");
		e4 = new Employee(5, "Prateek", "sector 13");
		e5 = new Employee(4, "Chetan", "sector 12");
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
	}

	@Test
	public void GivenEmployeePresentWithUniqueId_WhenSort_ThenSortBasedOnId() {
		Collections.sort(employeeList);
		Object[] empArray = employeeList.toArray();
		Object[] actualArray = { e1, e3, e2, e5, e4 };
		assertArrayEquals(actualArray, empArray);
	}

	@Test
	public void GivenEmployeeAddedWithSimilarId_WhenSort_ThenSortBasedOnId() {
		Employee e6 = new Employee(4, "Udit Saxena", "sector 3");
		employeeList.add(e6);
		Collections.sort(employeeList);
		Collections.sort(employeeList);
		Object[] empArray = employeeList.toArray();
		Object[] actualArray = { e1, e3, e2, e5, e6, e4 };
		assertArrayEquals(actualArray, empArray);
	}
}
