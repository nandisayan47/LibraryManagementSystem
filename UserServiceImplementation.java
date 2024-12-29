package com.sayan.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sayan.lms.entity.*;
import com.sayan.lms.repository.*;

@Service
public class UserServiceImplementation implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	@Override
	public boolean checkEmail(String email) {
		
		return userRepo.existsByEmail(email);
	}

	
	
	@Override
	public UserDtls createUser(UserDtls user) {
		
		user.setPassword(passwordEncode.encode(user.getPassword()));
		user.setRole("ROLE_USER");
		
		return userRepo.save(user);
	}
	
	

}
