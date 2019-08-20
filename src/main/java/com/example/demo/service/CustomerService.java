package com.example.demo.service;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

public class CustomerService {

	Logger logger = LoggerFactory.getLogger( CustomerService.class );

	@Autowired
	private CustomerRepository customerRepository;

	public ResponseEntity<String> addCustomer( String firstName, String lastName ) {
		
		Customer customer = new Customer( firstName, lastName );
		String responseBody = "";

		try {
			customerRepository.save( customer );
			responseBody = "Successfully saved " + customer.toString() + "\n";
		}
		catch( Exception e ) {
			responseBody = "Could not save customer\n";
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( responseBody );
		}

		return ResponseEntity.status( HttpStatus.OK ).body( responseBody );
		
	}

	public ResponseEntity<String> getAllCustomers() {
		
		String responseBody = "";

		try {
			Iterator<Customer> customers = customerRepository.findAll().iterator();
			while ( customers.hasNext() ) {
				responseBody += customers.next();
				responseBody += "\n";
			}
		}
		catch( Exception e ) {
			responseBody = "Could not find customers\n";
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( responseBody + e.getMessage() );
		}

		return ResponseEntity.status( HttpStatus.OK ).body( responseBody );
		
	}

	public ResponseEntity<String> deleteAllCustomers() {
		String responseBody = "";

		try {
			customerRepository.deleteAll();
			responseBody = "Successfully deleted all customers\n";
		}
		catch( Exception e ) {
			responseBody = "Could not find customers\n";
			return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( responseBody + e.getMessage() );
		}

		return ResponseEntity.status( HttpStatus.OK ).body( responseBody );
	}

}
