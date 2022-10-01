package com.greatlearning.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import com.greatlearning.customer.entity.Customer;

public interface CustomerService {

	List<Customer> findAll();

	Customer findById(int customerId);

	void addOrUpdate(Customer customer);

	void deleteById(int customerId);

	// print the loop
	void print(List<Customer> customers);

}