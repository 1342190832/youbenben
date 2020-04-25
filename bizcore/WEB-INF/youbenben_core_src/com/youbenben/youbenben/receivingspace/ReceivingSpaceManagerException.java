
package com.youbenben.youbenben.receivingspace;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ReceivingSpaceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ReceivingSpaceManagerException(String string) {
		super(string);
	}
	public ReceivingSpaceManagerException(Message message) {
		super(message);
	}
	public ReceivingSpaceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


