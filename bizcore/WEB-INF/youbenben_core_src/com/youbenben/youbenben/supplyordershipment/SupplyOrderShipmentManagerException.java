
package com.youbenben.youbenben.supplyordershipment;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderShipmentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderShipmentManagerException(String string) {
		super(string);
	}
	public SupplyOrderShipmentManagerException(Message message) {
		super(message);
	}
	public SupplyOrderShipmentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


