package com.book.library.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.book.library.model.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
