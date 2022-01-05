package com.spring.user.registration.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.user.registration.entity.Customer;

@Repository
public interface CustomerRepository  extends MongoRepository<Customer, String> {
	
	 public ArrayList<Customer> findByName(String name);
 
	 
	 
}
