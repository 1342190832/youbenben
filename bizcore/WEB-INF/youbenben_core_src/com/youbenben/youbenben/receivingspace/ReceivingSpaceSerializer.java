package com.youbenben.youbenben.receivingspace;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ReceivingSpaceSerializer extends YoubenbenObjectPlainCustomSerializer<ReceivingSpace>{

	@Override
	public void serialize(ReceivingSpace receivingSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, receivingSpace, provider);
		
	}
}


