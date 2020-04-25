package com.youbenben.youbenben.scoring;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ScoringSerializer extends YoubenbenObjectPlainCustomSerializer<Scoring>{

	@Override
	public void serialize(Scoring scoring, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, scoring, provider);
		
	}
}


