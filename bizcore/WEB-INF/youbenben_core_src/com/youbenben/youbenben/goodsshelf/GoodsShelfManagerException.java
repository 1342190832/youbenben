
package com.youbenben.youbenben.goodsshelf;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class GoodsShelfManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public GoodsShelfManagerException(String string) {
		super(string);
	}
	public GoodsShelfManagerException(Message message) {
		super(message);
	}
	public GoodsShelfManagerException(List<Message> messageList) {
		super(messageList);
	}

}


