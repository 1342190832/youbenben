
package com.youbenben.youbenben.employeesalarysheet;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EmployeeSalarySheetManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EmployeeSalarySheetManagerException(String string) {
		super(string);
	}
	public EmployeeSalarySheetManagerException(Message message) {
		super(message);
	}
	public EmployeeSalarySheetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


