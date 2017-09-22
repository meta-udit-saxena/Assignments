package com.metacube.testcases;

import static org.junit.Assert.assertArrayEquals;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import com.metacube.entity.Employee;

public class UniqueEmployeeTestCases {
	Set<Employee> employeeList;
	Employee e1, e2, e3, e4, e5;

	@Before
	public void setUpList() {
		employeeList = new HashSet<Employee>();
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
	public void GivenEmployeeAddedtWithUniqueId_WhenSort_ThenAddedToSet() {
		Employee e6 = new Employee(6, "Udit Saxena", "sector 3");
		employeeList.add(e6);
		Object[] actualArray = employeeList.toArray();
		Object[] expectedArray = { e1, e3, e2, e5, e4, e6 };
		assertArrayEquals(expectedArray, actualArray);
	}

	@Test
	public void GivenEmployeeAddedWithSimilarId_WhenSort_ThenDiscarded() {
		Employee e6 = new Employee(5, "Udit Saxena", "sector 3");
		employeeList.add(e6);
		Object[] actualArray = employeeList.toArray();
		Object[] expectedArray = { e1, e3, e2, e5, e4 };
		assertArrayEquals(expectedArray, actualArray);
	}
}