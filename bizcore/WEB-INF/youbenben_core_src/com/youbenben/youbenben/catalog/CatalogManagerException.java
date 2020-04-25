
package com.youbenben.youbenben.catalog;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class CatalogManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public CatalogManagerException(String string) {
		super(string);
	}
	public CatalogManagerException(Message message) {
		super(message);
	}
	public CatalogManagerException(List<Message> messageList) {
		super(messageList);
	}

}


