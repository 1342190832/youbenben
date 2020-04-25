
package com.youbenben.youbenben.userwhitelist;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class UserWhiteListManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public UserWhiteListManagerException(String string) {
		super(string);
	}
	public UserWhiteListManagerException(Message message) {
		super(message);
	}
	public UserWhiteListManagerException(List<Message> messageList) {
		super(messageList);
	}

}


