
package com.youbenben.youbenben.employeecompanytraining;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeCompanyTrainingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeCompanyTrainingManagerException(String string) {
		super(string);
	}
	public EmployeeCompanyTrainingManagerException(Message message) {
		super(message);
	}
	public EmployeeCompanyTrainingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


