package com.youbenben.youbenben.employeeworkexperience;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeWorkExperienceSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeWorkExperience>{

	@Override
	public void serialize(EmployeeWorkExperience employeeWorkExperience, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeWorkExperience, provider);
		
	}
}


