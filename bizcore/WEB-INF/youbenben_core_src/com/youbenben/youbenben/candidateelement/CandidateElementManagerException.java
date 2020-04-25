
package com.youbenben.youbenben.candidateelement;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class CandidateElementManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public CandidateElementManagerException(String string) {
		super(string);
	}
	public CandidateElementManagerException(Message message) {
		super(message);
	}
	public CandidateElementManagerException(List<Message> messageList) {
		super(messageList);
	}

}


