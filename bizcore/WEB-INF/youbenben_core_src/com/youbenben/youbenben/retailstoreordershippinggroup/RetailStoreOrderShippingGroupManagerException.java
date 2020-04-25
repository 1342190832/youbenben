
package com.youbenben.youbenben.retailstoreordershippinggroup;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderShippingGroupManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderShippingGroupManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderShippingGroupManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderShippingGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


