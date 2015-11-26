package com.websystique.springmvc;

import org.springframework.beans.factory.annotation.Autowired;

import com.websystique.springmvc.service.UserService;

public class MyTest {
	  @Autowired
	   static private UserService
	   service ;
	public static void main(String[] args) {
		System.out.println(" service = "+ service);

	}

}
