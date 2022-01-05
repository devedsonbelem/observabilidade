package com.spring.user.registration.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "products")
@Data  
@AllArgsConstructor  
@NoArgsConstructor  
public class Product {

	@Id
	private ObjectId id;
	private String nameProduct;
	private String uuid;
	private Double price;


	 

}
