
package com.youbenben.youbenben.terminationreason;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TerminationReasonManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TerminationReasonManagerException(String string) {
		super(string);
	}
	public TerminationReasonManagerException(Message message) {
		super(message);
	}
	public TerminationReasonManagerException(List<Message> messageList) {
		super(messageList);
	}

}


