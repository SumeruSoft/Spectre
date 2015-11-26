package com.sumeru.service;

import java.util.List;

import com.sumeru.model.Car;

public interface CarService {

	void save(Car car);

	List<Car> findAll();
	
	Car findByID(long id);
	
	void update(Car car);

	void deleteByID(long id);
}
