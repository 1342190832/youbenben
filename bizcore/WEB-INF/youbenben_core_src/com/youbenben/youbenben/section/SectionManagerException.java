
package com.youbenben.youbenben.section;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SectionManagerException extends YoubenbenException {
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


