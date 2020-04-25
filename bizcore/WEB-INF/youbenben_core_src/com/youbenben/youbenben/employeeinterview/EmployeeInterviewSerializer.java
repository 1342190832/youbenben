package com.youbenben.youbenben.employeeinterview;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeInterviewSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeInterview>{

	@Override
	public void serialize(EmployeeInterview employeeInterview, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeInterview, provider);
		
	}
}


