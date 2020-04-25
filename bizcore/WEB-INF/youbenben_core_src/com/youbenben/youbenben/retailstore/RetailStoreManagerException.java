
package com.youbenben.youbenben.retailstore;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreManagerException(String string) {
		super(string);
	}
	public RetailStoreManagerException(Message message) {
		super(message);
	}
	public RetailStoreManagerException(List<Message> messageList) {
		super(messageList);
	}

}


