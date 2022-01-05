package com.spring.user.registration.service;

import java.util.List;

import com.spring.user.registration.entity.Customer;

public interface ICustomerService {

	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(String id, Customer customer);
	public List<Customer> getCustomersName(String name);
	public Customer getCustomersId(String id) ;
	public List<Customer> getAllCustomer();
}
