
package com.youbenben.youbenben.accountingdocumenttype;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingDocumentTypeManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentTypeManagerException(String string) {
		super(string);
	}
	public AccountingDocumentTypeManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentTypeManagerException(List<Message> messageList) {
		super(messageList);
	}

}


