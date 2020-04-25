
package com.xingyou.xingyou.section;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class SectionManagerException extends XingyouException {
	private static final long serialVersionUID = 1L;
	public SectionManagerException(String string) {
		super(string);
	}
	public SectionManagerException(Message message) {
		super(message);
	}
	public SectionManagerException(List<Message> messageList) {
		super(messageList);
	}

}


