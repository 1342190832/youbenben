package com.youbenben.youbenben.publicholiday;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class PublicHolidaySerializer extends YoubenbenObjectPlainCustomSerializer<PublicHoliday>{

	@Override
	public void serialize(PublicHoliday publicHoliday, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, publicHoliday, provider);
		
	}
}


