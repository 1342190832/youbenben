
package com.youbenben.youbenben.supplyorderprocessing;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplyOrderProcessingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderProcessingManagerException(String string) {
		super(string);
	}
	public SupplyOrderProcessingManagerException(Message message) {
		super(message);
	}
	public SupplyOrderProcessingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


