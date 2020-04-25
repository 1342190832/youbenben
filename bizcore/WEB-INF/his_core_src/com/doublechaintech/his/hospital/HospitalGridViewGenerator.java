
package com.doublechaintech.his.hospital;
import com.doublechaintech.his.AccessKey;

import com.doublechaintech.his.BaseGridViewGenerator;

public class HospitalGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for Hospital", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(Hospital.EXPENSE_TYPE_LIST.equals(listName)){
			return new String[]{"id","name","helper_chars","status","hospital","description","update_time","version"};
		}
		if(Hospital.PERIOD_LIST.equals(listName)){
			return new String[]{"id","name","code","hospital","version"};
		}
		if(Hospital.EXPENSE_ITEM_LIST.equals(listName)){
			return new String[]{"id","name","price","expense_type","hospital","update_time","version"};
		}
		if(Hospital.DOCTOR_LIST.equals(listName)){
			return new String[]{"id","name","shot_image","hospital","update_time","version"};
		}
		if(Hospital.DEPARTMENT_LIST.equals(listName)){
			return new String[]{"id","name","hospital","update_time","version"};
		}
		if(Hospital.DOCTOR_SCHEDULE_LIST.equals(listName)){
			return new String[]{"id","name","doctor","schedule_date","period","department","available","price","expense_type","create_time","update_time","hospital","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(Hospital.EXPENSE_TYPE_LIST.equals(listName)){
			return "expense_type";
		}
		if(Hospital.PERIOD_LIST.equals(listName)){
			return "period";
		}
		if(Hospital.EXPENSE_ITEM_LIST.equals(listName)){
			return "expense_item";
		}
		if(Hospital.DOCTOR_LIST.equals(listName)){
			return "doctor";
		}
		if(Hospital.DEPARTMENT_LIST.equals(listName)){
			return "department";
		}
		if(Hospital.DOCTOR_SCHEDULE_LIST.equals(listName)){
			return "doctor_schedule";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





