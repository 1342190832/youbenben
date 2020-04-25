
package com.youbenben.youbenben.accountingdocumentauditing;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class AccountingDocumentAuditingManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public AccountingDocumentAuditingManagerException(String string) {
		super(string);
	}
	public AccountingDocumentAuditingManagerException(Message message) {
		super(message);
	}
	public AccountingDocumentAuditingManagerException(List<Message> messageList) {
		super(messageList);
	}

}


