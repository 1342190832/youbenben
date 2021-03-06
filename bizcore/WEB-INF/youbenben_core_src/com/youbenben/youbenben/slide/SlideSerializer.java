package com.youbenben.youbenben.slide;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SlideSerializer extends YoubenbenObjectPlainCustomSerializer<Slide>{

	@Override
	public void serialize(Slide slide, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, slide, provider);
		
	}
}


