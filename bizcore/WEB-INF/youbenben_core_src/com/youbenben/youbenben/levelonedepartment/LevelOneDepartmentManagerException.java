
package com.youbenben.youbenben.levelonedepartment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class LevelOneDepartmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public LevelOneDepartmentManagerException(String string) {
		super(string);
	}
	public LevelOneDepartmentManagerException(Message message) {
		super(message);
	}
	public LevelOneDepartmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


