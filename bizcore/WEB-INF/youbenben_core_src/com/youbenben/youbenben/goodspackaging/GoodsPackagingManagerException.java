
package com.youbenben.youbenben.goodspackaging;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class GoodsPackagingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public GoodsPackagingManagerException(String string) {
		super(string);
	}
	public GoodsPackagingManagerException(Message message) {
		super(message);
	}
	public GoodsPackagingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


