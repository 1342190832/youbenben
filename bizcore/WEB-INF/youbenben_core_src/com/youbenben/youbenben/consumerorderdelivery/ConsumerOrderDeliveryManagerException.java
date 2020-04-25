
package com.youbenben.youbenben.consumerorderdelivery;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderDeliveryManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderDeliveryManagerException(String string) {
		super(string);
	}
	public ConsumerOrderDeliveryManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderDeliveryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


