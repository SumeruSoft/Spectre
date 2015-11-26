package com.junit;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.websystique.springmvc.configuration.HibernateConfiguration;
import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration @ContextConfiguration(classes = HibernateConfiguration.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest  {
	   @Autowired
	   private UserService service ;
	   
	   @Test
	   public void aCreate() {
		   User user = new User("Virat","Delhi","virat@anushka.com");
		   service.saveUser(user);
		   //Assert.assertNotNull(service.getLoadedPM().getTechLead());
	       assertEquals("Delhi", user.getAddress());
	   }
	   
	   @Test
	   public  void read(){
		    User user = service.findById(1);
	        assertEquals("Virat", user.getUsername());
		}
	   
//	   @Test
//	   public  void updateCar(){
//		    Car car = service.findByID(IConstants.testEmpID);
//	        car.setRatePerKm(12);;
//	        
//		    service.update(car);
//		    
//		    Car car1 = service.findByID(IConstants.testEmpID);
//	        assertEquals(12, car.getRatePerKm());
//		}
//	   
//	   @Test
//	   public  void deleteEmp(){
//		    service. deleteByID(IConstants.testEmpID);;
//		    
//		    Car car1 = service.findByID(IConstants.testEmpID);
//	        assertEquals(IConstants.STATUS_INACTIVE, car1.getStatus());
//		}
	   
	   
}
