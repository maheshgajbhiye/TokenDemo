package com.docplexus.Tokendemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.docplexus.Tokendemo.bean.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("SELECT customer FROM Customer customer WHERE customer.accountNumber=(:accountNumber)")
	List<Customer> findByAccountNumber(@Param("accountNumber") long accountNumber);

}
