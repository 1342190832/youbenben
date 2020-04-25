package com.youbenben.youbenben.retailstoreorder;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrder>{

	@Override
	public void serialize(RetailStoreOrder retailStoreOrder, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrder, provider);
		
	}
}


