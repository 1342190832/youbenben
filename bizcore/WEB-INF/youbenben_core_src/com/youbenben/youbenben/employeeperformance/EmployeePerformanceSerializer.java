package com.youbenben.youbenben.employeeperformance;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeePerformanceSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeePerformance>{

	@Override
	public void serialize(EmployeePerformance employeePerformance, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeePerformance, provider);
		
	}
}


