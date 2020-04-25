
package com.youbenben.youbenben.consumerordershippinggroup;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderShippingGroupManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderShippingGroupManagerException(String string) {
		super(string);
	}
	public ConsumerOrderShippingGroupManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderShippingGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


