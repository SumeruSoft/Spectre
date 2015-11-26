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

import com.sumeru.model.Car;
import com.sumeru.utils.IConstants;
import com.websystique.springmvc.configuration.HibernateConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration @ContextConfiguration(classes = HibernateConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarRestWSTest  {
	   
//	   @Test 
//	   public void tp(){
//		   assertEquals("John", "John");
//	   }
	   @Test
	   public  void aCreate(){
		   RestTemplate restTemplate = new RestTemplate();
			Car obj =  new Car("Hatch Back", "Accord" ,4 , 10 );
	    	obj.setLastUpdatedBy("Sachin");
	   	//	obj.setLastUpdatedOn(new LocalDateTime());
	        URI uri = restTemplate.postForLocation(IConstants.REST_SERVICE_URI+"/car/", obj,  Car.class);
	   }
	   
	 //  @Test
	   public  void aCreate1(){
		   RestTemplate restTemplate = new RestTemplate();
			Car obj =  new Car("Hatch Back", "Accord" ,4 , 10 );
	    	obj.setLastUpdatedBy("Sachin");
	   		//obj.setLastUpdatedOn(new LocalDateTime());
	        URI uri = restTemplate.postForLocation(IConstants.REST_SERVICE_URI+"/car/", obj,  Car.class);
	   }
	   
	  // @Test
	   public  void read(){
		   
			RestTemplate restTemplate = new RestTemplate();
	        Car obj = restTemplate.getForObject(IConstants.REST_SERVICE_URI+"/car/"+ IConstants.testEmpID, Car.class);
	        assertEquals("Accord", obj.getShortName());
	        assertEquals(4, obj.getCapacity());
		}
	   
	 // @Test
	  // @Test(expected = IllegalArgumentException.class)
	   public  void update(){
		   RestTemplate restTemplate = new RestTemplate();
	        Car obj = new Car();
	        obj.setRatePerKm(11);
	        
	        restTemplate.put(IConstants.REST_SERVICE_URI+"/car/"+2, obj);
	        
	        Car obj1 = restTemplate.getForObject(IConstants.REST_SERVICE_URI+"/car/2" , Car.class);
	        assertEquals(11, obj1.getRatePerKm());
	  
	   }
	   
	//  @Test
	   public void deleteEmp(){
		   RestTemplate restTemplate = new RestTemplate();
	       restTemplate.delete(IConstants.REST_SERVICE_URI+"/car/"+ IConstants.testEmpID);
	        
	       Car obj = restTemplate.getForObject(IConstants.REST_SERVICE_URI+"/car/"+IConstants.testEmpID, Car.class);
	       assertEquals(IConstants.STATUS_INACTIVE, obj.getStatus());
	   }
	   
	   
}
