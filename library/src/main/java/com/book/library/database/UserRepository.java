package com.book.library.database;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.library.model.BookUser;

@Repository
public interface UserRepository extends CrudRepository<BookUser, String>{
	@Query(value= "Select * from book_user u WHERE u.user_id= :userId and u.book_id= :bookId", nativeQuery = true)
	List<BookUser> findBookUser(@Param("userId") Long userId, @Param("bookId") Long bookId);
}
