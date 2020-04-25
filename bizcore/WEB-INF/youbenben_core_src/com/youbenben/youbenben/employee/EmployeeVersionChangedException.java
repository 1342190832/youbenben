
package com.youbenben.youbenben.employee;
import com.youbenben.youbenben.EntityNotFoundException;

public class EmployeeVersionChangedException extends EmployeeManagerException {
	private static final long serialVersionUID = 1L;
	public EmployeeVersionChangedException(String string) {
		super(string);
	}


}


