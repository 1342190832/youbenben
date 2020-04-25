
package com.xingyou.xingyou.product;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class ProductManagerException extends XingyouException {
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


