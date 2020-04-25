
package com.youbenben.youbenben.supplyordershippinggroup;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderShippingGroupManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderShippingGroupManagerException(String string) {
		super(string);
	}
	public SupplyOrderShippingGroupManagerException(Message message) {
		super(message);
	}
	public SupplyOrderShippingGroupManagerException(List<Message> messageList) {
		super(messageList);
	}

}


