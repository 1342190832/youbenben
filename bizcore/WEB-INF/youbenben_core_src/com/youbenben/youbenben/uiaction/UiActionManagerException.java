
package com.youbenben.youbenben.uiaction;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class UiActionManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public UiActionManagerException(String string) {
		super(string);
	}
	public UiActionManagerException(Message message) {
		super(message);
	}
	public UiActionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


