
package com.youbenben.youbenben.employeeinterview;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeInterviewManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeInterviewManagerException(String string) {
		super(string);
	}
	public EmployeeInterviewManagerException(Message message) {
		super(message);
	}
	public EmployeeInterviewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


