
package com.xingyou.xingyou.catalog;
//import com.xingyou.xingyou.EntityNotFoundException;
import com.xingyou.xingyou.XingyouException;
import com.xingyou.xingyou.Message;
import java.util.List;

public class CatalogManagerException extends XingyouException {
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


