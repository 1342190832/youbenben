package com.youbenben.youbenben.employeeboarding;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeBoardingSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeBoarding>{

	@Override
	public void serialize(EmployeeBoarding employeeBoarding, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeBoarding, provider);
		
	}
}


