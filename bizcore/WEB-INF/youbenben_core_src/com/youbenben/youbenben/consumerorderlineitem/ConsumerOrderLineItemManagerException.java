
package com.youbenben.youbenben.consumerorderlineitem;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderLineItemManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderLineItemManagerException(String string) {
		super(string);
	}
	public ConsumerOrderLineItemManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderLineItemManagerException(List<Message> messageList) {
		super(messageList);
	}

}


