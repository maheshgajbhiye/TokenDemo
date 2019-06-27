package com.docplexus.Tokendemo.service;

import com.docplexus.Tokendemo.bean.Customer;
import com.docplexus.Tokendemo.bean.Priority;

public interface CustomerService {

	void createUser(Customer customer);
	void createPriority(Priority priority);
}
