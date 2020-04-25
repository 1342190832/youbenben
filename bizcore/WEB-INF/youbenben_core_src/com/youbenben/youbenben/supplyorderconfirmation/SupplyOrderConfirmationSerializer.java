package com.youbenben.youbenben.supplyorderconfirmation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplyOrderConfirmationSerializer extends YoubenbenObjectPlainCustomSerializer<SupplyOrderConfirmation>{

	@Override
	public void serialize(SupplyOrderConfirmation supplyOrderConfirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderConfirmation, provider);
		
	}
}


