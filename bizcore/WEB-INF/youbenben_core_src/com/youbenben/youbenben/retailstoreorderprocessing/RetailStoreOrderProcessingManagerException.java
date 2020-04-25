
package com.youbenben.youbenben.retailstoreorderprocessing;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderProcessingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderProcessingManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderProcessingManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderProcessingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


