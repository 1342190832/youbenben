package com.youbenben.youbenben.terminationreason;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class TerminationReasonSerializer extends YoubenbenObjectPlainCustomSerializer<TerminationReason>{

	@Override
	public void serialize(TerminationReason terminationReason, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, terminationReason, provider);
		
	}
}


