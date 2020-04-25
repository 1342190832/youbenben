
package com.youbenben.youbenben.retailstorecreation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreCreationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreCreationManagerException(String string) {
		super(string);
	}
	public RetailStoreCreationManagerException(Message message) {
		super(message);
	}
	public RetailStoreCreationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


