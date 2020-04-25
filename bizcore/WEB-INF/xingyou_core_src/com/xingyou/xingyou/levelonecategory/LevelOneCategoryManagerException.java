
package com.xingyou.xingyou.levelonecategory;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class LevelOneCategoryManagerException extends XingyouException {
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


