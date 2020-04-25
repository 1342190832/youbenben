package com.youbenben.youbenben.transportfleet;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TransportFleetSerializer extends YoubenbenObjectPlainCustomSerializer<TransportFleet>{

	@Override
	public void serialize(TransportFleet transportFleet, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transportFleet, provider);
		
	}
}


