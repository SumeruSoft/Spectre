package com.sumeru.dao;


import java.util.List;

import com.sumeru.model.Car;

public interface CarDao {

	void save(Car car);

	List<Car> findAll();
	
	Car findByID(long id);
	
	void update(Car car);

	void deleteByID(long id);
	
}
