
package com.youbenben.youbenben.employeeaward;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeAwardManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeAwardManagerException(String string) {
		super(string);
	}
	public EmployeeAwardManagerException(Message message) {
		super(message);
	}
	public EmployeeAwardManagerException(List<Message> messageList) {
		super(messageList);
	}

}


