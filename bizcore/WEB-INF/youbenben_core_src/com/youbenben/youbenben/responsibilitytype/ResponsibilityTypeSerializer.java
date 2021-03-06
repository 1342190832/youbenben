package com.youbenben.youbenben.responsibilitytype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ResponsibilityTypeSerializer extends YoubenbenObjectPlainCustomSerializer<ResponsibilityType>{

	@Override
	public void serialize(ResponsibilityType responsibilityType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, responsibilityType, provider);
		
	}
}


