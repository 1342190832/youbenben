package com.youbenben.youbenben.retailstoreorderapproval;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderApprovalSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderApproval>{

	@Override
	public void serialize(RetailStoreOrderApproval retailStoreOrderApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderApproval, provider);
		
	}
}


