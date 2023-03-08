package com.book.library.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.library.database.BookRecordsRepository;
import com.book.library.model.BookRecords;

@Service
public class BookRecordsService {

	@Autowired
	BookRecordsRepository recordsRepo;
	
	
	BookRecords rc = new BookRecords();

	public BookRecords incrementBookCount(long bookId, int count) {

		Optional<BookRecords> bookRecord = recordsRepo.findById(bookId);
		if (bookRecord.isPresent()) {
			rc = bookRecord.get();
			rc.setBookCount(rc.getBookCount() + count);
		}
		return recordsRepo.save(rc);
		
	}

	public BookRecords decrementBookCount(long bookId, int count) {

		Optional<BookRecords> bookRecord = recordsRepo.findById(bookId);
		if(bookRecord.isPresent()) {
		rc = bookRecord.get();
		rc.setBookCount(rc.getBookCount() - count);
		}
		return recordsRepo.save(rc);
		
	}

	public Optional<BookRecords> getBookRecords(long bookId) {
		return recordsRepo.findById(bookId);

	}

}
