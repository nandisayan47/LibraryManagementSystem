package com.sayan.lms.service;

import com.sayan.lms.entity.*;

public interface UserService {
	
	public UserDtls createUser(UserDtls user); 
	
	public boolean checkEmail(String email);

}
