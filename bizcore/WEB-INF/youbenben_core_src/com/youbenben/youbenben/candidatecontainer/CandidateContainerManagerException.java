
package com.youbenben.youbenben.candidatecontainer;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class CandidateContainerManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public CandidateContainerManagerException(String string) {
		super(string);
	}
	public CandidateContainerManagerException(Message message) {
		super(message);
	}
	public CandidateContainerManagerException(List<Message> messageList) {
		super(messageList);
	}

}


