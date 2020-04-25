
package com.youbenben.youbenben.citycenterdepartment;
import com.youbenben.youbenben.AccessKey;

import com.youbenben.youbenben.BaseGridViewGenerator;

public class CityCenterDepartmentGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for CityCenterDepartment", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(CityCenterDepartment.CITY_CENTER_EMPLOYEE_LIST.equals(listName)){
			return new String[]{"id","name","mobile","email","founded","department","city_center","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(CityCenterDepartment.CITY_CENTER_EMPLOYEE_LIST.equals(listName)){
			return "city_center_employee";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





