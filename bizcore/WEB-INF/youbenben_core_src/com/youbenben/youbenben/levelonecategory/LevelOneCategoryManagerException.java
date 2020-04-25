
package com.youbenben.youbenben.levelonecategory;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class LevelOneCategoryManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public LevelOneCategoryManagerException(String string) {
		super(string);
	}
	public LevelOneCategoryManagerException(Message message) {
		super(message);
	}
	public LevelOneCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


