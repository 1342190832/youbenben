package com.youbenben.youbenben.employeecompanytraining;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class EmployeeCompanyTrainingSerializer extends YoubenbenObjectPlainCustomSerializer<EmployeeCompanyTraining>{

	@Override
	public void serialize(EmployeeCompanyTraining employeeCompanyTraining, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeCompanyTraining, provider);
		
	}
}


