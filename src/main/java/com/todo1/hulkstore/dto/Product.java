package com.todo1.hulkstore.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	
	private Integer id;
	private String productName;
	private BigDecimal productPrice;
	private String productDescription;
	private Integer productQuantity;
	
	public Product() {
		super();
	}
	public Product(Integer id, String productName, BigDecimal productPrice, String productDescription,
			Integer productQuantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
		this.productQuantity = productQuantity;
	}
	
	

}
