package com.sumeru.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Repository;

import com.sumeru.model.Car;
import com.sumeru.model.Employee;
import com.sumeru.utils.IConstants;

@Repository("carDao")
public class CarDaoImpl extends AbstractDao implements CarDao{

	public void save(Car car){
//		car.setLastUpdatedOn(new LocalDateTime());
		persist(car);
	}

	public List<Car> findAll() {
		Criteria criteria = getSession().createCriteria(Car.class);
		return (List<Car>) criteria.list();
	}

	public Car findByID(long id) {
		Criteria criteria = getSession().createCriteria(Car.class);
		criteria.add(Restrictions.eq("id",id));
		return (Car) criteria.uniqueResult();

	}

	public void update(Car car) {
//		car.setLastUpdatedOn(new LocalDateTime());
		getSession().update(car);
	}

	public void deleteByID(long id) {
		Criteria criteria = getSession().createCriteria(Car.class);
		criteria.add(Restrictions.eq("id",id));
		Car car = (Car) criteria.uniqueResult();
		
//		car.setLastUpdatedOn(new LocalDateTime());
		car.setStatus(IConstants.STATUS_INACTIVE);
		getSession().update(car);
		
	}
	
}
