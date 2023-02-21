package com.book.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class BookUser {
	
	@Id
	private String transactionId;
	private long userId;
	private long bookId;
	private String date;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	

	
}
