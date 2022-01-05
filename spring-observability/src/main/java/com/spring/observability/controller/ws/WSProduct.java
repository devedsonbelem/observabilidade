package com.spring.observability.controller.ws;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WSProduct {
 
	private String nameProduct;
	private String uuid;
	private Double price;
}
