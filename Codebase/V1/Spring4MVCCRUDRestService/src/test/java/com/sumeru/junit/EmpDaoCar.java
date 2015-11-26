package com.sumeru.junit;

import static org.junit.Assert.assertEquals;

import org.joda.time.LocalDateTime;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sumeru.model.Employee;
import com.sumeru.service.EmployeeService;
import com.sumeru.utils.IConstants;
import com.websystique.springmvc.configuration.HibernateConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration @ContextConfiguration(classes = HibernateConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoCar  {
	   @Autowired
	   private EmployeeService service;
	   
	   @Test
	   public void aCreateEmp() {
		   Employee emp = new Employee("John" , "john" ,"john123" ,IConstants.CITY_PUNE, IConstants.STATUS_ACTIVE );
//		   emp.setLastUpdatedOn(new LocalDateTime());
		   service.save(emp);
		   //Assert.assertNotNull(service.getLoadedPM().getTechLead());
	       assertEquals("John", emp.getName());
	   }
	   
	   @Test
	   public  void readEmp(){
		    Employee emp = service.findByID(IConstants.testEmpID);
	        assertEquals("John", emp.getName());
		}
	   
	   @Test
	   public  void updateEmp(){
		    Employee emp = service.findByID(IConstants.testEmpID);
	        emp.setName("Roger");
	        
		    service.update(emp);
		    
		    Employee emp1 = service.findByID(IConstants.testEmpID);
	        assertEquals("Roger", emp1.getName());
		}
	   
	   @Test
	   public  void deleteEmp(){
		   // Employee emp = service.findEmpByID(IConstants.testEmpID);
	      //  emp.setName("Roger");
	        
		    service.deleteByID(IConstants.testEmpID);;
		    
		    Employee emp1 = service.findByID(IConstants.testEmpID);
	        assertEquals(IConstants.STATUS_INACTIVE, emp1.getStatus());
		}
	   
	   
}
