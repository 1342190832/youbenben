package com.youbenben.youbenben.employeeleave;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeLeaveSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeLeave>{

	@Override
	public void serialize(EmployeeLeave employeeLeave, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeLeave, provider);
		
	}
}


