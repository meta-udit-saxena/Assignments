package com.metacube.restwebservice.testcase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.restwebservice.facade.EmployeeFacade;
import com.metacube.restwebservice.model.Employee;

public class EMployeeFacadeTestCase {

	EmployeeFacade employeeFacade;

	@Before
	public void setUpObject() {
		employeeFacade = new EmployeeFacade();
	}

	@Test
	public void GivenNewEmployee_WhenCreateEmployee_ThenTrue() {
		boolean actual = employeeFacade.createEmployee(new Employee("1",
				"Neel", "12"));
		boolean expected = true;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenNewEmployee_WhenDeleteEmployeeById_ThenEmployeeDeleted() {
		employeeFacade.deleteEmployeeById("1");
		boolean actual = employeeFacade.getEmployees().containsKey("1");
		boolean expected = false;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenNewEmployee_WhenGetEmployeeByIdThenEmploye() {
		Employee employee = new Employee("2", "Udit", "12");
		employeeFacade.createEmployee(employee);
		Employee actual = employeeFacade.getEmployeeById("2");
		Employee expected = employee;
		assertEquals(expected, actual);
	}

	@Test
	public void GivenNewEmployee_WhenGetEmployeeByNameThenEmploye() {
		Employee employee = new Employee("10", "Mahesh", "22");
		employeeFacade.createEmployee(employee);
		Employee actual = employeeFacade.getEmployeeByName("Mahesh");
		Employee expected = employee;
		assertEquals(expected, actual);
	}
}
