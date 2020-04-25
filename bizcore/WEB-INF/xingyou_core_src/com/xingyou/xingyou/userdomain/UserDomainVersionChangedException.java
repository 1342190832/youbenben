
package com.xingyou.xingyou.userdomain;
import com.xingyou.xingyou.EntityNotFoundException;

public class UserDomainVersionChangedException extends UserDomainManagerException {
	private static final long serialVersionUID = 1L;
	public UserDomainVersionChangedException(String string) {
		super(string);
	}


}


