
package com.youbenben.youbenben.supplyorderlineitem;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderLineItemManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderLineItemManagerException(String string) {
		super(string);
	}
	public SupplyOrderLineItemManagerException(Message message) {
		super(message);
	}
	public SupplyOrderLineItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}


