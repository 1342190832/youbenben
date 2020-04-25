package com.youbenben.youbenben.retailstoreclosing;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class RetailStoreClosingSerializer extends YoubenbenObjectPlainCustomSerializer<RetailStoreClosing>{

	@Override
	public void serialize(RetailStoreClosing retailStoreClosing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreClosing, provider);
		
	}
}


