
package com.youbenben.youbenben.termination;
import com.youbenben.youbenben.AccessKey;

import com.youbenben.youbenben.BaseGridViewGenerator;

public class TerminationGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for Termination", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(Termination.EMPLOYEE_LIST.equals(listName)){
			return new String[]{"id","company","title","department","family_name","given_name","email","city","address","cell_phone","occupation","responsible_for","current_salary_grade","salary_account","job_application","profession_interview","hr_interview","offer_approval","offer_acceptance","employee_boarding","termination","last_update_time","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(Termination.EMPLOYEE_LIST.equals(listName)){
			return "employee";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





