
package com.youbenben.youbenben.transportfleet;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TransportFleetManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TransportFleetManagerException(String string) {
		super(string);
	}
	public TransportFleetManagerException(Message message) {
		super(message);
	}
	public TransportFleetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


