
package com.youbenben.youbenben.levelthreedepartment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class LevelThreeDepartmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public LevelThreeDepartmentManagerException(String string) {
		super(string);
	}
	public LevelThreeDepartmentManagerException(Message message) {
		super(message);
	}
	public LevelThreeDepartmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


