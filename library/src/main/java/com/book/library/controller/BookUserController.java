package com.book.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.model.BookUser;
import com.book.library.service.BookUserService;



@RestController
public class BookUserController {
	
	@Autowired
	BookUserService userService;
	
	@PostMapping
	BookUser addUserDetails(@RequestBody BookUser user) {
		userService.addBookUser(user);
		return user;
	}
	

}
