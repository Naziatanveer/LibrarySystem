package com.book.library.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.library.model.BookUser;

@Repository
public interface UserRepository extends CrudRepository<BookUser, String>{

}
