
package com.youbenben.youbenben.retailstoreorder;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderManagerException(List<Message> messageList) {
		super(messageList);
	}

}


