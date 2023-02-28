package com.book.library.model;

import java.sql.Date;
import java.util.UUID;

import org.springframework.context.annotation.Configuration;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Configuration
@Entity
public class BookUser {
	
	@Id
	private String transactionId;
	private long userId;
	private long bookId;
	private Date date;
	private boolean isBookReturned;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String uuid) {
		this.transactionId = uuid;
	}
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isBookReturned() {
		return isBookReturned;
	}
	public void setBookReturned(boolean isBookReturned) {
		this.isBookReturned = isBookReturned;
	}
	
	
}
