
package com.doublechaintech.retailscm.supplyorderprocessing;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class SupplyOrderProcessingGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for SupplyOrderProcessing", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(SupplyOrderProcessing.CONSUMER_ORDER_LIST.equals(listName)){
			return new String[]{"id","title","consumer","confirmation","approval","processing","shipment","delivery","store","last_update_time","version"};
		}
		if(SupplyOrderProcessing.SUPPLY_ORDER_LIST.equals(listName)){
			return new String[]{"id","buyer","seller","title","total_amount","confirmation","approval","processing","picking","shipment","delivery","last_update_time","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(SupplyOrderProcessing.CONSUMER_ORDER_LIST.equals(listName)){
			return "consumer_order";
		}
		if(SupplyOrderProcessing.SUPPLY_ORDER_LIST.equals(listName)){
			return "supply_order";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





