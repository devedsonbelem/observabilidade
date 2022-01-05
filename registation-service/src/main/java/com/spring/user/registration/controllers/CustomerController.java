package com.spring.user.registration.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.user.registration.entity.Customer;
import com.spring.user.registration.entity.Product;
import com.spring.user.registration.repository.CustomerRepository;
import com.spring.user.registration.service.CustomerService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomerController {

	private final  CustomerService customerService;

  @GetMapping("/customers")
  public ResponseEntity<Object> getAllCustomers(@RequestParam(required = false) String  name) {
    try {
       List<Customer> customers = customerService.getCustomersName(name);        
      return  ResponseEntity.status(200).body(customers);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/customers/{id}")
  public ResponseEntity<?> getCustomersById(@PathVariable("id") String id) {
    try {
	  Customer customerData = customerService.getCustomersId(id);
	  return  ResponseEntity.status(200).body(customerData);
    }catch(Exception ex) {
         return  ResponseEntity.status(404).body("nao encontrado");
    }
  }

  @PostMapping("/customers")
  public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
    try {
      Customer _customer = customerService.addCustomer( customer);
      return  ResponseEntity.status(200).body(_customer);
    } catch (Exception e) {
    	e.printStackTrace();
    	  return  ResponseEntity.status(500).body("Nao Incluido" + e.getMessage());
    }
  }

  @PutMapping("/customers/{id}")
  public ResponseEntity<?> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
	  try {
	  customerService.updateCustomer(id, customer);
	  return  ResponseEntity.status(200).body(customer);
	  }catch(Exception  ex) {
		  return  ResponseEntity.status(500).body("Nao Atualizado");
	  }
  }

//  @DeleteMapping("/customers/{id}")
//  public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") String id) {
//    try {
//      customerRepository.deleteById(id);
//      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }


} 
