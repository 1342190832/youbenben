
package com.youbenben.youbenben.supplierspace;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class SupplierSpaceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public SupplierSpaceManagerException(String string) {
		super(string);
	}
	public SupplierSpaceManagerException(Message message) {
		super(message);
	}
	public SupplierSpaceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


