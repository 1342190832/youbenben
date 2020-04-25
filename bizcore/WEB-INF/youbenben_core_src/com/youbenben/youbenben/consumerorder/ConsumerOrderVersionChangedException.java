
package com.youbenben.youbenben.consumerorder;
import com.youbenben.youbenben.EntityNotFoundException;

public class ConsumerOrderVersionChangedException extends ConsumerOrderManagerException {
	private static final long serialVersionUID = 1L;
	public ConsumerOrderVersionChangedException(String string) {
		super(string);
	}


}


