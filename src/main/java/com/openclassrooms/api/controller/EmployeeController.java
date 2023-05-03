package com.openclassrooms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openclassrooms.api.model.Employee;
import com.openclassrooms.api.service.EmployeeService;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	/**
	 * Get all employees
	 */
	@GetMapping("/index/employees")
	public Iterable<Employee> getAll(){
		return employeeService.getAll();
	}
	
	/**
	 * Get Employee By Id
	 */
	@GetMapping("/get/employee/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	/**
	 * Create Employee
	 */
	@PostMapping("/add/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	/**
	 * Update Employee
	 */
	@PutMapping("/edit/employee/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployee( employee, id);
	}
}
