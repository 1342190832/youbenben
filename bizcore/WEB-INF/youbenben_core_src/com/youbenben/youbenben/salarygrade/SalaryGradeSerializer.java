package com.youbenben.youbenben.salarygrade;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class SalaryGradeSerializer extends YoubenbenObjectPlainCustomSerializer<SalaryGrade>{

	@Override
	public void serialize(SalaryGrade salaryGrade, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, salaryGrade, provider);
		
	}
}


