package com.youbenben.youbenben.consumerorderlineitem;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.youbenben.youbenben.YoubenbenObjectPlainCustomSerializer;
public class ConsumerOrderLineItemSerializer extends YoubenbenObjectPlainCustomSerializer<ConsumerOrderLineItem>{

	@Override
	public void serialize(ConsumerOrderLineItem consumerOrderLineItem, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderLineItem, provider);
		
	}
}


