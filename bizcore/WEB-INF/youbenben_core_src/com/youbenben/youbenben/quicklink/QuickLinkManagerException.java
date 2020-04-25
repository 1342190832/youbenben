
package com.youbenben.youbenben.quicklink;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class QuickLinkManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public QuickLinkManagerException(String string) {
		super(string);
	}
	public QuickLinkManagerException(Message message) {
		super(message);
	}
	public QuickLinkManagerException(List<Message> messageList) {
		super(messageList);
	}

}


