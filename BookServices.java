package com.sayan.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayan.lms.entity.Book;
import com.sayan.lms.repository.BookRepository;

@Service
public class BookServices {
	@Autowired
	private BookRepository repo;
	public void addBook(Book b) {
		repo.save(b);
	}
	
	public List<Book> getAllBook(){
		return repo.findAll();
	}
	
	public Book getBookById(int id) {
		return repo.findById((long) id).get();
	}
	
	public void delete(int id) {
		repo.deleteById((long) id);
	}
}
