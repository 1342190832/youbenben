
package com.youbenben.youbenben.leveltwocategory;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class LevelTwoCategoryManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public LevelTwoCategoryManagerException(String string) {
		super(string);
	}
	public LevelTwoCategoryManagerException(Message message) {
		super(message);
	}
	public LevelTwoCategoryManagerException(List<Message> messageList) {
		super(messageList);
	}

}


