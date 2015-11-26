package com.sumeru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sumeru.dao.EmployeeDao;
import com.sumeru.model.Employee;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao dao;

	public void save(Employee employee) {
		dao.save(employee);
		
	}

	public List<Employee> findAll() {
		
		return dao.findAll();
	}

	public List<Employee> findByRole(String role) {
		return dao.findByRole(role);
	}

	public Employee findByID(long id) {
		return dao.findByID(id);
	}

	public void update(Employee employee) {
		dao.update(employee);
		
	}

	public void deleteByID(long id) {
		dao.deleteByID(id);
		
	}

	public boolean checkValidity(String login, String passwd) {
		return dao.checkValidity(login, passwd);
	}
	
	
}
