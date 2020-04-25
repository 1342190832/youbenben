
package com.youbenben.youbenben.retailstoreorderlineitem;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderLineItemManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderLineItemManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderLineItemManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderLineItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}


