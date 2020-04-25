package com.youbenben.youbenben.retailstoreordershipment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreOrderShipmentSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreOrderShipment>{

	@Override
	public void serialize(RetailStoreOrderShipment retailStoreOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderShipment, provider);
		
	}
}


