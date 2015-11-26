package com.sumeru.restWS;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.joda.time.LocalDateTime;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.sumeru.model.Employee;
import com.sumeru.utils.IConstants;
import com.websystique.springmvc.configuration.HibernateConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration @ContextConfiguration(classes = HibernateConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpRestWSTest  {
//	   @Autowired
//	   private EmployeeService service;
	   
	   @Test 
	   public void tp(){
		   assertEquals("John", "John");
	   }
	   @Test
	   public  void aCreateEmp(){
		   RestTemplate restTemplate = new RestTemplate();
			
			Employee emp = new Employee("John" , "john" ,"john123" ,IConstants.CITY_PUNE, IConstants.STATUS_ACTIVE );
	    	emp.setLastUpdatedBy("Sachin");
//	   		emp.setLastUpdatedOn(new LocalDateTime());
	        URI uri = restTemplate.postForLocation(IConstants.REST_SERVICE_URI+"/emp/", emp,  Employee.class);
	   }
	   
	   @Test
	   public  void readEmp(){
		   
			RestTemplate restTemplate = new RestTemplate();
	        Employee emp1 = restTemplate.getForObject(IConstants.REST_SERVICE_URI+"/emp/"+ IConstants.testEmpID, Employee.class);
	        assertEquals("John", emp1.getName());
		}
	   
	  @Test
	  // @Test(expected = IllegalArgumentException.class)
	   public  void updateEmp(){
		   RestTemplate restTemplate = new RestTemplate();
	        Employee emp = new Employee();
	        emp.setName("Roger");
	        
	        restTemplate.put(IConstants.REST_SERVICE_URI+"/emp/"+IConstants.testEmpID, emp);
	        
	        Employee emp1 = restTemplate.getForObject(IConstants.REST_SERVICE_URI+"/emp/" +IConstants.testEmpID, Employee.class);
	        assertEquals("Roger", emp1.getName());
	  
	   }
	   
	  @Test
	   public void deleteEmp(){
		   RestTemplate restTemplate = new RestTemplate();
	       restTemplate.delete(IConstants.REST_SERVICE_URI+"/emp/"+ IConstants.testEmpID);
	        
	       Employee emp1 = restTemplate.getForObject(IConstants.REST_SERVICE_URI+"/emp/"+IConstants.testEmpID, Employee.class);
	       assertEquals(IConstants.STATUS_INACTIVE, emp1.getStatus());
	   }
	   
	   
}
