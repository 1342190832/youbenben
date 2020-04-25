
package com.xingyou.xingyou.uiaction;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class UiActionManagerException extends XingyouException {
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


