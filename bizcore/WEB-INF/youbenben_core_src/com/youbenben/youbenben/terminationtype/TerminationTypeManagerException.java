
package com.youbenben.youbenben.terminationtype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TerminationTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TerminationTypeManagerException(String string) {
		super(string);
	}
	public TerminationTypeManagerException(Message message) {
		super(message);
	}
	public TerminationTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


