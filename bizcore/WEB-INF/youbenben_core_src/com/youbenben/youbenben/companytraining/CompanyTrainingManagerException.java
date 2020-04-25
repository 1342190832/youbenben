
package com.youbenben.youbenben.companytraining;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class CompanyTrainingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public CompanyTrainingManagerException(String string) {
		super(string);
	}
	public CompanyTrainingManagerException(Message message) {
		super(message);
	}
	public CompanyTrainingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


