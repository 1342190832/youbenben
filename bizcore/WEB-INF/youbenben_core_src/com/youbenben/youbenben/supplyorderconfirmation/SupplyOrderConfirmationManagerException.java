
package com.youbenben.youbenben.supplyorderconfirmation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderConfirmationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderConfirmationManagerException(String string) {
		super(string);
	}
	public SupplyOrderConfirmationManagerException(Message message) {
		super(message);
	}
	public SupplyOrderConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


