
package com.xingyou.xingyou.sku;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class SkuManagerException extends XingyouException {
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


