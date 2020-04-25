
package com.youbenben.youbenben.product;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class ProductManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public ProductManagerException(String string) {
		super(string);
	}
	public ProductManagerException(Message message) {
		super(message);
	}
	public ProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


