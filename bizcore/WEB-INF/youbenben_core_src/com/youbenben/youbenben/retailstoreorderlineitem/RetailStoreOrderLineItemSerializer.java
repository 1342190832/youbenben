package com.youbenben.youbenben.retailstoreorderlineitem;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderLineItemSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderLineItem>{

	@Override
	public void serialize(RetailStoreOrderLineItem retailStoreOrderLineItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderLineItem, provider);
		
	}
}


