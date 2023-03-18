package com.book.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.library.database.BookRecordsRepository;
import com.book.library.database.BookRepository;
import com.book.library.model.Book;
import com.book.library.model.BookRecords;



@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	BookRecordsRepository bookRecRepo;
	
	BookRecords record =new BookRecords();
	
	@Autowired
	BookRecordsService bookRecordsService;
	
	public void addNewBook(Book book) {
		
		bookRepo.save(book);
		record.setBookId(book.getBookId());
		record.setBookCount(20);
		bookRecRepo.save(record);
	}
	public void addExisitingBook(BookRecords bookRecord)
	{
		System.out.println(bookRecord.getBookId()+ " Book detal "+bookRecord.getBookCount());
		bookRecordsService.incrementBookCount(bookRecord.getBookId(),bookRecord.getBookCount());
	}
	
	public List<Book> sendAllBooks(){
		
		return (List<Book>) bookRepo.findAll();
	}
	
	public Optional<Book> getBookByID(long id) {
		
		return bookRepo.findById(id);
	}
	
	public void deleteBookByID(long id) {
		
		bookRepo.deleteById(id);
	}

}
