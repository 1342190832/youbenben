package com.youbenben.youbenben.retailstorecreation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreCreationSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreCreation>{

	@Override
	public void serialize(RetailStoreCreation retailStoreCreation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreCreation, provider);
		
	}
}


