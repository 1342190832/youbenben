
package com.youbenben.youbenben.mobileapp;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class MobileAppManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public MobileAppManagerException(String string) {
		super(string);
	}
	public MobileAppManagerException(Message message) {
		super(message);
	}
	public MobileAppManagerException(List<Message> messageList) {
		super(messageList);
	}

}


