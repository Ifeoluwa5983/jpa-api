package com.techielady.demo.cruddemo.dao;

import java.util.List;

import com.techielady.demo.cruddemo.entity.Employee;


public interface EmployeeDAO {
	
	public List<Employee> getAll();
	
	public Employee getEmployeebyId(int theId);
	
	public void saveAll(Employee thEmployee);
	
	public void deleteById(int theId);

}
