package com.techielady.demo.cruddemo.services;

import java.util.List;

import com.techielady.demo.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAll();
	
	public Employee getEmployeebyId(int theId);
	
	public void saveAll(Employee thEmployee);
	
	public void deleteById(int theId);

}
