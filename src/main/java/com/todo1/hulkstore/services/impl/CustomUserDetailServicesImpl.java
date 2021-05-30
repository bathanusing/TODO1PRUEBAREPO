package com.todo1.hulkstore.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.todo1.hulkstore.entity.UserMvDc;
import com.todo1.hulkstore.repository.UserMvDcRepository;
import com.todo1.hulkstore.services.CustomUserDetailServices;
import com.todo1.hulkstore.util.Constants;

@Service
public class CustomUserDetailServicesImpl implements CustomUserDetailServices{
	
	@Autowired
	UserMvDcRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<UserMvDc> optionalUsers = userRepository.findByuserName(username);
		
		optionalUsers.orElseThrow(() -> new UsernameNotFoundException(Constants.NOT_FOUND_USER));
		
		return optionalUsers.map(CustomUserDetailsImpl::new).get();
	}
	
	

}
