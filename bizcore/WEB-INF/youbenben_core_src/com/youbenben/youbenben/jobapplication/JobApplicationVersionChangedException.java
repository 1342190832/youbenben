
package com.youbenben.youbenben.jobapplication;
import com.youbenben.youbenben.EntityNotFoundException;

public class JobApplicationVersionChangedException extends JobApplicationManagerException {
	private static final long serialVersionUID = 1L;
	public JobApplicationVersionChangedException(String string) {
		super(string);
	}


}


