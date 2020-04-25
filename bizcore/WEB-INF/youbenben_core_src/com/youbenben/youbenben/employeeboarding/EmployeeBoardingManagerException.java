
package com.youbenben.youbenben.employeeboarding;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeBoardingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeBoardingManagerException(String string) {
		super(string);
	}
	public EmployeeBoardingManagerException(Message message) {
		super(message);
	}
	public EmployeeBoardingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


