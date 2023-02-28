package com.book.library.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.model.BookRecords;
import com.book.library.model.BookUser;
import com.book.library.service.BookRecordsService;

@RestController
@RequestMapping(path = "bookRecords")
public class BookRecordsController {
	
	@Autowired
	BookRecordsService recordsService;
	
	@PostMapping(path="/addBookRecords", produces = "application/json")
	BookRecords addBookRecords(@RequestBody BookRecords bookRecord) {
		recordsService.incrementBookCount(bookRecord);
		return bookRecord;
	}
	
	@GetMapping(path="/getBookRecords", produces = "application/json")
	Optional<BookRecords> getBookRecords(@PathVariable Long bookId)
	{
		return recordsService.getBookRecords(bookId);
		
	}

}
