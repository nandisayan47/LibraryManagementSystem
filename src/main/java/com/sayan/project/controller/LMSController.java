//package com.sayan.project.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.sayan.lms.entity.Book;
//import com.sayan.lms.service.BookServices;
//
//import jakarta.servlet.http.HttpSession;
//
//@Controller
//public class LMSController {
//	@Autowired
//	private BookServices service;
//	@GetMapping("/")
//	public String home(Model m) {
//		List<Book> book=service.getAllBook();
//		m.addAttribute("book",book);
//		return "index";
//	}
//	
//	@GetMapping("/addbook")
//	public String addBookForm() {
//		return "add_book";
//	}
//	
//	@PostMapping("/register")
//	public String bookRegister(@ModelAttribute Book b) {//,HttpSession session) {
//		service.addBook(b);
//		//session.setAttribute("msg","Book Added Successfully");
//		return "add_book";
//	}
//	
//	@GetMapping("/edit/{id}")
//	public String editBook(@PathVariable int id,Model m) {
//		Book b=service.getBookById(id);
//		m.addAttribute("book", b);
//		return "edit";
//	}
//	
//	@PostMapping("/update")
//	public String updateBook(@ModelAttribute Book b) {//,HttpSession session) {
//		service.addBook(b);
//		//session.setAttribute("msg","Book Info Updated Successfully");
//		return "redirect:/";
//	}
//	
//	@GetMapping("/delete/{id}")
//	public String deleteBook(@PathVariable int id) {//,HttpSession session) {
//		service.delete(id);
//		//session.setAttribute("msg","Book Deleted Successfully");
//		return "redirect:/";
//	}
//}
