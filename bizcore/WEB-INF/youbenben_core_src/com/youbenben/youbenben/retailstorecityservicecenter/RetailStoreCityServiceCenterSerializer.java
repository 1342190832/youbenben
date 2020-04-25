package com.youbenben.youbenben.retailstorecityservicecenter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreCityServiceCenterSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreCityServiceCenter>{

	@Override
	public void serialize(RetailStoreCityServiceCenter retailStoreCityServiceCenter, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreCityServiceCenter, provider);
		
	}
}


