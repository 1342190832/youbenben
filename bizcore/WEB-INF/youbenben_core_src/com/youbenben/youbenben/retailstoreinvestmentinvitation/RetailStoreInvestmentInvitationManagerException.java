
package com.youbenben.youbenben.retailstoreinvestmentinvitation;
//import com.youbenben.youbenben.EntityNotFoundException;
import com.youbenben.youbenben.YoubenbenException;
import com.youbenben.youbenben.Message;
import java.util.List;

public class RetailStoreInvestmentInvitationManagerException extends YoubenbenException {
	private static final long serialVersionUID = 1L;
	public RetailStoreInvestmentInvitationManagerException(String string) {
		super(string);
	}
	public RetailStoreInvestmentInvitationManagerException(Message message) {
		super(message);
	}
	public RetailStoreInvestmentInvitationManagerException(List<Message> messageList) {
		super(messageList);
	}

}


