package com.docplexus.Tokendemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.docplexus.Tokendemo.bean.Customer;
import com.docplexus.Tokendemo.bean.Priority;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	@Query("SELECT customer FROM Customer customer WHERE customer.accountNumber=(:accountNumber)")
	Customer findByAcountNumber(@Param("accountNumber") long accountNumber);

}
