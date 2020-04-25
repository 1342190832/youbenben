
package com.youbenben.youbenben.franchisedoutletcitycenter;
import com.youbenben.youbenben.AccessKey;

import com.youbenben.youbenben.BaseGridViewGenerator;

public class FranchisedOutletCityCenterGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for FranchisedOutletCityCenter", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(FranchisedOutletCityCenter.FRANCHISED_OUTLET_CITY_CENTER_LIST.equals(listName)){
			return new String[]{"id","name","founded","city","last_update_time","version"};
		}
		if(FranchisedOutletCityCenter.CITY_CENTER_DEPARTMENT_LIST.equals(listName)){
			return new String[]{"id","name","founded","city_center","manager","version"};
		}
		if(FranchisedOutletCityCenter.CITY_CENTER_EMPLOYEE_LIST.equals(listName)){
			return new String[]{"id","name","mobile","email","founded","department","city_center","version"};
		}
		if(FranchisedOutletCityCenter.FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST.equals(listName)){
			return new String[]{"id","name","founded","belongs_to","last_update_time","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(FranchisedOutletCityCenter.FRANCHISED_OUTLET_CITY_CENTER_LIST.equals(listName)){
			return "franchised_outlet_city_center";
		}
		if(FranchisedOutletCityCenter.CITY_CENTER_DEPARTMENT_LIST.equals(listName)){
			return "city_center_department";
		}
		if(FranchisedOutletCityCenter.CITY_CENTER_EMPLOYEE_LIST.equals(listName)){
			return "city_center_employee";
		}
		if(FranchisedOutletCityCenter.FRANCHISED_OUTLET_CITY_SERVICE_CENTER_LIST.equals(listName)){
			return "franchised_outlet_city_service_center";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





