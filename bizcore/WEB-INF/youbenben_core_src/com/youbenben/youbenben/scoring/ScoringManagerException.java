
package com.youbenben.youbenben.scoring;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ScoringManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ScoringManagerException(String string) {
		super(string);
	}
	public ScoringManagerException(Message message) {
		super(message);
	}
	public ScoringManagerException(List<Message> messageList) {
		super(messageList);
	}

}


