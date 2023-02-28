package com.book.library.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.library.Utility.Utilities;
import com.book.library.database.UserRepository;
import com.book.library.model.BookUser;

@Service
public class BookUserService {
	@Autowired
	UserRepository userRepo;
	
	Utilities ut=new Utilities();
	
	@Autowired
	BookUser user;
	
	public void addBookUser(BookUser user) {
		
		user.setTransactionId(ut.getTransactionId());
		user.setDate(new Date(System.currentTimeMillis()));
		user.setBookReturned(true);
		userRepo.save(user);
		
	}
	public void returnBookUser(BookUser user)
	{
		if(userRepo.findBookUser(user.getUserId(),user.getBookId())!=null)
		{
			user.setTransactionId(ut.getTransactionId());
			user.setDate(new Date(System.currentTimeMillis()));
			user.setBookReturned(false);
			userRepo.save(user);
		}
	
	}
	
	public Optional<BookUser> getUserById(String transactionId){
		return userRepo.findById(transactionId);
	}
	
	
	public void addBulkBookUsers(List<BookUser> listOfUsers) {
		
		for(BookUser b: listOfUsers) {
			b.setTransactionId(ut.getTransactionId());
			userRepo.save(b);
		}
		
	}
}
