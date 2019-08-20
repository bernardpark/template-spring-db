package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.CustomerService;

@Configuration
public class ApplicationConfig {
	
    @Bean
    public CustomerService customerService() {
            final CustomerService customerService = new CustomerService();
            return customerService;
    }

}
