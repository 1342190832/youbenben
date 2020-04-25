package com.youbenben.youbenben.retailstoreordershippinggroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderShippingGroupSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderShippingGroup>{

	@Override
	public void serialize(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderShippingGroup, provider);
		
	}
}


