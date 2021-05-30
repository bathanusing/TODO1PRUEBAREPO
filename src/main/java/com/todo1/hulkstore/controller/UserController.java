package com.todo1.hulkstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo1.hulkstore.dto.User;
import com.todo1.hulkstore.entity.UserMvDc;
import com.todo1.hulkstore.repository.UserMvDcRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserMvDcRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@GetMapping("/register")
	private String registerUserPage() {
		return "register";
	}
	
	@PostMapping("/add")
	public String registerUser(ModelMap model, User user, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		String encodedpass=encoder.encode(user.getPassword());
		user.setPassword(encodedpass);
		UserMvDc userPersistent = new UserMvDc(user);
		
		if(userRepository.findByuserName(user.getUserName()).isPresent()) {
			return "redirect:/error";
		}
		userRepository.save(userPersistent);
		return "redirect:/";
	}
	
}
