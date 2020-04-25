package com.youbenben.youbenben.employeeskill;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeSkillSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeSkill>{

	@Override
	public void serialize(EmployeeSkill employeeSkill, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeSkill, provider);
		
	}
}


