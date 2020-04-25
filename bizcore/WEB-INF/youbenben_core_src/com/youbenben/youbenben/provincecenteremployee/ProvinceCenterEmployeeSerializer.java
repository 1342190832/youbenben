package com.youbenben.youbenben.provincecenteremployee;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ProvinceCenterEmployeeSerializer extends YoubenbenObjectPlainCustomSerializer<ProvinceCenterEmployee>{

	@Override
	public void serialize(ProvinceCenterEmployee provinceCenterEmployee, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, provinceCenterEmployee, provider);
		
	}
}


