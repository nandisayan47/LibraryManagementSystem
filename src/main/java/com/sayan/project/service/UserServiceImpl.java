package com.sayan.project.service;

import java.util.Collection;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sayan.project.controller.dto.UserRegistrationDto;
import com.sayan.project.model.Role;
import com.sayan.project.model.User;
import com.sayan.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		User user = userRepository.getUserByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

    private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User save(UserRegistrationDto registrationDto) {
		Set<Role> set=new HashSet<>();
		set.add(new Role("USER"));
		User user=new User(registrationDto.getFname(),registrationDto.getLname(),registrationDto.getCity(),
				registrationDto.getUsername(),passwordEncoder.encode(registrationDto.getPassword()),true,set);
		return userRepository.save(user);
	}

	
	
	
	
//	
//	@Override
//	public void delete(UserRegistrationDto registrationDto) {
//		User user = userRepository.getUserByUsername(registrationDto.getUsername());
//	    userRepository.deleteById(user.getId());
//	}
}
