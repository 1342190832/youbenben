package com.youbenben.youbenben.jobapplication;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class JobApplicationSerializer extends YoubenbenObjectPlainCustomSerializer<JobApplication>{

	@Override
	public void serialize(JobApplication jobApplication, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, jobApplication, provider);
		
	}
}


