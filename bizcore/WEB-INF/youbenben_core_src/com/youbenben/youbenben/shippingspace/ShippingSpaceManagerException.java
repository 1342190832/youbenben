
package com.youbenben.youbenben.shippingspace;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ShippingSpaceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ShippingSpaceManagerException(String string) {
		super(string);
	}
	public ShippingSpaceManagerException(Message message) {
		super(message);
	}
	public ShippingSpaceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


