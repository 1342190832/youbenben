
package com.youbenben.youbenben.accountingperiod;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingPeriodManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingPeriodManagerException(String string) {
		super(string);
	}
	public AccountingPeriodManagerException(Message message) {
		super(message);
	}
	public AccountingPeriodManagerException(List<Message> messageList) {
		super(messageList);
	}

}


