package com.todo1.hulkstore.services.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.todo1.hulkstore.entity.UserMvDc;
import com.todo1.hulkstore.services.CustomUserDetails;

public class CustomUserDetailsImpl implements CustomUserDetails{
	
	private String userName;
	private String password;
	private String name;
	private String lastname;
	private String address;
	private String country;
	
	private List<GrantedAuthority> authorities;
	
	public CustomUserDetailsImpl(UserMvDc user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.lastname = user.getLastname();
		this.address=user.getLastname();
		this.country=user.getCountry();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	public CustomUserDetailsImpl() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	

}
