
package com.youbenben.youbenben.skilltype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SkillTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SkillTypeManagerException(String string) {
		super(string);
	}
	public SkillTypeManagerException(Message message) {
		super(message);
	}
	public SkillTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


