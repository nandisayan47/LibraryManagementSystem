package com.sayan.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sayan.lms.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
