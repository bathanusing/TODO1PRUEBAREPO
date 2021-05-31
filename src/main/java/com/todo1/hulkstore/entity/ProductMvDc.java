package com.todo1.hulkstore.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.todo1.hulkstore.dto.Product;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="PRODUCTMVDC")
@Getter
@Setter
public class ProductMvDc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="PRODUCTMVDC_ID")
	private Integer id;
	@Column(name ="PRODUCTNAME")
	private String productName;
	@Column(name ="PRODUCTPRICE")
	private BigDecimal productPrice;
	@Column(name ="PRODUCTDESCRIPTION")
	private String productDescription;
	@Column(name ="PRODUCTQUANTITY")
	private Integer productQuantity;
	
	public ProductMvDc() {}
	
	public ProductMvDc(Product product) {
		this.id = product.getId();
		this.productName = product.getProductName();
		this.productPrice = product.getProductPrice();
		this.productDescription = product.getProductDescription();
		this.productQuantity = product.getProductQuantity();
	}
}
