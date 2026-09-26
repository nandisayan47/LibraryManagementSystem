package com.sayan.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sayan.project.controller.dto.UserRegistrationDto;
import com.sayan.project.model.Book;
import com.sayan.project.repository.UserRepository;
import com.sayan.project.service.BookServices;
import com.sayan.project.service.UserService;
import com.sayan.project.service.UserServiceImpl;
import com.sayan.project.model.User;
import java.util.*
;
@Controller
public class AppController {
	@Autowired
	private BookServices service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Book> listBoo = service.listAll();
		model.addAttribute("listBook",listBoo);
		return "index";
	}
	
	@RequestMapping("/new")
	public String newBookPage(Model model) {
		Book boo = new Book();
		model.addAttribute("book",boo);
		return "new_book";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST )
	public String saveBook(@ModelAttribute("book") Book boo) {
		service.save(boo);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{bid}")
	public ModelAndView showEditStudentpage(@PathVariable (name="bid") int id) {
		ModelAndView mav=new ModelAndView("edit_book");
		Book boo=service.get(id); 
		mav.addObject("book",boo);
		return mav;
	}
	
	@RequestMapping("/delete/{bid}")
	public String deleteBookpage(@PathVariable (name="bid") int id) {
		service.delete(id);
		return "redirect:/";
	}

	List<Book> borrowed=new ArrayList<>();
	@RequestMapping("/borrowed/{bid}")
	public String borrowedBook(@PathVariable (name="bid") int id) {	
		borrowed.add(service.get(id));
		service.delete(id);
		//service.setAvailabilityToFalse(id);
		return "redirect:/";
	}
	@RequestMapping("/borrowedbooks")
	public String borrowedBookDetails(Model model) {
		model.addAttribute("borrowedBooks",borrowed);
		return "borrowed_books";
	}

	
	
	@GetMapping("/login")
	public String showLoginPage() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null || authentication instanceof AnonymousAuthenticationToken) {
			return "/login";
		}
		return "redirect:/";
	}
	
	
//	@Autowired
//	private UserRepository userRepo;
//	
//	@RequestMapping("/register")
//	public String registrationPage(Model model) {
//		User use=new User();
//		model.addAttribute("user", use);
//		return "registration";
//	}
//	@RequestMapping(value="/registered", method = RequestMethod.POST )
//	public String registerUser(@ModelAttribute("user") User use) {
//		
//		userRepo.save(use);
//		return "redirect:/login";
//	}
	
//	@Autowired
//	private UserService userService;
//	
//	@ModelAttribute("user")
//    public UserRegistrationDto userRegistrationDto() {
//        return new UserRegistrationDto();
//    }
//	
//	@GetMapping("/register")
//	public String showRegistrationForm() {
//		return "registration";
//	}
//	
//	@PostMapping("/registration")
//	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
//		userService.save(registrationDto);
//		return "redirect:/login"; //registration?success";
//	}
	
	//To show User details
	@Autowired
	private UserRepository repo;
	
	@RequestMapping("/userdetails")
	public String userDetails(Model model) {
		List<User> listUse = repo.findAll();
		model.addAttribute("listUser",listUse);
		return "User_details";
	}
}
