
package com.youbenben.youbenben.eventattendance;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class EventAttendanceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public EventAttendanceManagerException(String string) {
		super(string);
	}
	public EventAttendanceManagerException(Message message) {
		super(message);
	}
	public EventAttendanceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


