package com.youbenben.youbenben.cityevent;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class CityEventSerializer extends YoubenbenObjectPlainCustomSerializer<CityEvent>{

	@Override
	public void serialize(CityEvent cityEvent, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, cityEvent, provider);
		
	}
}


