package com.sayan.lms.controller;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sayan.lms.entity.*;
import com.sayan.lms.repository.*;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@ModelAttribute
	private void userDetails(Model model,Principal p) {
		String email = p.getName();
		UserDtls user = userRepo.findByEmail(email);
		
		model.addAttribute("user",user);
	}
	
	@GetMapping("/")
	public String home() {
		return "user";
	}
}
