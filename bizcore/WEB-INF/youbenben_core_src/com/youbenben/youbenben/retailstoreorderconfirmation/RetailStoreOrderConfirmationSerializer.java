package com.youbenben.youbenben.retailstoreorderconfirmation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderConfirmationSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderConfirmation>{

	@Override
	public void serialize(RetailStoreOrderConfirmation retailStoreOrderConfirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderConfirmation, provider);
		
	}
}


