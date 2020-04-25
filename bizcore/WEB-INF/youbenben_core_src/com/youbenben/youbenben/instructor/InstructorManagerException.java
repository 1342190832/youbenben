
package com.youbenben.youbenben.instructor;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class InstructorManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public InstructorManagerException(String string) {
		super(string);
	}
	public InstructorManagerException(Message message) {
		super(message);
	}
	public InstructorManagerException(List<Message> messageList) {
		super(messageList);
	}

}


