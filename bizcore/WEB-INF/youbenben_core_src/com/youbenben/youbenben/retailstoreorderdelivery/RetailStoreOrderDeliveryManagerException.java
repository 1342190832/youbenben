
package com.youbenben.youbenben.retailstoreorderdelivery;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderDeliveryManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderDeliveryManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderDeliveryManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderDeliveryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


