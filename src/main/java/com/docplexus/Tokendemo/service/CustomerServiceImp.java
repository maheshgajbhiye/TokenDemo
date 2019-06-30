package com.docplexus.Tokendemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docplexus.Tokendemo.bean.Customer;
import com.docplexus.Tokendemo.bean.Priority;
import com.docplexus.Tokendemo.dao.CustomerRepository;
import com.docplexus.Tokendemo.dao.PriorityRepository;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	PriorityRepository priorityRepository;

	public void createUser(Customer customer) {
		customerrepository.save(customer);
	}

	public void createPriority(Priority priority) {
		priorityRepository.save(priority);
	}

}
