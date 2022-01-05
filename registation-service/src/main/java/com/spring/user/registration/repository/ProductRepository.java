package com.spring.user.registration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.user.registration.entity.Product;
@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	  public Product findByNameProduct(String nameProduct);

}
