package com.book.library.database;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.book.library.model.BookRecords;

@Repository
public interface BookRecordsRepository extends CrudRepository<BookRecords, Long>{
//	@Query("SELECT r.book_count FROM book_records r where r.book_id = :id") 
//	int findCountById(@Param("id") Long id);
}
