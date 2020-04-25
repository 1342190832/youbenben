
package com.youbenben.youbenben.accountset;
import com.youbenben.youbenben.EntityNotFoundException;

public class AccountSetVersionChangedException extends AccountSetManagerException {
	private static final long serialVersionUID = 1L;
	public AccountSetVersionChangedException(String string) {
		super(string);
	}


}


