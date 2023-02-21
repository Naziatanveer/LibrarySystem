package com.book.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.model.Book;
import com.book.library.service.BookService;




@RestController
@RequestMapping(path = "book")
public class BookController {
	
	@Autowired
	BookService bookservice;
	

	
	@PostMapping(path="/addBook", produces = "application/json")
	Book addBook(@RequestBody Book book) {
				
		bookservice.addBook(book);
		return book;
	}
	
	@GetMapping(path="/getBooks", produces = "application/json")
	List<Book> getALlBooks(){
		
		return bookservice.sendAllBooks();
		
	}
	
	@GetMapping(path="/getBooks/{id}", produces = "application/json")
	Optional<Book> getALlBooks(@PathVariable Long id){
		
		return bookservice.getBookByID(id);
		
	}

	@DeleteMapping(path="/deleteBook/{id}")
	void deleteBook(@PathVariable Long id) {
		
		bookservice.deleteBookByID(id);
	}

	
	
}
