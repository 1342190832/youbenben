package com.youbenben.youbenben.retailstoreorderdelivery;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderDeliverySerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderDelivery>{

	@Override
	public void serialize(RetailStoreOrderDelivery retailStoreOrderDelivery, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderDelivery, provider);
		
	}
}


