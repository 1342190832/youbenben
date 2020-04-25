
package com.youbenben.youbenben.goodsmovement;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class GoodsMovementManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public GoodsMovementManagerException(String string) {
		super(string);
	}
	public GoodsMovementManagerException(Message message) {
		super(message);
	}
	public GoodsMovementManagerException(List<Message> messageList) {
		super(messageList);
	}

}


