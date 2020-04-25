
package com.youbenben.youbenben.warehouseasset;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class WarehouseAssetManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public WarehouseAssetManagerException(String string) {
		super(string);
	}
	public WarehouseAssetManagerException(Message message) {
		super(message);
	}
	public WarehouseAssetManagerException(List<Message> messageList) {
		super(messageList);
	}

}


