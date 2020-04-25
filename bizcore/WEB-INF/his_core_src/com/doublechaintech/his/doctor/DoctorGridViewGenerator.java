
package com.doublechaintech.his.doctor;
import com.doublechaintech.his.AccessKey;

import com.doublechaintech.his.BaseGridViewGenerator;

public class DoctorGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for Doctor", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(Doctor.DOCTOR_ASSIGNMENT_LIST.equals(listName)){
			return new String[]{"id","name","doctor","department","update_time","version"};
		}
		if(Doctor.DOCTOR_SCHEDULE_LIST.equals(listName)){
			return new String[]{"id","name","doctor","schedule_date","period","department","available","price","expense_type","create_time","update_time","hospital","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(Doctor.DOCTOR_ASSIGNMENT_LIST.equals(listName)){
			return "doctor_assignment";
		}
		if(Doctor.DOCTOR_SCHEDULE_LIST.equals(listName)){
			return "doctor_schedule";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





