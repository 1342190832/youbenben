package com.youbenben.youbenben.employeeattendance;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeAttendanceSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeAttendance>{

	@Override
	public void serialize(EmployeeAttendance employeeAttendance, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeAttendance, provider);
		
	}
}


