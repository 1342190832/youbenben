package com.youbenben.youbenben.companytraining;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class CompanyTrainingSerializer extends YoubenbenObjectPlainCustomSerializer<CompanyTraining>{

	@Override
	public void serialize(CompanyTraining companyTraining, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, companyTraining, provider);
		
	}
}


