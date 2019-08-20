package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {

	Logger logger = LoggerFactory.getLogger( CustomerController.class );

	@Autowired
	CustomerService customerService;

	@GetMapping( "/add-customer" )
	public ResponseEntity<String> addCustomer(
			@RequestParam( name="firstName", required=true ) String firstName,
			@RequestParam( name="lastName", required=true ) String lastName ) {

		return customerService.addCustomer( firstName, lastName );
		
	}

	@GetMapping( "/get-customers" )
	public ResponseEntity<String> getCustomers() {

		return customerService.getAllCustomers();
		
	}

	@GetMapping( "/delete-customers" )
	public ResponseEntity<String> deleteCustomers() {

		return customerService.deleteAllCustomers();
		
	}

}
