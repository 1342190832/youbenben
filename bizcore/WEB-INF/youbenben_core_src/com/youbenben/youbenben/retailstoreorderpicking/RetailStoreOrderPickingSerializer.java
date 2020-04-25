package com.youbenben.youbenben.retailstoreorderpicking;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderPickingSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderPicking>{

	@Override
	public void serialize(RetailStoreOrderPicking retailStoreOrderPicking, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderPicking, provider);
		
	}
}


