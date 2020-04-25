package com.youbenben.youbenben.terminationtype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TerminationTypeSerializer extends YoubenbenObjectPlainCustomSerializer<TerminationType>{

	@Override
	public void serialize(TerminationType terminationType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, terminationType, provider);
		
	}
}


