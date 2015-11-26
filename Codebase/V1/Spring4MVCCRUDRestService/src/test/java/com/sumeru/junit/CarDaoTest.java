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

import com.sumeru.model.Car;
import com.sumeru.service.CarService;
import com.sumeru.utils.IConstants;
import com.websystique.springmvc.configuration.HibernateConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration @ContextConfiguration(classes = HibernateConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CarDaoTest  {
	   @Autowired
	   private CarService service ;
	   
	   @Test
	   public void aCreate() {
		   Car car = new Car("Big Car","Tavera"  ,6 , 15);
		  // car.setLastUpdatedOn(new LocalDateTime());
		   service.save(car); ;
		   //Assert.assertNotNull(service.getLoadedPM().getTechLead());
	       assertEquals(6, car.getCapacity());
	   }
	   
	  // @Test
	   public  void read(){
		    Car car = service.findByID(IConstants.testEmpID);
	        assertEquals("Logan", car.getShortName());
		}
	   
	//   @Test
	   public  void update(){
		    Car car = service.findByID(IConstants.testEmpID);
	        car.setRatePerKm(12);;
	        
		    service.update(car);
		    
		    Car car1 = service.findByID(IConstants.testEmpID);
	        assertEquals(12, car.getRatePerKm());
		}
	   
	  // @Test
	   public  void delete(){
		    service. deleteByID(IConstants.testEmpID);;
		    
		    Car car1 = service.findByID(IConstants.testEmpID);
	        assertEquals(IConstants.STATUS_INACTIVE, car1.getStatus());
		}
	   
	   
}
