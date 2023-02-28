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
	

	public void incrementBookCount(BookRecords bookRec) {

		Optional<BookRecords> bookRecord = recordsRepo.findById(bookRec.getBookId());
		if (bookRecord.isPresent()) {

			BookRecords rc = bookRecord.get();
			rc.setBookCount(rc.getBookCount() + bookRec.getBookCount());
			recordsRepo.save(rc);
			
		} 
		else {
			
			BookRecords rc = bookRecord.get();
			rc.setBookId(bookRec.getBookId());
			rc.setBookCount(bookRec.getBookCount());
			recordsRepo.save(bookRec);

		}

	}

	public void decrementBookCount(Long bookId, int count) {

		Optional<BookRecords> bookRecord = recordsRepo.findById(bookId);

		BookRecords rc = bookRecord.get();

		rc.setBookCount(rc.getBookCount() - count);

		recordsRepo.save(rc);
	}
	
	public Optional<BookRecords> getBookRecords(Long bookId){
		return recordsRepo.findById(bookId);
		
	}

}
