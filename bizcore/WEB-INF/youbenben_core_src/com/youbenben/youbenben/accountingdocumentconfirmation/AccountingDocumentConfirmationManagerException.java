
package com.youbenben.youbenben.accountingdocumentconfirmation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingDocumentConfirmationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentConfirmationManagerException(String string) {
		super(string);
	}
	public AccountingDocumentConfirmationManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentConfirmationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


