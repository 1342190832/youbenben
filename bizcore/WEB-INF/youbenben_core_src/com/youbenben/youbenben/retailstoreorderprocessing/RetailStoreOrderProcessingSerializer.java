package com.youbenben.youbenben.retailstoreorderprocessing;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderProcessingSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderProcessing>{

	@Override
	public void serialize(RetailStoreOrderProcessing retailStoreOrderProcessing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderProcessing, provider);
		
	}
}


