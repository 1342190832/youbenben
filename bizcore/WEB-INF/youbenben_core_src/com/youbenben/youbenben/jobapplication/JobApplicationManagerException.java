
package com.youbenben.youbenben.jobapplication;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class JobApplicationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public JobApplicationManagerException(String string) {
		super(string);
	}
	public JobApplicationManagerException(Message message) {
		super(message);
	}
	public JobApplicationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


