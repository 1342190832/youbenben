
package com.youbenben.youbenben.retailstoreorderconfirmation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderConfirmationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderConfirmationManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderConfirmationManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


