
package com.youbenben.youbenben.consumerorder;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderManagerException(String string) {
		super(string);
	}
	public ConsumerOrderManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderManagerException(List<Message> messageList) {
		super(messageList);
	}

}


