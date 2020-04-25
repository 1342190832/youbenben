
package com.youbenben.youbenben.consumerorderconfirmation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderConfirmationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderConfirmationManagerException(String string) {
		super(string);
	}
	public ConsumerOrderConfirmationManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


