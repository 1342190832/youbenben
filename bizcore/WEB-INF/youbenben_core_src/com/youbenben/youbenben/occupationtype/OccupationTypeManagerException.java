
package com.youbenben.youbenben.occupationtype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class OccupationTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public OccupationTypeManagerException(String string) {
		super(string);
	}
	public OccupationTypeManagerException(Message message) {
		super(message);
	}
	public OccupationTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


