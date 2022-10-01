package com.greatlearning.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatlearning.customer.entity.*;

@Repository
public class CustomerServiceImpl implements CustomerService {
	private SessionFactory sessionFactory;

	// create session
	private Session session;

	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

	}

	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();

		// get the list of all the customers form the DB
		List<Customer> totalCustomers = session.createQuery("from Customer").list();

		tx.commit();

		return totalCustomers;
	}

	@Transactional
	public Customer findById(int customerId) {
		Transaction tx = session.beginTransaction();

		// get the Customer record from the Database based on their Id
		Customer theCustomer = session.get(Customer.class, customerId);

		tx.commit();

		return theCustomer;
	}

	@Transactional
	public void addOrUpdate(Customer customer) {
		Transaction tx = session.beginTransaction();

		// adding a new customer or saving any updates made for them
		session.saveOrUpdate(customer);

		tx.commit();
	}

	@Transactional
	public void deleteById(int customerId) {
		Transaction tx = session.beginTransaction();

		// getting the customer object for the Id provided
		Customer theCustomer = session.get(Customer.class, customerId);

		session.delete(theCustomer);

		tx.commit();
	}

	// print the loop
	@Transactional
	public void print(List<Customer> customers) {

		for (Customer c : customers) {
			System.out.println(c);
		}
	}

}
