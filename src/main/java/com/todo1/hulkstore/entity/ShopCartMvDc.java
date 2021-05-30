package com.todo1.hulkstore.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="SHOPCARTMVDC")
@Getter
@Setter
public class ShopCartMvDc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="SHOPMVDC_ID")
	private Integer id;
	@Column(name ="TOTAL")
	private BigDecimal total;
	@Column(name ="CURRENCY")
	private String currency;
	@Column(name ="USERMVDC_ID")
	private Integer usermvdcId;

}
