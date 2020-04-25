package com.youbenben.youbenben.retailstoredecoration;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreDecorationSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreDecoration>{

	@Override
	public void serialize(RetailStoreDecoration retailStoreDecoration, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreDecoration, provider);
		
	}
}


