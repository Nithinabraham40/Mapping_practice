package com.tutorial.mapping.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.mapping.dao.BookDao;
import com.tutorial.mapping.model.Book;
import com.tutorial.mapping.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("add/books/only")
	
	public ResponseEntity<String>addBookOnly(@RequestBody BookDao bookDao){
		
		
		return bookService.addBookOnly(bookDao);}
	
	
		
		
		
	
	
	
	
	@GetMapping("get")
	
	public ResponseEntity<List<Book>>getAllBooks(){
		
		return bookService.getAllBooks();
	}
	

}
