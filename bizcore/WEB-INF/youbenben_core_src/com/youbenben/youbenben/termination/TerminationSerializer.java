package com.youbenben.youbenben.termination;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TerminationSerializer extends YoubenbenObjectPlainCustomSerializer<Termination>{

	@Override
	public void serialize(Termination termination, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, termination, provider);
		
	}
}


