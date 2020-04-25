
package com.youbenben.youbenben.supplyorderdelivery;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderDeliveryManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderDeliveryManagerException(String string) {
		super(string);
	}
	public SupplyOrderDeliveryManagerException(Message message) {
		super(message);
	}
	public SupplyOrderDeliveryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


