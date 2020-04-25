
package com.youbenben.youbenben.retailstoreclosing;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreClosingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreClosingManagerException(String string) {
		super(string);
	}
	public RetailStoreClosingManagerException(Message message) {
		super(message);
	}
	public RetailStoreClosingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


