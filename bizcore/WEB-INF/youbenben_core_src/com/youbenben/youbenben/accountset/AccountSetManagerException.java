
package com.youbenben.youbenben.accountset;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountSetManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountSetManagerException(String string) {
		super(string);
	}
	public AccountSetManagerException(Message message) {
		super(message);
	}
	public AccountSetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


