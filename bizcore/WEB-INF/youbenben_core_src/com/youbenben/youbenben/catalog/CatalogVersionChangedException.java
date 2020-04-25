
package com.youbenben.youbenben.catalog;
import com.youbenben.youbenben.EntityNotFoundException;

public class CatalogVersionChangedException extends CatalogManagerException {
	private static final long serialVersionUID = 1L;
	public CatalogVersionChangedException(String string) {
		super(string);
	}


}


