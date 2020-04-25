
package com.youbenben.youbenben.productsupplyduration;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ProductSupplyDurationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ProductSupplyDurationManagerException(String string) {
		super(string);
	}
	public ProductSupplyDurationManagerException(Message message) {
		super(message);
	}
	public ProductSupplyDurationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


