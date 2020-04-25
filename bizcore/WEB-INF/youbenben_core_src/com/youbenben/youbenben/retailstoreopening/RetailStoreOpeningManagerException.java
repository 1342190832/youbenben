
package com.youbenben.youbenben.retailstoreopening;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOpeningManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOpeningManagerException(String string) {
		super(string);
	}
	public RetailStoreOpeningManagerException(Message message) {
		super(message);
	}
	public RetailStoreOpeningManagerException(List<Message> messageList) {
		super(messageList);
	}

}


