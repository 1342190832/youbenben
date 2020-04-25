
package com.youbenben.youbenben.goods;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class GoodsManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public GoodsManagerException(String string) {
		super(string);
	}
	public GoodsManagerException(Message message) {
		super(message);
	}
	public GoodsManagerException(List<Message> messageList) {
		super(messageList);
	}

}


