
package com.xingyou.xingyou.levelthreecategory;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class LevelThreeCategoryManagerException extends XingyouException {
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


