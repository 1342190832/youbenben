
package com.youbenben.youbenben.salarygrade;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SalaryGradeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SalaryGradeManagerException(String string) {
		super(string);
	}
	public SalaryGradeManagerException(Message message) {
		super(message);
	}
	public SalaryGradeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


