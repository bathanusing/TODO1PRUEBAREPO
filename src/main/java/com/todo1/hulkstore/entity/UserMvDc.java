package com.todo1.hulkstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.todo1.hulkstore.dto.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="USERMVDC")
@Getter
@Setter
public class UserMvDc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="USERMVDC_ID")
	private Integer id;
	@Column(name ="USERNAME")
	private String userName;
	@Column(name ="PASSWORD")
	private String password;
	@Column(name ="NAME")
	private String name;
	@Column(name ="LASTNAME")
	private String lastname;
	@Column(name ="ADDRESS")
	private String address;
	@Column(name ="COUNTRY")
	private String country;
	@Column(name ="ROLES")
	private String roles;
	
	
	public UserMvDc(User user) {
		super();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.name = user.getName();
		this.lastname = user.getLastname();
		this.address = user.getAddress();
		this.country = user.getCountry();
		this.roles = user.getRoles();
	}
	
	public UserMvDc() {}
}
