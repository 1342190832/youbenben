
package com.youbenben.youbenben.consumerorderprocessing;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderProcessingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderProcessingManagerException(String string) {
		super(string);
	}
	public ConsumerOrderProcessingManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderProcessingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


