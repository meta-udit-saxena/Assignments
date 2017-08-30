package com.metacube.testcases;

import static org.junit.Assert.assertArrayEquals;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.metacube.entity.Employee;

public class SortingBasedOnNameTestCases {
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
	}

	@Test
	public void GivenEmployeePresentWithUniquename_WhenSort_ThenSortBasedOnName() {
		employeeList.add(e1);
		employeeList.add(e2);
		employeeList.add(e3);
		employeeList.add(e4);
		employeeList.add(e5);
		Collections.sort(employeeList, Employee.nameComparator);
		Object[] actualArray = employeeList.toArray();
		Object[] expectedArray = { e5, e2, e3, e4, e1 };
		assertArrayEquals(expectedArray, actualArray);
	}

	@Test
	public void GivenListIsEmpty_WhenSort_ThenEmpty() {
		Collections.sort(employeeList, Employee.nameComparator);
		Object[] actualArray = employeeList.toArray();
		Object[] expectedArray = {};
		assertArrayEquals(expectedArray, actualArray);
	}

	@Test(expected = NullPointerException.class)
	public void GivenNull_WhenSort_ThenEmpty() {
		Collections.sort(null, Employee.nameComparator);
	}
}