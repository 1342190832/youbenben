
package com.youbenben.youbenben.goodsallocation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class GoodsAllocationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public GoodsAllocationManagerException(String string) {
		super(string);
	}
	public GoodsAllocationManagerException(Message message) {
		super(message);
	}
	public GoodsAllocationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


