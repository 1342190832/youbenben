
package com.youbenben.youbenben.page;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class PageManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public PageManagerException(String string) {
		super(string);
	}
	public PageManagerException(Message message) {
		super(message);
	}
	public PageManagerException(List<Message> messageList) {
		super(messageList);
	}

}


