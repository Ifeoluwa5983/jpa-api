package com.techielady.demo.cruddemo.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techielady.demo.cruddemo.entity.Employee;
import com.techielady.demo.cruddemo.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getById(@PathVariable int employeeId) {
		
		Employee theEmployeeId = employeeService.getEmployeebyId(employeeId);
		
		if (theEmployeeId == null) {
			throw new RuntimeException("Employee Id not found - " + employeeId);
		}
		return theEmployeeId;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		
		employeeService.saveAll(theEmployee);
		
		return theEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		 
		employeeService.saveAll(theEmployee);
		
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.getEmployeebyId(employeeId);
		
		if(tempEmployee == null) {
			throw new RuntimeException("Id not found - " + employeeId);
		}
		
		employeeService.deleteById(employeeId);
		
		return "Employee with the id " + employeeId + "has been deleted";
	}
}









