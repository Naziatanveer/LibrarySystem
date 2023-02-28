package com.book.library.Utility;

import java.util.UUID;

public class Utilities {
	
	public String getTransactionId() {
		UUID uuid=UUID.randomUUID();
		String transactionId = uuid.toString();
		return transactionId;
	}

}
