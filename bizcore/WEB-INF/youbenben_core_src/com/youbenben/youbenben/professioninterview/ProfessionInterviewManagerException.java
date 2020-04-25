
package com.youbenben.youbenben.professioninterview;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ProfessionInterviewManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ProfessionInterviewManagerException(String string) {
		super(string);
	}
	public ProfessionInterviewManagerException(Message message) {
		super(message);
	}
	public ProfessionInterviewManagerException(List<Message> messageList) {
		super(messageList);
	}

}


