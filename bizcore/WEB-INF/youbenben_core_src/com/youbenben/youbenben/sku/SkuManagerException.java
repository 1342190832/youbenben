
package com.youbenben.youbenben.sku;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SkuManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SkuManagerException(String string) {
		super(string);
	}
	public SkuManagerException(Message message) {
		super(message);
	}
	public SkuManagerException(List<Message> messageList) {
		super(messageList);
	}

}


