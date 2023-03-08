package com.book.library.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookRecords {
	
	@Id
	private long bookId;
	private int bookCount;
	
	
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}	
	

}
