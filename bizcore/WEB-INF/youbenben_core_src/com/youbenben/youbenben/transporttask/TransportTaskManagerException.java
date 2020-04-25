
package com.youbenben.youbenben.transporttask;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TransportTaskManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TransportTaskManagerException(String string) {
		super(string);
	}
	public TransportTaskManagerException(Message message) {
		super(message);
	}
	public TransportTaskManagerException(List<Message> messageList) {
		super(messageList);
	}

}


