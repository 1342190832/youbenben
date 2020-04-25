
package com.youbenben.youbenben.retailstoredecoration;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreDecorationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreDecorationManagerException(String string) {
		super(string);
	}
	public RetailStoreDecorationManagerException(Message message) {
		super(message);
	}
	public RetailStoreDecorationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


