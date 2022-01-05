package com.spring.user.registration.entity;

 
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	private ObjectId id;
	private Integer age;
    private String name;
	private String uuid;
	private String email;
 
	//@DBRef(db = "products")
	//private List<Product> products = new ArrayList<Product>();
     
	{
		 if (uuid==null) {
			 this.uuid = UUID.randomUUID().toString();
		 }
	}
	
}
