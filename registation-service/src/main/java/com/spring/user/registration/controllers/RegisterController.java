package com.spring.user.registration.controllers;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.registration.entity.Customer;
import com.spring.user.registration.repository.CustomerRepository;
import com.spring.user.registration.repository.ProductRepository;
import com.spring.user.registration.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegisterController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
  
	  private final  CustomerService customerService;


	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody Customer customer) {
	    try {
	        Customer _customer = customerService.addCustomer( customer);
	        return  ResponseEntity.status(200).body(_customer);
	      } catch (Exception e) {
	    	logger.error("Erro Encontrado", e.getMessage());
	    	  Map<String,String> mapa=new HashMap<String,String>();
	    	  mapa.put("status","nao gravado");
	      	  return  ResponseEntity.status(500).body(mapa);
	      }
	}
}
