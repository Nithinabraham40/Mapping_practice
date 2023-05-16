package com.tutorial.mapping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tutorial.mapping.dao.BookDao;
import com.tutorial.mapping.model.Book;
import com.tutorial.mapping.model.Student;
import com.tutorial.mapping.repository.BookRepository;
import com.tutorial.mapping.repository.StudentRepo;

@Service
public class BookService {

	
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	
	


	public ResponseEntity<List<Book>> getAllBooks() {
		
		List<Book>allbooks=bookRepo.findAll();
		
		
		return new ResponseEntity<List<Book>>(allbooks,HttpStatus.OK);
	}


	public ResponseEntity<String> addBookOnly(BookDao bookDao) {
		
		Book book=new Book();
		book.setAuthor(bookDao.getAuthor());
		book.setDescription(bookDao.getDescription());
		book.setPrice(bookDao.getPrice());
		book.setTitle(bookDao.getTitle());
		
		bookRepo.save(book);
		
		
		return new ResponseEntity<String>("Added sucessfully",HttpStatus.OK);
	}

}
