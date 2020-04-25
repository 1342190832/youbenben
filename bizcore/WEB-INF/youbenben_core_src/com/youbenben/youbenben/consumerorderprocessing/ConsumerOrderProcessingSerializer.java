package com.youbenben.youbenben.consumerorderprocessing;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ConsumerOrderProcessingSerializer extends YoubenbenObjectPlainCustomSerializer<ConsumerOrderProcessing>{

	@Override
	public void serialize(ConsumerOrderProcessing consumerOrderProcessing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderProcessing, provider);
		
	}
}


