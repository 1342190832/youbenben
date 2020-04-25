package com.youbenben.youbenben.hrinterview;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class HrInterviewSerializer extends YoubenbenObjectPlainCustomSerializer<HrInterview>{

	@Override
	public void serialize(HrInterview hrInterview, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, hrInterview, provider);
		
	}
}


