
package com.youbenben.youbenben.employeeworkexperience;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeWorkExperienceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeWorkExperienceManagerException(String string) {
		super(string);
	}
	public EmployeeWorkExperienceManagerException(Message message) {
		super(message);
	}
	public EmployeeWorkExperienceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


