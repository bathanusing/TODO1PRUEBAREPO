package com.todo1.hulkstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="SHOPCARTDETAILMVDC")
@Getter
@Setter
public class ShopCartDetailMvDc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="SHOPCARTDETAILMVDC_ID")
	private Integer id;
	@Column(name ="SHOPCARTMVDC_ID")
	private Integer shopCartMvDcId;
	@Column(name ="PRODUCTMVDC_ID")
	private Integer productMvDcId;
	
}
