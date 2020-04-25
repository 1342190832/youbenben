
package com.youbenben.youbenben.view;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ViewManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ViewManagerException(String string) {
		super(string);
	}
	public ViewManagerException(Message message) {
		super(message);
	}
	public ViewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


