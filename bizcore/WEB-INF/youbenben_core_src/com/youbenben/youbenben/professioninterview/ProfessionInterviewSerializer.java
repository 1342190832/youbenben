package com.youbenben.youbenben.professioninterview;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ProfessionInterviewSerializer extends YoubenbenObjectPlainCustomSerializer<ProfessionInterview>{

	@Override
	public void serialize(ProfessionInterview professionInterview, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, professionInterview, provider);
		
	}
}


