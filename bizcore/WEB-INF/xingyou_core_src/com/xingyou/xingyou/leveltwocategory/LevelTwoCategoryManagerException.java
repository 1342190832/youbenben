
package com.xingyou.xingyou.leveltwocategory;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class LevelTwoCategoryManagerException extends XingyouException {
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


