
package com.youbenben.youbenben.employee;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeManagerException(String string) {
		super(string);
	}
	public EmployeeManagerException(Message message) {
		super(message);
	}
	public EmployeeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


