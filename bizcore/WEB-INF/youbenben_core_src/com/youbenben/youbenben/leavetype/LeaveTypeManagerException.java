
package com.youbenben.youbenben.leavetype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class LeaveTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public LeaveTypeManagerException(String string) {
		super(string);
	}
	public LeaveTypeManagerException(Message message) {
		super(message);
	}
	public LeaveTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


