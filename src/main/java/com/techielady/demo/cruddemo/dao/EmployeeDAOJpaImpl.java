package com.techielady.demo.cruddemo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.techielady.demo.cruddemo.entity.Employee;

public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> getAll() {
		Query theQuery = entityManager.createQuery("from employee");
		
		List<Employee> employees = theQuery.getResultList();
		
		return employees;
	}

	@Override
	public Employee getEmployeebyId(int theId) {
		
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		return theEmployee;
	}

	@Override
	public void saveAll(Employee thEmployee) {
		
		Employee dbEmployee = entityManager.merge(thEmployee);
		
		dbEmployee.setId(thEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		Query theQuery =
				entityManager.createQuery("delete employee where id =: employeeId");
		
		theQuery.setParameter("employeeId", theId);
		
		theQuery.executeUpdate();
	}

}
