
package com.youbenben.youbenben.employeeattendance;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeAttendanceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeAttendanceManagerException(String string) {
		super(string);
	}
	public EmployeeAttendanceManagerException(Message message) {
		super(message);
	}
	public EmployeeAttendanceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


