
package com.youbenben.youbenben.slide;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SlideManagerException extends YoubenbenException {
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


