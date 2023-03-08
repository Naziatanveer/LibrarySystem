package com.book.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.model.Book;
import com.book.library.model.BookRecords;
import com.book.library.service.BookRecordsService;
import com.book.library.service.BookService;




@RestController
@RequestMapping(path = "book")
public class BookController {
	
	@Autowired
	BookService bookservice;
	
	@Autowired
	BookRecordsService bookRecordService;

	
	@PostMapping(path="/addNewBook", produces = "application/json")
	Book addNewBook(@RequestBody Book book) {
				
		bookservice.addNewBook(book);
		return book;
	}
	
	@PutMapping(path="/addExistingBook", produces = "application/json")
	BookRecords addExistingBook(@RequestBody BookRecords bookRecord) {
		
		System.out.println(bookRecord.getBookCount() +" SYS out  "+ bookRecord.getBookId());
				
		bookservice.addExisitingBook(bookRecord);
		return bookRecord;
	}
	
	@GetMapping(path="/getBooks", produces = "application/json")
	List<Book> getALlBooks(){
		
		return bookservice.sendAllBooks();
		
	}
	
	@GetMapping(path="/getBooks/{id}", produces = "application/json")
	Optional<Book> getALlBooks(@PathVariable long id){
		
		return bookservice.getBookByID(id);
		
	}

	@DeleteMapping(path="/deleteBook/{id}")
	void deleteBook(@PathVariable Long id) {
		
		bookservice.deleteBookByID(id);
	}

	
	
}
