
package com.youbenben.youbenben.storagespace;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class StorageSpaceManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public StorageSpaceManagerException(String string) {
		super(string);
	}
	public StorageSpaceManagerException(Message message) {
		super(message);
	}
	public StorageSpaceManagerException(List<Message> messageList) {
		super(messageList);
	}

}


