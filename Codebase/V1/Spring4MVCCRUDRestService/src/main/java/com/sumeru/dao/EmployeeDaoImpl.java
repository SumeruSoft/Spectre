package com.sumeru.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sumeru.model.Employee;
import com.sumeru.utils.IConstants;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao{

	public void save(Employee employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAll() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

//	public void deleteEmployeeBySsn(String ssn) {
//		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
//		query.setString("ssn", ssn);
//		query.executeUpdate();
//	}

	
	public void update(Employee employee){
		getSession().update(employee);
	}


	public List<Employee> findByRole(String role) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("role",role));
		return (List<Employee>) criteria.list();
	}

	public Employee findByID(long id) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id",id));
		return (Employee) criteria.uniqueResult();
	}

	public void deleteByID(long id) {
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("id",id));
		Employee emp = (Employee) criteria.uniqueResult();
		
		emp.setStatus(IConstants.STATUS_INACTIVE);
		getSession().update(emp);
		
	}

	public boolean checkValidity(String login, String passwd) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
