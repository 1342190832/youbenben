package com.youbenben.youbenben.consumerorder;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ConsumerOrderSerializer extends YoubenbenObjectPlainCustomSerializer<ConsumerOrder>{

	@Override
	public void serialize(ConsumerOrder consumerOrder, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrder, provider);
		
	}
}


