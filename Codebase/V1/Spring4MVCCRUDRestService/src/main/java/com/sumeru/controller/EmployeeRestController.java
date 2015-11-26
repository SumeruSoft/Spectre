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

import com.sumeru.model.Employee;
import com.sumeru.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	EmployeeService empService;

	
	//-------------------Retrieve All Emp--------------------------------------------------------
	
	@RequestMapping(value = "/emp/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllEmployees() {
		List<Employee> employees =  empService.findAll();
		if(employees.isEmpty()){
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	//-------------------Retrieve Single Emp--------------------------------------------------------
	
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> getEmp(@PathVariable("id") int id) {
		System.out.println("Fetching Emp with id " + id);
		Employee emp = empService.findByID(id);
		if (emp == null) {
			System.out.println("Employee with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	
	//-------------------Create a Emp--------------------------------------------------------
	
	@RequestMapping(value = "/emp/", method = RequestMethod.POST)
	public ResponseEntity<Void> createEmp(@RequestBody Employee emp, 	UriComponentsBuilder ucBuilder) {
		System.out.println("Creating EMp " + emp );

		empService.save(emp);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/emp/{ssn}").buildAndExpand(emp.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	
	//------------------- Update a Emp --------------------------------------------------------
	
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmp(@PathVariable("id") int id, @RequestBody Employee emp) {
		System.out.println("Updating Emp with id " + id);
		
		Employee currEmp = empService.findByID(id);
		
		if (currEmp==null) {
			System.out.println("Emp with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		currEmp.setName(emp.getName());
	
		empService.update(currEmp);
		return new ResponseEntity<Employee>(currEmp, HttpStatus.OK);
	}

	//------------------- Delete a Emp --------------------------------------------------------
	
	@RequestMapping(value = "/emp/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Employee> deleteEmp(@PathVariable("id") int id) {
		System.out.println("Fetching & Deleting Emp with id " + id);

		Employee emp = empService.findByID(id);
		if (emp == null) {
			System.out.println("Unable to delete. Emp with id " + id + " not found");
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		
		empService.deleteByID(id);;
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}

	

}
