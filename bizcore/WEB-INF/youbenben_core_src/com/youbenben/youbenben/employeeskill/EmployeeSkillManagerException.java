
package com.youbenben.youbenben.employeeskill;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeSkillManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeSkillManagerException(String string) {
		super(string);
	}
	public EmployeeSkillManagerException(Message message) {
		super(message);
	}
	public EmployeeSkillManagerException(List<Message> messageList) {
		super(messageList);
	}

}


