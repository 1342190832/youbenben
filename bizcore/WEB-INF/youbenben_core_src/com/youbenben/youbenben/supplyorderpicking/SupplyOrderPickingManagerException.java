
package com.youbenben.youbenben.supplyorderpicking;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderPickingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderPickingManagerException(String string) {
		super(string);
	}
	public SupplyOrderPickingManagerException(Message message) {
		super(message);
	}
	public SupplyOrderPickingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


