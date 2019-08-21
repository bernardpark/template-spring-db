package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
	
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
	private long id;
	private String firstName;
	private String lastName;
	
	public Customer( String firstName, String lastName ) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return String.format( "Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName );
	}
	
}