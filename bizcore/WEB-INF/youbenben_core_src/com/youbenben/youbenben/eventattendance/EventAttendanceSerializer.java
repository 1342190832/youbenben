package com.youbenben.youbenben.eventattendance;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EventAttendanceSerializer extends YoubenbenObjectPlainCustomSerializer<EventAttendance>{

	@Override
	public void serialize(EventAttendance eventAttendance, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, eventAttendance, provider);
		
	}
}


