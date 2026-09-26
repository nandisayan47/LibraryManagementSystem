package com.sayan.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sayan.project.model.Book;
import com.sayan.project.repository.BookRepository;
import java.util.*;
@Service
public class BookServices {
	@Autowired
	BookRepository repo;
	public List<Book> listAll(){
		
		
		List<Book> all=repo.findAll();
		List<Book> availableBooks=new ArrayList<>();
		for(Book b:all) {
			if(b.getFlag()==1) availableBooks.add(b);
			//if(b.isAvailable()) availableBooks.add(b); 
		}
		return availableBooks;
		
		//return repo.findAll();
	}
	public void save(Book book) {
		book.setFlag(1);
		//book.setAvailable(true);
		repo.save(book);
	}
	public Book get(long id) {
		return repo.findById(id).get();
	}
	public void delete(long id) {
		repo.deleteById(id);
	}
	
	public void setAvailabilityToFalse(long id) {
		Book book=repo.getOne(id);
		book.setFlag(0);
		//book.setAvailable(false);
	}
}
