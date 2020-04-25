
package com.youbenben.youbenben.accountingdocumentposting;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingDocumentPostingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentPostingManagerException(String string) {
		super(string);
	}
	public AccountingDocumentPostingManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentPostingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


