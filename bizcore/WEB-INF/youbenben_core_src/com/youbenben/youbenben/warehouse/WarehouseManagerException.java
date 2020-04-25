
package com.youbenben.youbenben.warehouse;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class WarehouseManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public WarehouseManagerException(String string) {
		super(string);
	}
	public WarehouseManagerException(Message message) {
		super(message);
	}
	public WarehouseManagerException(List<Message> messageList) {
		super(messageList);
	}

}


