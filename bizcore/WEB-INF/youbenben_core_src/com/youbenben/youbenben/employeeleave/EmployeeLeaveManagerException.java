
package com.youbenben.youbenben.employeeleave;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeLeaveManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeLeaveManagerException(String string) {
		super(string);
	}
	public EmployeeLeaveManagerException(Message message) {
		super(message);
	}
	public EmployeeLeaveManagerException(List<Message> messageList) {
		super(messageList);
	}

}


