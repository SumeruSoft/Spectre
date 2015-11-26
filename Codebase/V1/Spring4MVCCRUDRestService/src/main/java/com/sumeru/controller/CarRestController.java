package com.sumeru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sumeru.model.Car;
import com.sumeru.service.CarService;

@RestController
public class CarRestController {

	@Autowired
	CarService service;

	
	//-------------------Retrieve All Object--------------------------------------------------------
	
	@RequestMapping(value = "/car/", method = RequestMethod.GET)
	public ResponseEntity<List<Car>> listAll() {
		List<Car> employees =  service.findAll();
		if(employees.isEmpty()){
			return new ResponseEntity<List<Car>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Car>>(employees, HttpStatus.OK);
	}

	//-------------------Retrieve Single Object--------------------------------------------------------
	
	@RequestMapping(value = "/car/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Car> get(@PathVariable("id") int id) {
		System.out.println("Fetching Emp with id " + id);
		Car obj = service.findByID(id);
		if (obj == null) {
			System.out.println("Car with id " + id + " not found");
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Car>(obj, HttpStatus.OK);
	}

	
	//-------------------Create a Object--------------------------------------------------------
	
	@RequestMapping(value = "/car/", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Car obj, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Car " + obj );

		service.save(obj);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/car/{id}").buildAndExpand(obj.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	//------------------- Update a Object --------------------------------------------------------
	
	@RequestMapping(value = "/car/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Car> update(@PathVariable("id") int id, @RequestBody Car obj) {
		System.out.println("Updating Car with id " + id);
		
		Car currObj = service.findByID(id);
		
		if (currObj==null) {
			System.out.println("Car with id " + id + " not found");
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		
		currObj.setRatePerKm(obj.getRatePerKm());
	
		service.update(currObj);
		return new ResponseEntity<Car>(currObj, HttpStatus.OK);
	}

	//------------------- Delete a Object --------------------------------------------------------
	
	@RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Car> delete(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Car with id " + id);

		Car obj = service.findByID(id);
		if (obj == null) {
			System.out.println("Unable to delete. Car with id " + id + " not found");
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		
		service.deleteByID(id);;
		return new ResponseEntity<Car>(HttpStatus.NO_CONTENT);
	}

	

}
