package com.spring.user.registration.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.user.registration.entity.Customer;
import com.spring.user.registration.entity.Product;
import com.spring.user.registration.repository.CustomerRepository;
import com.spring.user.registration.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerService implements ICustomerService {

	private final CustomerRepository customerRepository;
	private final ProductRepository productRepository;

	public Customer addCustomer(Customer customer) {
		Customer customersave = customerRepository.save(customer);
		 
		return customersave;
	}

	public Customer updateCustomer(String id, Customer customer) {
		Optional<Customer> savedCustomer = customerRepository.findById(id);
		Customer savecustomer = null;
		if (savedCustomer.isEmpty()) {
			throw new IllegalArgumentException("Nao Encontrado pelo Id");
		} else {
			savecustomer = savedCustomer.get();
			savecustomer.setName(customer.getName());
			savecustomer.setAge(customer.getAge());
			savecustomer.setEmail(customer.getEmail());
		//	List<Product> saveProducts = customer.getProducts();
		///	for (Product product : saveProducts) {
		//		product.setUuid(savecustomer.getUuid());
		//		productRepository.save(product);
		//	}
		}
		Customer custom = customerRepository.save(savecustomer);
		return custom;
	}

	public List<Customer> getCustomersName(String name) {
		List<Customer> customers = (ArrayList<Customer>) customerRepository.findByName(name).stream().iterator();

		if (customers.isEmpty()) {
			throw new IllegalArgumentException("Dados Nao Encontrados");
		} else {
			return customers;
		}
	}

	public Customer getCustomersId(String id) {
		Customer customers = customerRepository.findById(id).get();

		if (customers == null) {
			throw new IllegalArgumentException("Dados Nao Encontrados");
		} else {
			return customers;
		}
	}

	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

}
