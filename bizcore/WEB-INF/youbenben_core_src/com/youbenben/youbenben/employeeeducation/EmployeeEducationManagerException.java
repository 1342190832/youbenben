
package com.youbenben.youbenben.employeeeducation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeEducationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeEducationManagerException(String string) {
		super(string);
	}
	public EmployeeEducationManagerException(Message message) {
		super(message);
	}
	public EmployeeEducationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


