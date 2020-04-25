
package com.youbenben.youbenben.leveltwodepartment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class LevelTwoDepartmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public LevelTwoDepartmentManagerException(String string) {
		super(string);
	}
	public LevelTwoDepartmentManagerException(Message message) {
		super(message);
	}
	public LevelTwoDepartmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


