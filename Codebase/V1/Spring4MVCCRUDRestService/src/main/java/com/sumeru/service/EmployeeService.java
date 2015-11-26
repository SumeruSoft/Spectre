package com.sumeru.service;

import java.util.List;

import com.sumeru.model.Employee;

public interface EmployeeService {

	void save(Employee employee);

	List<Employee> findAll();
	
	List<Employee> findByRole(String role);
	
	Employee findByID(long id);
	
	void update(Employee employee);

	void deleteByID(long id);
	
	boolean checkValidity(String login , String passwd);
	
}
