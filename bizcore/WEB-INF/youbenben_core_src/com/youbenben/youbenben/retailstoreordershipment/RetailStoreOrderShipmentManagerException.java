
package com.youbenben.youbenben.retailstoreordershipment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreOrderShipmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreOrderShipmentManagerException(String string) {
		super(string);
	}
	public RetailStoreOrderShipmentManagerException(Message message) {
		super(message);
	}
	public RetailStoreOrderShipmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


