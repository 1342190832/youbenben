package com.youbenben.youbenben.interviewtype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class InterviewTypeSerializer extends YoubenbenObjectPlainCustomSerializer<InterviewType>{

	@Override
	public void serialize(InterviewType interviewType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, interviewType, provider);
		
	}
}


