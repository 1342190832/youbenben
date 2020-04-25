
package com.youbenben.youbenben.accountingdocumentcreation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingDocumentCreationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentCreationManagerException(String string) {
		super(string);
	}
	public AccountingDocumentCreationManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentCreationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


