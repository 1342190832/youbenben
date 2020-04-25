
package com.xingyou.xingyou.loginhistory;
import com.xingyou.xingyou.EntityNotFoundException;

public class LoginHistoryVersionChangedException extends LoginHistoryManagerException {
	private static final long serialVersionUID = 1L;
	public LoginHistoryVersionChangedException(String string) {
		super(string);
	}


}


