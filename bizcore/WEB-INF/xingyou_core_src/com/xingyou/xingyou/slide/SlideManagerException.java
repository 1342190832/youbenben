
package com.xingyou.xingyou.slide;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class SlideManagerException extends XingyouException {
	private static final long serialVersionUID = 1L;
	public SlideManagerException(String string) {
		super(string);
	}
	public SlideManagerException(Message message) {
		super(message);
	}
	public SlideManagerException(List<Message> messageList) {
		super(messageList);
	}

}


