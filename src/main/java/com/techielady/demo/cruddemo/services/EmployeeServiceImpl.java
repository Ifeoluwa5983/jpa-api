package com.techielady.demo.cruddemo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techielady.demo.cruddemo.dao.EmployeeDAO;
import com.techielady.demo.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}

	@Override
	@Transactional
	public Employee getEmployeebyId(int theId) {
		return employeeDAO.getEmployeebyId(theId);
	}

	@Override
	@Transactional
	public void saveAll(Employee thEmployee) {
		employeeDAO.saveAll(thEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
	}

}
