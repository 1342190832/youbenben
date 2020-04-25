
package com.youbenben.youbenben.responsibilitytype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ResponsibilityTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ResponsibilityTypeManagerException(String string) {
		super(string);
	}
	public ResponsibilityTypeManagerException(Message message) {
		super(message);
	}
	public ResponsibilityTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


