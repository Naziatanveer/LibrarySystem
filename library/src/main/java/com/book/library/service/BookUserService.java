package com.book.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.library.Utility.Utilities;
import com.book.library.database.UserRepository;
import com.book.library.model.BookUser;

@Service
public class BookUserService {
	@Autowired
	UserRepository userRepo;
	@Autowired
	BookRecordsService bookRecordsService;

	Utilities ut = new Utilities();

	@Autowired
	BookUser user;

	public void addBookUser(BookUser user) {

		if (userRepo.findBookUser(user.getUserId(), user.getBookId()).isEmpty()
				|| userRepo.findBookStatus(user.getUserId(), user.getBookId()) == true) {
			user.setTransactionId(ut.getTransactionId());
			user.setDate(ut.getDateTime());
			user.setBookReturned(false);
			userRepo.save(user);
			bookRecordsService.decrementBookCount(user.getBookId(), 1);
		} else {
			System.out.println("Book can not be taken");
		}

	}

	public void returnBookUser(BookUser user) {
		if (userRepo.findBookUser(user.getUserId(), user.getBookId()) != null
				&& userRepo.findBookStatus(user.getUserId(), user.getBookId()) == false) {
			user.setTransactionId(ut.getTransactionId());
			user.setDate(ut.getDateTime());
			user.setBookReturned(true);
			userRepo.save(user);
			bookRecordsService.incrementBookCount(user.getBookId(), 1);
		} else {
			System.out.println("Book can not be returned");
		}

	}

	public Optional<BookUser> getUserById(String transactionId) {
		return userRepo.findById(transactionId);
	}

	public void addBulkBookUsers(List<BookUser> listOfUsers) {

		for (BookUser b : listOfUsers) {
			b.setTransactionId(ut.getTransactionId());
			userRepo.save(b);
		}

	}
}
