package com.youbenben.youbenben.employeeeducation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeEducationSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeEducation>{

	@Override
	public void serialize(EmployeeEducation employeeEducation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeEducation, provider);
		
	}
}


