package com.book.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.library.database.UserRepository;
import com.book.library.model.BookUser;

@Service
public class BookUserService {
	@Autowired
	UserRepository userRepo;
	
	public void addBookUser(BookUser user) {
		
		userRepo.save(user);
		
	}

}
