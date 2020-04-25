
package com.youbenben.youbenben.accountingsubject;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingSubjectManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingSubjectManagerException(String string) {
		super(string);
	}
	public AccountingSubjectManagerException(Message message) {
		super(message);
	}
	public AccountingSubjectManagerException(List<Message> messageList) {
		super(messageList);
	}

}


