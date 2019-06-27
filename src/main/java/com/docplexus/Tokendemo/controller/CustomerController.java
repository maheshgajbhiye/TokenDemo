package com.docplexus.Tokendemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docplexus.Tokendemo.bean.Customer;
import com.docplexus.Tokendemo.bean.Priority;
import com.docplexus.Tokendemo.service.CustomerService;

@RestController
@RequestMapping(value = { "/customer" })
public class CustomerController {

	@Autowired
	CustomerService customerservice;
	
	@PostMapping(value="/create",headers="Accept=application/json")
    public ResponseEntity<Void> createUser(@RequestBody Customer customer){
        System.out.println("Creating User "+customer.getName());
        customerservice.createUser(customer);        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
	
	@PostMapping(value="/addPriority",headers="Accept=application/json")
    public ResponseEntity<Void> createPriority(@RequestBody Priority priority){
        System.out.println("Creating User "+priority.getType());
        customerservice.createPriority(priority);        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
