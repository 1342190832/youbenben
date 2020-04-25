package com.youbenben.youbenben.warehouse;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class WarehouseSerializer extends YoubenbenObjectPlainCustomSerializer<Warehouse>{

	@Override
	public void serialize(Warehouse warehouse, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, warehouse, provider);
		
	}
}


