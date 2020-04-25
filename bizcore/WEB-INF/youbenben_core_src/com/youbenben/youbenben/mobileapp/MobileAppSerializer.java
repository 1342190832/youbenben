package com.youbenben.youbenben.mobileapp;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class MobileAppSerializer extends YoubenbenObjectPlainCustomSerializer<MobileApp>{

	@Override
	public void serialize(MobileApp mobileApp, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, mobileApp, provider);
		
	}
}


