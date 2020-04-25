package com.youbenben.youbenben.truckdriver;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TruckDriverSerializer extends YoubenbenObjectPlainCustomSerializer<TruckDriver>{

	@Override
	public void serialize(TruckDriver truckDriver, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, truckDriver, provider);
		
	}
}


