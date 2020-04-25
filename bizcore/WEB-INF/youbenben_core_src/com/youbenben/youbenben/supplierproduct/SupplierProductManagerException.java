
package com.youbenben.youbenben.supplierproduct;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplierProductManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplierProductManagerException(String string) {
		super(string);
	}
	public SupplierProductManagerException(Message message) {
		super(message);
	}
	public SupplierProductManagerException(List<Message> messageList) {
		super(messageList);
	}

}


