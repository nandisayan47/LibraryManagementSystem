package com.sayan.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sayan.project.controller.dto.UserRegistrationDto;
import com.sayan.project.model.User;
import com.sayan.project.repository.UserRepository;
import com.sayan.project.service.UserService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	
	
	@Autowired
	UserRepository userRepository;
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		
		
		User user1= userRepository.getUserByUsername(registrationDto.getUsername());
		if(user1==null) {
			
			
			userService.save(registrationDto);
			return "redirect:/registration?success";
			
			
		}
		return "redirect:/registration?failure";//To handle exception for already existing username
	}

}