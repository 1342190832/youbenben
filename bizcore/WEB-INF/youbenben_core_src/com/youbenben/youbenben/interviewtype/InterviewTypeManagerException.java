
package com.youbenben.youbenben.interviewtype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class InterviewTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public InterviewTypeManagerException(String string) {
		super(string);
	}
	public InterviewTypeManagerException(Message message) {
		super(message);
	}
	public InterviewTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


