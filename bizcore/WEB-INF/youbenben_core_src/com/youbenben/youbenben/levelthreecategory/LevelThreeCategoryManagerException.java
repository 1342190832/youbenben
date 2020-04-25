
package com.youbenben.youbenben.levelthreecategory;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class LevelThreeCategoryManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public LevelThreeCategoryManagerException(String string) {
		super(string);
	}
	public LevelThreeCategoryManagerException(Message message) {
		super(message);
	}
	public LevelThreeCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


