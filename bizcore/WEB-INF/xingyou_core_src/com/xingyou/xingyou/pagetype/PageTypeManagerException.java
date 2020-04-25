
package com.xingyou.xingyou.pagetype;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class PageTypeManagerException extends XingyouException {
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


