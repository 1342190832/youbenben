
package com.xingyou.xingyou.franchisedoutletcityservicecenter;
import com.xingyou.xingyou.AccessKey;

import com.xingyou.xingyou.BaseGridViewGenerator;

public class FranchisedOutletCityServiceCenterGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for FranchisedOutletCityServiceCenter", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(FranchisedOutletCityServiceCenter.CITY_PARTNER_LIST.equals(listName)){
			return new String[]{"id","name","mobile","town_service_center","description","last_update_time","version"};
		}
		if(FranchisedOutletCityServiceCenter.POTENTIAL_CUSTOMER_LIST.equals(listName)){
			return new String[]{"id","name","mobile","city_service_center","city_partner","description","last_update_time","version"};
		}
		if(FranchisedOutletCityServiceCenter.CITY_EVENT_LIST.equals(listName)){
			return new String[]{"id","name","mobile","city_service_center","description","last_update_time","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(FranchisedOutletCityServiceCenter.CITY_PARTNER_LIST.equals(listName)){
			return "city_partner";
		}
		if(FranchisedOutletCityServiceCenter.POTENTIAL_CUSTOMER_LIST.equals(listName)){
			return "potential_customer";
		}
		if(FranchisedOutletCityServiceCenter.CITY_EVENT_LIST.equals(listName)){
			return "city_event";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





