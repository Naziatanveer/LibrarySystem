package com.book.library.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.library.model.BookUser;
import com.book.library.service.BookUserService;



@RestController
@RequestMapping(path = "bookUser")
public class BookUserController {
	
	@Autowired
	BookUserService userService;
	
	@PostMapping(path="/addUserInfo", produces = "application/json")
	BookUser addUserInfo(@RequestBody BookUser user) {
		userService.addBookUser(user);
		return user;
	}
	
	
	@PutMapping(path="/returnBookUserInfo", produces = "application/json")
	BookUser returnBookUserInfo(@RequestBody BookUser user) {
		userService.returnBookUser(user);
		return user;
	}
	
	
	@GetMapping(path="/getUserById/{id}", produces = "application/json")
	Optional<BookUser> getUserById(@PathVariable String id){
	return userService.getUserById(id);
		
	}

}
