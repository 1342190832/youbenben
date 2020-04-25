
package com.xingyou.xingyou.product;
import com.xingyou.xingyou.EntityNotFoundException;

public class ProductVersionChangedException extends ProductManagerException {
	private static final long serialVersionUID = 1L;
	public ProductVersionChangedException(String string) {
		super(string);
	}


}


