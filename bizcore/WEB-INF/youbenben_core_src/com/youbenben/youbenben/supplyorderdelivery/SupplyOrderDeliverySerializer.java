package com.youbenben.youbenben.supplyorderdelivery;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplyOrderDeliverySerializer extends YoubenbenObjectPlainCustomSerializer<SupplyOrderDelivery>{

	@Override
	public void serialize(SupplyOrderDelivery supplyOrderDelivery, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderDelivery, provider);
		
	}
}


