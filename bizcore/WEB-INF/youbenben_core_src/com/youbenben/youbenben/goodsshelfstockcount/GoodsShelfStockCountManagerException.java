
package com.youbenben.youbenben.goodsshelfstockcount;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class GoodsShelfStockCountManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public GoodsShelfStockCountManagerException(String string) {
		super(string);
	}
	public GoodsShelfStockCountManagerException(Message message) {
		super(message);
	}
	public GoodsShelfStockCountManagerException(List<Message> messageList) {
		super(messageList);
	}

}


