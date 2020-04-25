
package com.youbenben.youbenben.consumerordershipment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ConsumerOrderShipmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderShipmentManagerException(String string) {
		super(string);
	}
	public ConsumerOrderShipmentManagerException(Message message) {
		super(message);
	}
	public ConsumerOrderShipmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


