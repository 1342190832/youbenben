
package com.youbenben.youbenben.pagetype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class PageTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public PageTypeManagerException(String string) {
		super(string);
	}
	public PageTypeManagerException(Message message) {
		super(message);
	}
	public PageTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


