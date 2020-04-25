
package com.youbenben.youbenben.employeeperformance;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeePerformanceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeePerformanceManagerException(String string) {
		super(string);
	}
	public EmployeePerformanceManagerException(Message message) {
		super(message);
	}
	public EmployeePerformanceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


