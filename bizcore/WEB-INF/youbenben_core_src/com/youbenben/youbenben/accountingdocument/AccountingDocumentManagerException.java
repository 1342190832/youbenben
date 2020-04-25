
package com.youbenben.youbenben.accountingdocument;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingDocumentManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentManagerException(String string) {
		super(string);
	}
	public AccountingDocumentManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentManagerException(List<Message> messageList) {
		super(messageList);
	}

}


