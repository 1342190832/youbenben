
package com.youbenben.youbenben.transporttruck;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class TransportTruckManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public TransportTruckManagerException(String string) {
		super(string);
	}
	public TransportTruckManagerException(Message message) {
		super(message);
	}
	public TransportTruckManagerException(List<Message> messageList) {
		super(messageList);
	}

}


