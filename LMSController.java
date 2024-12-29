package com.sayan.lms.controller;

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

import com.sayan.lms.entity.Book;
import com.sayan.lms.entity.UserDtls;
import com.sayan.lms.service.BookServices;
import com.sayan.lms.service.UserService;

@Controller
public class LMSController {
	@Autowired
	private BookServices service;
	@GetMapping("/")
	public String home(Model m) {
		List<Book> book=service.getAllBook();
		m.addAttribute("book",book);
		return "index";
	}
	
	@GetMapping("/user")
	public String userHome(Model m) {
		List<Book> book=service.getAllBook();
		m.addAttribute("book",book);
		return "userindex";
	}
	
	@GetMapping("/addbook")
	public String addBookForm() {
		return "add_book";
	}
	
	@PostMapping("/register")
	public String bookRegister(@ModelAttribute Book b) {
		service.addBook(b);
		return "add_book";
	}
	
	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable int id,Model m) {
		Book b=service.getBookById(id);
		m.addAttribute("book", b);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateBook(@ModelAttribute Book b) {
		service.addBook(b);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String showLoginPage() {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication==null || authentication instanceof AnonymousAuthenticationToken) {
			return "/login";
		}
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
	@PostMapping("/createUsers")
	public String createuser(@ModelAttribute UserDtls user) {
		userService.createUser(user);
		return "redirect:/register";
    }
}
