package com.youbenben.youbenben.supplyorderpicking;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SupplyOrderPickingSerializer extends YoubenbenObjectPlainCustomSerializer<SupplyOrderPicking>{

	@Override
	public void serialize(SupplyOrderPicking supplyOrderPicking, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderPicking, provider);
		
	}
}


