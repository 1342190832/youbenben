
package com.youbenben.youbenben.product;
import com.youbenben.youbenben.EntityNotFoundException;
public class ProductNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;
	public ProductNotFoundException(String string) {
		super(string);
	}

}

