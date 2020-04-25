package com.youbenben.youbenben.employeequalifier;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeQualifierSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeQualifier>{

	@Override
	public void serialize(EmployeeQualifier employeeQualifier, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeQualifier, provider);
		
	}
}


