package com.youbenben.youbenben.supplyorderlineitem;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplyOrderLineItemSerializer extends YoubenbenObjectPlainCustomSerializer<SupplyOrderLineItem>{

	@Override
	public void serialize(SupplyOrderLineItem supplyOrderLineItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderLineItem, provider);
		
	}
}


