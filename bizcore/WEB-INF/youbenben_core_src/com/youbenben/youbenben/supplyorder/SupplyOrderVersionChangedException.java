
package com.youbenben.youbenben.supplyorder;
import com.youbenben.youbenben.EntityNotFoundException;

public class SupplyOrderVersionChangedException extends SupplyOrderManagerException {
	private static final long serialVersionUID = 1L;
	public SupplyOrderVersionChangedException(String string) {
		super(string);
	}


}


