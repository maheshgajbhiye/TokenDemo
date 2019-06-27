package com.docplexus.Tokendemo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.docplexus.Tokendemo.bean.Customer;
import com.docplexus.Tokendemo.bean.Priority;
import com.docplexus.Tokendemo.dao.CustomerRepository;

public class CustomerServiceImp implements CustomerService{

	@Autowired
	CustomerRepository customerrepository;
	
	public void createUser(Customer customer) {
		customerrepository.addCustomer(customer);
	}
	
	public void createPriority(Priority priority) {
		customerrepository.addPriority(priority);
	}

}
