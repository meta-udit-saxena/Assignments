package com.metacube.restwebservice.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.metacube.restwebservice.facade.EmployeeFacade;
import com.metacube.restwebservice.model.Employee;

/**
 * This class is used to get and post the data from and to the html
 * 
 * @author Udit Saxena
 *
 */
@Path("/employees")
public class EmployeesService {

	EmployeeFacade employeeFacade;

	// constructor initialize the variables
	public EmployeesService() {
		employeeFacade = new EmployeeFacade();
	}

	/**
	 * This is used to get the employees List
	 * 
	 * @return List of employees
	 */
	@GET
	@Path("/getAll/")
	@Produces({ MediaType.APPLICATION_XML })
	public List<Employee> getEmployees() {
		return employeeFacade.getEmployeeAsList();
	}

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_XML) public List<Employee> getEmployeesAsHtml()
	 * { return employeeService.getEmployeeAsList(); }
	 */
	/**
	 * This is used as post method to create the employee
	 * 
	 * @param id
	 * @param name
	 * @param age
	 * @param servletResponse
	 * @throws IOException
	 */
	@POST
	@Path("/create/")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void createEmployee(@FormParam("id") String id,
			@FormParam("employeename") String name,
			@FormParam("employeeage") String age,
			@Context HttpServletResponse servletResponse) throws IOException {
		Employee employee = new Employee(id, name, age);
		employeeFacade.createEmployee(employee);
		servletResponse.sendRedirect("./getAll");
	}

	/**
	 * This method is used to get the employee detail by id
	 * 
	 * @param id
	 *            - employee id
	 * @return
	 */
	@GET
	@Path("getById/{employee}")
	public Employee getEmployee(@PathParam("employee") String id) {
		return employeeFacade.getEmployeeById(id);
	}

	/**
	 * This method is getting the input from from to get employee detail by id
	 * 
	 * @param id
	 * @param servletResponse
	 * @throws IOException
	 */
	@POST
	@Path("getById")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void getEmployeeById(@FormParam("id") String id,
			@Context HttpServletResponse servletResponse) throws IOException {
		servletResponse.sendRedirect("./getById/" + id);
	}

	/**
	 * This method is used to delete the employee by id
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("deleteById/{employee}")
	public List<Employee> deleteEmployee(@PathParam("employee") String id) {
		employeeFacade.deleteEmployeeById(id);
		return employeeFacade.getEmployeeAsList();
	}

	/**
	 * This method is used to get the input from the form
	 * 
	 * @param id
	 * @param servletResponse
	 * @throws IOException
	 */
	@POST
	@Path("deleteById")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void deleteEmployeeById(@FormParam("id") String id,
			@Context HttpServletResponse servletResponse) throws IOException {
		servletResponse.sendRedirect("./deleteById/" + id);
	}

	/**
	 * This method is used to get the employee detail by name
	 * 
	 * @param name
	 * @return
	 */
	@GET
	@Path("getByName/{employee}")
	public Employee getEmployeeByName(@PathParam("employee") String name) {
		return employeeFacade.getEmployeeByName(name);
	}

	/**
	 * This method is getting the name information from from
	 * 
	 * @param name
	 * @param servletResponse
	 * @throws IOException
	 */
	@POST
	@Path("getByName")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void getEmployeeByName(@FormParam("employeename") String name,
			@Context HttpServletResponse servletResponse) throws IOException {
		servletResponse.sendRedirect("./getByName/" + name);
	}
}