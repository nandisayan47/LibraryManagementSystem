package com.sayan.project.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sayan.project.controller.dto.UserRegistrationDto;
import com.sayan.project.model.User;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
//	void delete(UserRegistrationDto registrationDto);
}
