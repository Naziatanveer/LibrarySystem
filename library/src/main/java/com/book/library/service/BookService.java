package com.book.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.library.database.BookRepository;
import com.book.library.model.Book;



@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public void addBook(Book book) {
		
		bookRepo.save(book);		
	}
	
	public List<Book> sendAllBooks(){
		
		return (List<Book>) bookRepo.findAll();
	}
	
	public Optional<Book> getBookByID(Long id) {
		
		return bookRepo.findById(id);
	}
	
	public void deleteBookByID(Long id) {
		
		bookRepo.deleteById(id);
	}

}
