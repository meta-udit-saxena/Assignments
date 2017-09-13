package com.metacube.restwebservice.facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.metacube.restwebservice.dao.EmployeeDao;
import com.metacube.restwebservice.model.Employee;
import com.metacube.restwebservice.util.Constant;

/**
 * This class is used to perform the create update retrieve and delete operation
 * on employee list
 * 
 * @author Udit Saxena
 *
 */
public class EmployeeFacade {

	EmployeeDao employeeDao;

	/**
	 * Initializing the instance
	 */
	public EmployeeFacade() {
		employeeDao = EmployeeDao.getInstance();
	}

	/**
	 * Method to add new employee detail
	 * 
	 * @param employee
	 * @return
	 */
	public boolean createEmployee(Employee employee) {
		employeeDao.getEmployees().put(employee.getId(), employee);
		writeToJsonFile();
		return true;
	}

	/**
	 * Method to get the employee detail by id
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmployeeById(String id) {
		return employeeDao.getEmployees().get(id);
	}

	/**
	 * Method to get all the employees
	 * 
	 * @return
	 */
	public Map<String, Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	/**
	 * Method to get the list of employees
	 * 
	 * @return
	 */
	public List<Employee> getEmployeeAsList() {
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(employeeDao.getEmployees().values());
		return employeeList;
	}

	/**
	 * Method to delete the employee by id
	 * 
	 * @param id
	 */
	public void deleteEmployeeById(String id) {
		employeeDao.getEmployees().remove(id);
		writeToJsonFile();
	}

	/**
	 * Method to get the employee detail by name
	 * 
	 * @param name
	 * @return
	 */
	public Employee getEmployeeByName(String name) {
		Employee employee = null;
		// lopp continues till map end
		for (Map.Entry<String, Employee> employeeMap : employeeDao
				.getEmployees().entrySet()) {
			// if employee map contains this name then return the name age and
			// id
			if (employeeMap.getValue().getName().matches(name)) {
				employee = employeeMap.getValue();
			}
		}
		return employee;
	}

	/**
	 * method to write to JSON file
	 */
	public void writeToJsonFile() {
		try {
			employeeDao.writeTofile(Constant.FILE_PATH);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
