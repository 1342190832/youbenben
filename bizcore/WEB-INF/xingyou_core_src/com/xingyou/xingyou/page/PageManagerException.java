
package com.xingyou.xingyou.page;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class PageManagerException extends XingyouException {
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


