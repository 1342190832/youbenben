package com.youbenben.youbenben.supplyorderprocessing;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplyOrderProcessingSerializer extends YoubenbenObjectPlainCustomSerializer<SupplyOrderProcessing>{

	@Override
	public void serialize(SupplyOrderProcessing supplyOrderProcessing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderProcessing, provider);
		
	}
}


