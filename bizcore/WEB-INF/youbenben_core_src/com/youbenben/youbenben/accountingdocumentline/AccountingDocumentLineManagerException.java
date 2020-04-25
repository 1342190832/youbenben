
package com.youbenben.youbenben.accountingdocumentline;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingDocumentLineManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentLineManagerException(String string) {
		super(string);
	}
	public AccountingDocumentLineManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentLineManagerException(List<Message> messageList) {
		super(messageList);
	}

}


