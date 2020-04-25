
package com.xingyou.xingyou.eventattendance;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class EventAttendanceManagerException extends XingyouException {
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


