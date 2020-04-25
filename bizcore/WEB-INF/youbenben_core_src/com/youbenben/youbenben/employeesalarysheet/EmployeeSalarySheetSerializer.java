package com.youbenben.youbenben.employeesalarysheet;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeSalarySheetSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeSalarySheet>{

	@Override
	public void serialize(EmployeeSalarySheet employeeSalarySheet, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeSalarySheet, provider);
		
	}
}


