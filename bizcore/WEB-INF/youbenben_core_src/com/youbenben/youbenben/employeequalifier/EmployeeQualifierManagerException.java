
package com.youbenben.youbenben.employeequalifier;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeQualifierManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeQualifierManagerException(String string) {
		super(string);
	}
	public EmployeeQualifierManagerException(Message message) {
		super(message);
	}
	public EmployeeQualifierManagerException(List<Message> messageList) {
		super(messageList);
	}

}


