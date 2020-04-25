
package com.youbenben.youbenben.retailstorememberaddress;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreMemberAddressManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreMemberAddressManagerException(String string) {
		super(string);
	}
	public RetailStoreMemberAddressManagerException(Message message) {
		super(message);
	}
	public RetailStoreMemberAddressManagerException(List<Message> messageList) {
		super(messageList);
	}

}


