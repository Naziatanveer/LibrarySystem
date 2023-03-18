package com.book.library.Utility;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;

public class Utilities {
	
	public String getTransactionId() {
		UUID uuid=UUID.randomUUID();
		String transactionId = uuid.toString();
		return transactionId;
	}
	public Timestamp getDateTime() {
		Date date = new Date(System.currentTimeMillis());  
        Timestamp ts=new Timestamp(date.getTime());
        return ts;
	}

}
