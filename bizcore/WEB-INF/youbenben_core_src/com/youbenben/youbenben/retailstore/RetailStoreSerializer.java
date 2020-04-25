package com.youbenben.youbenben.retailstore;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStore>{

	@Override
	public void serialize(RetailStore retailStore, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStore, provider);
		
	}
}


