package com.sumeru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sumeru.dao.CarDao;
import com.sumeru.model.Car;

@Service("carService")
@Transactional
public class CarServiceImpl implements CarService{

	@Autowired
	private CarDao dao;

	public void save(Car car) {
		dao.save(car);
		
	}

	public List<Car> findAll() {
		return dao.findAll();
	}

	public Car findByID(long id) {
		return dao.findByID(id);
	}

	public void update(Car car) {
		dao.update(car);
	}

	public void deleteByID(long id) {
		dao.deleteByID(id);
		
	}

}
