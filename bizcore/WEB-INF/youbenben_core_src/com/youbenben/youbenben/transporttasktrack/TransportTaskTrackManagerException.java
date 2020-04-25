
package com.youbenben.youbenben.transporttasktrack;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TransportTaskTrackManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TransportTaskTrackManagerException(String string) {
		super(string);
	}
	public TransportTaskTrackManagerException(Message message) {
		super(message);
	}
	public TransportTaskTrackManagerException(List<Message> messageList) {
		super(messageList);
	}

}


