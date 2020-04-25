
package com.youbenben.youbenben.goodssupplier;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class GoodsSupplierManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public GoodsSupplierManagerException(String string) {
		super(string);
	}
	public GoodsSupplierManagerException(Message message) {
		super(message);
	}
	public GoodsSupplierManagerException(List<Message> messageList) {
		super(messageList);
	}

}


