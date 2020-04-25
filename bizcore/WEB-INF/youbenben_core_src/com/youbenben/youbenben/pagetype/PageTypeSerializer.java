package com.youbenben.youbenben.pagetype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class PageTypeSerializer extends YoubenbenObjectPlainCustomSerializer<PageType>{

	@Override
	public void serialize(PageType pageType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, pageType, provider);
		
	}
}


