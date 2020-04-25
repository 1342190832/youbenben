package com.youbenben.youbenben.catalog;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class CatalogSerializer extends YoubenbenObjectPlainCustomSerializer<Catalog>{

	@Override
	public void serialize(Catalog catalog, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, catalog, provider);
		
	}
}


