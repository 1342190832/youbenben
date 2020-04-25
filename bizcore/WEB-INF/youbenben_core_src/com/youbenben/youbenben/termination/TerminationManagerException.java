
package com.youbenben.youbenben.termination;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TerminationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TerminationManagerException(String string) {
		super(string);
	}
	public TerminationManagerException(Message message) {
		super(message);
	}
	public TerminationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


