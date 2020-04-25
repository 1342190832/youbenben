
package com.youbenben.youbenben.retailstoreorderpicking;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderPickingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderPickingManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderPickingManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderPickingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


